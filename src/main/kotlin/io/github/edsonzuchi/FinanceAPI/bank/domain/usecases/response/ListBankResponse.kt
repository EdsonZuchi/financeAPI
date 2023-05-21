package io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import io.github.edsonzuchi.FinanceAPI.shared.GenericError

class ListBankResponse(
    val bank: List<Bank>? = null,
    val error: GenericError? = null
)
{
}