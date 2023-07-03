package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.entity

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import io.github.edsonzuchi.FinanceAPI.user.domain.entity.User
import java.time.LocalDateTime
import java.util.UUID

class Transaction (
    var uuid: UUID? = null,
    var account: Account? = null,
    var value: Double? = null,
    var createdAt: LocalDateTime? = null,
    var description: String? = null,
    var complement: String? = null,
    var user: User? = null,
    var typeTransaction: TypeTransaction? = null
)