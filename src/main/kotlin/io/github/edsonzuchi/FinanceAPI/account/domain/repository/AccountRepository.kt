package io.github.edsonzuchi.FinanceAPI.account.domain.repository

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import java.util.UUID

interface AccountRepository {

    fun findByType(uuidType: UUID): List<Account>
}