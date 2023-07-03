package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.repository.database

import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.AccountDatabase
import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.AccountDatabase.defaultExpression
import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.UserDatabase
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentDateTime
import org.jetbrains.exposed.sql.javatime.datetime

object TransactionDatabase: Table("transaction"){
    var uuid = uuid("uuid").uniqueIndex()
    var accountUUID = reference("account_uuid", AccountDatabase.uuid)
    var value = double("value")
    var createdAt = datetime("created_at").defaultExpression(CurrentDateTime)
    var description = varchar("description", 100)
    var complement = text("complement")
    var userUUID = reference("user_uuid", UserDatabase.uuid)
    var typeTransactionUUID = reference("type_transaction_uuid", TypeTransactionDatabase.uuid)
}
