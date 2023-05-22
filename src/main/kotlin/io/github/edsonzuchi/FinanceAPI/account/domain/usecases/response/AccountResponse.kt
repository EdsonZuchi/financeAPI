package io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import io.github.edsonzuchi.FinanceAPI.shared.GenericError

class AccountResponse(
    val account: Account? = null,
    val error: GenericError? = null
) {
}