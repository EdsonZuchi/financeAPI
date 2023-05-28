package io.github.edsonzuchi.FinanceAPI.account.domain.exceptions

import io.github.edsonzuchi.FinanceAPI.shared.GenericError

val ACCOUNT_NOT_FOUND = AccountException("ACCOUNT_NOT_FOUND", "Account not found.")

val ACCOUNT_NULL = AccountException("ACCOUNT_NULL", "Account is null")

val ACCOUNT_NOT_USER = AccountException("ACCOUNT_NOT_USER", "Account does not belong to the user")

val ACCOUNT_ERROR_DATABASE = AccountException("ACCOUNT_ERROR_DATABASE", "Error account database")

val ACCOUNT_TYPE_NOT_FOUND = AccountException("ACCOUNT_TYPE_NOT_FOUND", "Account type not found.")

val ACCOUNT_TYPE_ERROR_DATABASE = AccountException("ACCOUNT_TYPE_ERROR_DATABASE", "Error account type database")

val ACCOUNT_TYPE_DESCRIPTION_NULL = AccountException("ACCOUNT_TYPE_DESCRIPTION_NULL", "Description of type account null")

val ACCOUNT_TYPE_UUID_NULL = AccountException("ACCOUNT_TYPE_UUID_NULL", "UUID of type account null")

val ACCOUNT_TYPE_REFERENCE_ERROR = AccountException("ACCOUNT_TYPE_REFERENCE_ERROR", "Account type related to an account")

class AccountException(
    code: String,
    description: String
): GenericError("account-module", code, description) {
}