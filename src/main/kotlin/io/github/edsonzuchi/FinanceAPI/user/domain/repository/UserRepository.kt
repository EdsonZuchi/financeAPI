package io.github.edsonzuchi.FinanceAPI.user.domain.repository

import io.github.edsonzuchi.FinanceAPI.user.domain.entity.User

interface UserRepository {

    fun findByCodeUser(codeUser: String): User?
}