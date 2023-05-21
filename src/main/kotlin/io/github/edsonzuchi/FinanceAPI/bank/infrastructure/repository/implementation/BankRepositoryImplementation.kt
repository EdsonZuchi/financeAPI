package io.github.edsonzuchi.FinanceAPI.bank.infrastructure.repository.implementation

import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import io.github.edsonzuchi.FinanceAPI.bank.domain.repository.BankRepository
import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.BankDatabase
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BankRepositoryImplementation(): BankRepository {

    override fun getAll(): List<Bank> {
        return transaction {
            BankDatabase.selectAll()
                .map {
                    Bank(
                        uuid = it[BankDatabase.uuid],
                        name = it[BankDatabase.name],
                        createdAt = it[BankDatabase.createdAt]
                    )
                }
        }
    }

    override fun findByUUID(uuid: UUID): Bank? {
        return transaction {
            BankDatabase
                .slice(
                    BankDatabase.uuid,
                    BankDatabase.name,
                    BankDatabase.createdAt
                )
                .select (
                    BankDatabase.uuid eq uuid
                )
                .map {
                    Bank(
                        uuid = it[BankDatabase.uuid],
                        name = it[BankDatabase.name],
                        createdAt = it[BankDatabase.createdAt]
                    )
                }
                .firstOrNull()
        }
    }

    override fun addBank(bank: Bank) {
        transaction {
            BankDatabase.insert {
                it[uuid] = bank.uuid!!
                it[name] = bank.name!!
            }.resultedValues!!
        }
    }
}