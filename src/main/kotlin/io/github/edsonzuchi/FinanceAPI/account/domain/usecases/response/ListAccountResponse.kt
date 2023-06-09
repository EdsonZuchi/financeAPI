package io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import io.github.edsonzuchi.FinanceAPI.shared.GenericError

class ListAccountResponse(
    val listAccount: List<Account>? = null,
    val error: GenericError? = null
) {
}