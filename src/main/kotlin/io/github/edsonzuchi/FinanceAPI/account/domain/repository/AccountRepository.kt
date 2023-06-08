package io.github.edsonzuchi.FinanceAPI.account.domain.repository

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import java.util.UUID

interface AccountRepository {

    fun findByType(uuidType: UUID): List<Account>
    fun findAll(userUUID: UUID): List<Account>
    fun findByUUID(uuid: UUID): Account?
    fun addAccount(account: Account): Account
}