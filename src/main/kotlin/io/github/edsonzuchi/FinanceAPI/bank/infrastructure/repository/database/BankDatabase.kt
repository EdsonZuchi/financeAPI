package io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentDateTime
import org.jetbrains.exposed.sql.javatime.datetime

object BankDatabase: Table("bank") {
    var uuid = uuid("uuid").uniqueIndex()
    var name = varchar("name", 30)
    var createdAt = datetime("created_at").defaultExpression(CurrentDateTime)
}