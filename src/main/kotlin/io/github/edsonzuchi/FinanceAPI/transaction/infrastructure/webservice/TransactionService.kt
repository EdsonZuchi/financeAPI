package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.webservice

import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.entity.Transaction
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases.TransactionUseCase
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases.response.TransactionResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("transaction")
class TransactionService(
    val transactionUseCase: TransactionUseCase
) {

    @PostMapping
    fun newTransaction(@RequestBody transaction: Transaction?): TransactionResponse{
        return transactionUseCase.newTransaction(transaction);
    }

}