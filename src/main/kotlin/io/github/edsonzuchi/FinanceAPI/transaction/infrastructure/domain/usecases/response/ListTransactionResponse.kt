package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.shared.GenericError
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.entity.Transaction

class ListTransactionResponse (
    val listTransaction: List<Transaction>? = null,
    val error: GenericError? = null
)