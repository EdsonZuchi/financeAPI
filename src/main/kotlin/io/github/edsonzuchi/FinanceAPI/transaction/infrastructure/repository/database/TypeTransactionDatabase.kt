package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.repository.database

import org.jetbrains.exposed.sql.Table

object TypeTransactionDatabase: Table("type_transaction") {
    var uuid = uuid("uuid").uniqueIndex()
    var description = varchar("description", 30)
}