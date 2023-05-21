package io.github.edsonzuchi.FinanceAPI.bank.domain.exceptions

import io.github.edsonzuchi.FinanceAPI.shared.GenericError

val BANK_NOT_FOUND = BankException("BANK_NOT_FOUND", "Bank not found.")

val BANK_ERROR_DATABASE = BankException("BANK_ERROR_DATABASE", "Error bank database")

val BANK_NAME_NULL = BankException("BANK_NAME_NULL", "Name of bank null")

class BankException(
    code: String,
    description: String
): GenericError("bank-module", code, description) {
}