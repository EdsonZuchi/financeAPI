package io.github.edsonzuchi.FinanceAPI.account.domain.usecases

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.TypeAccount
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.ListTypeAccountResponse
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.TypeAccountResponse
import java.util.UUID

interface TypeAccountUseCase {

    fun getAllTypes(): ListTypeAccountResponse
    fun addType(typeAccount: TypeAccount?): TypeAccountResponse
    fun removeType(uuid: UUID?): TypeAccountResponse
    fun updateType(uuid: UUID?, typeAccount: TypeAccount?): TypeAccountResponse
}