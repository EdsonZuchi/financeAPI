package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases

import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.entity.Transaction
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases.response.TransactionResponse

interface TransactionUseCase {

    fun newTransaction(transaction: Transaction?): TransactionResponse
}