package io.github.edsonzuchi.FinanceAPI.account.domain.repository

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.TypeAccount
import java.util.UUID

interface TypeAccountRepository {

    fun getAll(): List<TypeAccount>
    fun addType(typeAccount: TypeAccount)
    fun findByUUID(uuid: UUID): TypeAccount?
    fun deleteType(uuid: UUID)
    fun updateType(uuid: UUID, typeAccount: TypeAccount)
}