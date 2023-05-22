package io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.TypeAccount
import io.github.edsonzuchi.FinanceAPI.shared.GenericError

class TypeAccountResponse(
    val typeAccount: TypeAccount? = null,
    val error: GenericError? = null
) {
}