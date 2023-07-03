package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.exceptions

import io.github.edsonzuchi.FinanceAPI.account.domain.exceptions.AccountException
import io.github.edsonzuchi.FinanceAPI.shared.GenericError

val TRANSACTION_ERROR_DATABASE = TransactionException("TRANSACTION_ERROR_DATABASE", "Error transaction database")

val TRANSACTION_NULL = TransactionException("TRANSACTION_NULL", "Transaction is null")

class TransactionException(
    code: String,
    description: String
): GenericError("transaction-module", code, description) {
}