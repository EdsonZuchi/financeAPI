package io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database

import TypeAccountDatabase
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentDateTime
import org.jetbrains.exposed.sql.javatime.datetime

object AccountDatabase: Table("account") {
    var uuid = uuid("uuid").uniqueIndex()
    var name = varchar("name", 100)
    var balance = decimal("balance", 9, 2)
    var active = varchar("active?", 1)
    var modifiedAt = datetime("modified_at").defaultExpression(CurrentDateTime)
    var createdAt = datetime("created_at").defaultExpression(CurrentDateTime)
    var userUUID = reference("user_uuid", UserDatabase.uuid)
    var bankUUID = reference("bank_uuid", BankDatabase.uuid)
    var typeAccountUUID = reference("typeAccount_uuid", TypeAccountDatabase.uuid)
}