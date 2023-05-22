package io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object UserDatabase: Table("user") {
    var uuid = uuid("uuid").uniqueIndex()
    var name = varchar("name", 100)
    var birthDate = date("birth")
    var userCode = varchar("user_code", 25)
}