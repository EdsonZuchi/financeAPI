package io.github.edsonzuchi.FinanceAPI.user.domain.usecases

import io.github.edsonzuchi.FinanceAPI.user.domain.usecases.response.UserResponse

interface UserUseCase {

    fun getUser(userCode: String): UserResponse
}