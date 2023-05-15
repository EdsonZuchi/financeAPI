package io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.implementation

import io.github.edsonzuchi.FinanceAPI.user.domain.entity.User
import io.github.edsonzuchi.FinanceAPI.user.domain.repository.UserRepository
import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.UserDatabase
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImplementation: UserRepository {

    override fun findByCodeUser(codeUser: String): User? {
        return transaction {
            UserDatabase
                .slice(
                    UserDatabase.uuid,
                    UserDatabase.name,
                    UserDatabase.birthDate
                )
                .select(
                    UserDatabase.userCode eq codeUser
                )
                .map {
                    User(
                        uuid = it[UserDatabase.uuid],
                        name = it[UserDatabase.name],
                        birthDate = it[UserDatabase.birthDate],
                        userCode = it[UserDatabase.userCode]
                    )
                }
                .firstOrNull()
        }
    }
}