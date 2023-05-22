package io.github.edsonzuchi.FinanceAPI.account.domain.exceptions

import io.github.edsonzuchi.FinanceAPI.shared.GenericError

val ACCOUNT_NOT_FOUND = AccountException("ACCOUNT_NOT_FOUND", "Account not found.")

val ACCOUNT_ERROR_DATABASE = AccountException("ACCOUNT_ERROR_DATABASE", "Error account database")

val ACCOUNT_TYPE_NOT_FOUND = AccountException("ACCOUNT_TYPE_NOT_FOUND", "Account type not found.")

val ACCOUNT_TYPE_ERROR_DATABASE = AccountException("ACCOUNT_TYPE_ERROR_DATABASE", "Error account type database")

class AccountException(
    code: String,
    description: String
): GenericError("account-module", code, description) {
}