package io.github.edsonzuchi.FinanceAPI.account.domain.usecases.implementation

import io.github.edsonzuchi.FinanceAPI.account.domain.exceptions.ACCOUNT_ERROR_DATABASE
import io.github.edsonzuchi.FinanceAPI.account.domain.exceptions.ACCOUNT_NOT_FOUND
import io.github.edsonzuchi.FinanceAPI.account.domain.exceptions.ACCOUNT_NOT_USER
import io.github.edsonzuchi.FinanceAPI.account.domain.exceptions.ACCOUNT_NULL
import io.github.edsonzuchi.FinanceAPI.account.domain.repository.AccountRepository
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.AccountUseCase
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.AccountResponse
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.ListAccountResponse
import io.github.edsonzuchi.FinanceAPI.user.domain.exceptions.USER_NULL
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountUseCaseImplementation(
    val accountRepository: AccountRepository
): AccountUseCase {

    override fun listAll(userUUID: UUID?): ListAccountResponse {
        if(userUUID == null){
            return ListAccountResponse(error = USER_NULL)
        }
        return try {
            ListAccountResponse(listAccount = accountRepository.findAll(userUUID))
        } catch (e: Exception){
            print(e)
            ListAccountResponse(error = ACCOUNT_ERROR_DATABASE)
        }
    }

    override fun listAccount(uuid: UUID?, userUUID: UUID?): AccountResponse {
        if(userUUID == null){
            return AccountResponse(error = USER_NULL)
        }
        if(uuid == null){
            return AccountResponse(error = ACCOUNT_NULL)
        }
        return try {
            val account = accountRepository.findByUUID(uuid) ?: return AccountResponse(error = ACCOUNT_NOT_FOUND)
            if(account.user!!.uuid != userUUID){
                return AccountResponse(error = ACCOUNT_NOT_USER)
            }
            AccountResponse(account = account)
        }catch (e: Exception){
            print(e)
            AccountResponse(error = ACCOUNT_ERROR_DATABASE)
        }
    }
}