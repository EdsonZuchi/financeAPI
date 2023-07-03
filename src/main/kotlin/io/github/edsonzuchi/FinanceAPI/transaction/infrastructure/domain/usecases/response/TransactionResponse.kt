package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.shared.GenericError
import io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.entity.Transaction

class TransactionResponse(
    val transaction: Transaction? = null,
    val error: GenericError? = null
)