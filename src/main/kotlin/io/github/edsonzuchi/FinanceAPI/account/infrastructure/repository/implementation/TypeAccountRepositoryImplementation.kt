package io.github.edsonzuchi.FinanceAPI.account.infrastructure.repository.implementation

import TypeAccountDatabase
import io.github.edsonzuchi.FinanceAPI.account.domain.entity.TypeAccount
import io.github.edsonzuchi.FinanceAPI.account.domain.repository.TypeAccountRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TypeAccountRepositoryImplementation(): TypeAccountRepository{

    override fun findByUUID(uuid: UUID): TypeAccount? {
        return transaction {
            TypeAccountDatabase
                .select(
                    TypeAccountDatabase.uuid eq uuid
                )
                .map {
                    TypeAccount(
                        uuid = it[TypeAccountDatabase.uuid],
                        description = it[TypeAccountDatabase.description],
                    )
                }
                .firstOrNull()
        }
    }

    override fun getAll(): List<TypeAccount> {
        return transaction {
            TypeAccountDatabase.selectAll()
                .map {
                    TypeAccount(
                        uuid = it[TypeAccountDatabase.uuid],
                        description = it[TypeAccountDatabase.description]
                    )
                }
        }
    }

    override fun addType(typeAccount: TypeAccount) {
        return transaction {
            TypeAccountDatabase
                .insert {
                    it[TypeAccountDatabase.uuid] = typeAccount.uuid!!
                    it[TypeAccountDatabase.description] = typeAccount.description!!
                }
        }
    }

    override fun deleteType(uuid: UUID) {
        transaction {
            TypeAccountDatabase
                .deleteWhere {
                    TypeAccountDatabase.uuid eq uuid
                }
        }
    }

    override fun updateType(uuid: UUID, typeAccount: TypeAccount) {
        transaction {
            TypeAccountDatabase
               .update ({
                   TypeAccountDatabase.uuid eq uuid
               }){
                   it[TypeAccountDatabase.description] = typeAccount.description!!
               }
        }
    }
}