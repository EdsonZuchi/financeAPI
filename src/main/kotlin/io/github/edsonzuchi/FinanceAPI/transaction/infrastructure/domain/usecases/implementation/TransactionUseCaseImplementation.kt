package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases.implementation

import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.entity.Transaction
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.exceptions.TRANSACTION_ERROR_DATABASE
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.exceptions.TRANSACTION_NULL
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.exceptions.TransactionException
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.repository.TransactionRepository
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases.TransactionUseCase
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases.response.TransactionResponse
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionUseCaseImplementation(
    val transactionRepository: TransactionRepository
): TransactionUseCase {

    override fun newTransaction(transaction: Transaction?): TransactionResponse {
        return if(transaction == null){
            TransactionResponse(error = TRANSACTION_NULL)
        }else{

            try {
                if((transaction.account == null) || (transaction.account!!.uuid == null)){
                    return TransactionResponse()
                }
                if((transaction.typeTransaction == null) || (transaction.typeTransaction!!.uuid == null)){
                    return TransactionResponse()
                }git

                transaction.uuid = UUID.randomUUID()
                TransactionResponse(transaction = transaction)
            } catch (e: Exception){
                TransactionResponse(error = TRANSACTION_ERROR_DATABASE)
            }
        }
    }
}