package io.github.edsonzuchi.FinanceAPI.user.domain.usecases.response

import io.github.edsonzuchi.FinanceAPI.shared.GenericError
import io.github.edsonzuchi.FinanceAPI.user.domain.entity.User

class UserResponse(
    val user: User? = null,
    val error: GenericError? = null
) {
}