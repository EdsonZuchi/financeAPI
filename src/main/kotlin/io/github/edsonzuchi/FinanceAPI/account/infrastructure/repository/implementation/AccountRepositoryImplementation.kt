package io.github.edsonzuchi.FinanceAPI.account.infrastructure.repository.implementation

import TypeAccountDatabase
import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import io.github.edsonzuchi.FinanceAPI.account.domain.entity.TypeAccount
import io.github.edsonzuchi.FinanceAPI.account.domain.repository.AccountRepository
import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import io.github.edsonzuchi.FinanceAPI.user.domain.entity.User
import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.AccountDatabase
import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.BankDatabase
import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.UserDatabase
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.innerJoin
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AccountRepositoryImplementation(): AccountRepository {

    override fun findByType(uuidType: UUID): List<Account> {
        return transaction {
            AccountDatabase
                .innerJoin(UserDatabase, {UserDatabase.uuid}, {AccountDatabase.userUUID})
                .innerJoin(BankDatabase, {BankDatabase.uuid}, {AccountDatabase.bankUUID})
                .innerJoin(TypeAccountDatabase, {TypeAccountDatabase.uuid}, {AccountDatabase.typeAccountUUID})
                .select(
                    AccountDatabase.typeAccountUUID eq uuidType
                )
                .map {
                    Account(
                        uuid = it[AccountDatabase.uuid],
                        name = it[AccountDatabase.name],
                        balance = it[AccountDatabase.balance],
                        active = it[AccountDatabase.active],
                        modifiedAt = it[AccountDatabase.modifiedAt],
                        createdAt = it[AccountDatabase.createdAt],
                        user = it.toUser(),
                        bank = it.toBank(),
                        typeAccount = it.toTypeAccount()
                    )
                }
        }
    }

    override fun findAll(userUUID: UUID): List<Account> {
        return transaction {
            AccountDatabase
                .innerJoin(UserDatabase, {UserDatabase.uuid}, {AccountDatabase.userUUID})
                .innerJoin(BankDatabase, {BankDatabase.uuid}, {AccountDatabase.bankUUID})
                .innerJoin(TypeAccountDatabase, {TypeAccountDatabase.uuid}, {AccountDatabase.typeAccountUUID})
                .select(
                    AccountDatabase.userUUID eq userUUID
                )
                .map {
                    Account(
                        uuid = it[AccountDatabase.uuid],
                        name = it[AccountDatabase.name],
                        balance = it[AccountDatabase.balance],
                        active = it[AccountDatabase.active],
                        modifiedAt = it[AccountDatabase.modifiedAt],
                        createdAt = it[AccountDatabase.createdAt],
                        user = it.toUser(),
                        bank = it.toBank(),
                        typeAccount = it.toTypeAccount()
                    )
                }
        }
    }

    override fun findByUUID(uuid: UUID): Account? {
        return transaction {
            AccountDatabase
                .innerJoin(UserDatabase, {UserDatabase.uuid}, {AccountDatabase.userUUID})
                .innerJoin(BankDatabase, {BankDatabase.uuid}, {AccountDatabase.bankUUID})
                .innerJoin(TypeAccountDatabase, {TypeAccountDatabase.uuid}, {AccountDatabase.typeAccountUUID})
                .select(
                    AccountDatabase.uuid eq uuid
                )
                .map {
                    Account(
                        uuid = it[AccountDatabase.uuid],
                        name = it[AccountDatabase.name],
                        balance = it[AccountDatabase.balance],
                        active = it[AccountDatabase.active],
                        modifiedAt = it[AccountDatabase.modifiedAt],
                        createdAt = it[AccountDatabase.createdAt],
                        user = it.toUser(),
                        bank = it.toBank(),
                        typeAccount = it.toTypeAccount()
                    )
                }
                .firstOrNull()
        }
    }

    fun ResultRow.toUser(): User {
        return User(
            uuid = this[UserDatabase.uuid],
            name = this[UserDatabase.name],
            birthDate = this[UserDatabase.birthDate],
            userCode = this[UserDatabase.userCode]
        )
    }

    fun ResultRow.toBank(): Bank{
        return Bank(
            uuid = this[BankDatabase.uuid],
            name = this[BankDatabase.name],
            createdAt = this[BankDatabase.createdAt]
        )
    }

    fun ResultRow.toTypeAccount(): TypeAccount{
        return TypeAccount(
            uuid = this[TypeAccountDatabase.uuid],
            description = this[TypeAccountDatabase.description]
        )
    }
}