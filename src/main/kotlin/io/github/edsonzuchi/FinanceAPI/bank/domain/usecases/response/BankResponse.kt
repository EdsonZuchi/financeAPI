package io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import io.github.edsonzuchi.FinanceAPI.shared.GenericError

class BankResponse(
    val bank: Bank? = null,
    val error: GenericError? = null
) {
}