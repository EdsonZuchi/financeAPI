package io.github.edsonzuchi.FinanceAPI.account.domain.usecases.implementation

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import io.github.edsonzuchi.FinanceAPI.account.domain.entity.TypeAccount
import io.github.edsonzuchi.FinanceAPI.account.domain.exceptions.*
import io.github.edsonzuchi.FinanceAPI.account.domain.repository.AccountRepository
import io.github.edsonzuchi.FinanceAPI.account.domain.repository.TypeAccountRepository
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.TypeAccountUseCase
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.ListTypeAccountResponse
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.TypeAccountResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class TypeAccountUseCaseImplementation(
    val typeAccountRepository: TypeAccountRepository,
    val accountRepository: AccountRepository
): TypeAccountUseCase {

    override fun getAllTypes(): ListTypeAccountResponse {
        return try {
            ListTypeAccountResponse(typeAccount = typeAccountRepository.getAll())
        }catch (e: Exception){
            print(e)
            ListTypeAccountResponse(error = ACCOUNT_TYPE_ERROR_DATABASE)
        }
    }

    override fun addType(typeAccount: TypeAccount?): TypeAccountResponse {
        return try {
            if(typeAccount == null){
                return TypeAccountResponse(error = ACCOUNT_TYPE_NOT_FOUND)
            }else{
                if(typeAccount.description == null){
                    return TypeAccountResponse(error = ACCOUNT_TYPE_DESCRIPTION_NULL)
                }
                typeAccount.uuid = UUID.randomUUID()
                typeAccountRepository.addType(typeAccount);
                TypeAccountResponse(typeAccount = typeAccount)
            }
        }catch (e: Exception){
            print(e)
            TypeAccountResponse(error = ACCOUNT_TYPE_ERROR_DATABASE)
        }
    }

    override fun removeType(uuid: UUID?): TypeAccountResponse {
         return try {
            if(uuid == null){
                return TypeAccountResponse(error = ACCOUNT_TYPE_UUID_NULL)
            }else{
                if(typeAccountRepository.findByUUID(uuid) == null){
                    return TypeAccountResponse(error = ACCOUNT_TYPE_NOT_FOUND)
                }
                try {
                    if(accountRepository.findByType(uuid).isNotEmpty()){
                        return TypeAccountResponse(error = ACCOUNT_TYPE_REFERENCE_ERROR)
                    }
                }catch (ex: Exception){
                    print(ex)
                    return TypeAccountResponse(error = ACCOUNT_ERROR_DATABASE)
                }
                typeAccountRepository.deleteType(uuid)
                TypeAccountResponse(error = null)
            }
        }catch (e: Exception){
            print(e)
            TypeAccountResponse(error = ACCOUNT_TYPE_ERROR_DATABASE)
        }
    }
}