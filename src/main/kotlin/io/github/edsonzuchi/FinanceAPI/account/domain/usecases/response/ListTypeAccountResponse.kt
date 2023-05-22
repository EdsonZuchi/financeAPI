package io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.TypeAccount
import io.github.edsonzuchi.FinanceAPI.shared.GenericError

class ListTypeAccountResponse(
    val typeAccount: List<TypeAccount>? = null,
    val error: GenericError? = null
) {
}