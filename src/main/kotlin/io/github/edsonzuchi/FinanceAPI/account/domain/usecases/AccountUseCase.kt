package io.github.edsonzuchi.FinanceAPI.account.domain.usecases

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.AccountResponse
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.ListAccountResponse
import java.util.UUID

interface AccountUseCase {

    fun listAll(userUUID: UUID?): ListAccountResponse
    fun listAccount(uuid: UUID?, userUUID: UUID?): AccountResponse
    fun registerAccount(account: Account?): AccountResponse
}