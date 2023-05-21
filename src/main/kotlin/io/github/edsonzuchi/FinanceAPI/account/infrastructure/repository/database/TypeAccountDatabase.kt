import io.github.edsonzuchi.FinanceAPI.user.infrastructure.repository.database.AccountDatabase.uniqueIndex

import org.jetbrains.exposed.sql.Table

object TypeAccountDatabase: Table("type_account") {
    var uuid = uuid("uuid").uniqueIndex()
    var description = varchar("description", 30)
}