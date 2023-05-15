package io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object UserDatabase: Table("user") {
    var uuid = uuid("uuid").uniqueIndex()
    var name = varchar("name", 100)
    var birthDate = datetime("birth_date")
    var userCode = varchar("user_code", 25)
}