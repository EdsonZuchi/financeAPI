package io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.implementation

import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import io.github.edsonzuchi.FinanceAPI.bank.domain.exceptions.BANK_ERROR_DATABASE
import io.github.edsonzuchi.FinanceAPI.bank.domain.exceptions.BANK_NAME_NULL
import io.github.edsonzuchi.FinanceAPI.bank.domain.exceptions.BANK_NOT_FOUND
import io.github.edsonzuchi.FinanceAPI.bank.domain.repository.BankRepository
import io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.BankUseCase
import io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.response.BankResponse
import io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.response.ListBankResponse
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BankUseCaseImplementation(
    val bankRepository: BankRepository
): BankUseCase {

    override fun getAll(): ListBankResponse {
        return try {
            return ListBankResponse(bank = bankRepository.getAll())
        }catch (e: Exception){
            print(e)
            ListBankResponse(error = BANK_ERROR_DATABASE)
        }
    }

    override fun findByUUID(uuid: UUID): BankResponse {
        return try {
            val bank = bankRepository.findByUUID(uuid)
            if(bank == null){
                return BankResponse(error = BANK_NOT_FOUND)
            }else{
                return BankResponse(bank = bank)
            }
        }catch (e: Exception){
            print(e)
            BankResponse(error = BANK_ERROR_DATABASE)
        }
    }

    override fun addBank(bank: Bank?): BankResponse {
        return try {
            if(bank == null){
                BankResponse(error = BANK_NOT_FOUND)
            }else{
                if(bank.name == null){
                    BankResponse(error = BANK_NAME_NULL)
                }
                bank.uuid = UUID.randomUUID()
                bankRepository.addBank(bank)
            }
            BankResponse(bank);
        }catch (e: Exception){
            print(e)
            BankResponse(error = BANK_ERROR_DATABASE)
        }
    }
}