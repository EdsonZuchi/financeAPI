package io.github.edsonzuchi.FinanceAPI.user.domain.exceptions

import io.github.edsonzuchi.FinanceAPI.shared.GenericError

val USER_NOT_FOUND = UserException("USER_NOT_FOUND", "User not found.")

val USER_NULL = UserException("USER_NULL", "User is null")

val USER_ERROR_DATABASE = UserException("USER_ERROR_DATABASE", "Error user database")

class UserException(
    code: String,
    description: String
): GenericError("user-module", code, description) {
}