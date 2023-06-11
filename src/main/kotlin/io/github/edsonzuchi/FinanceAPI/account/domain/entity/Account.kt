package io.github.edsonzuchi.FinanceAPI.account.domain.entity

import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import io.github.edsonzuchi.FinanceAPI.user.domain.entity.User
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

class Account(
    var uuid: UUID? = null,
    var name: String? = null,
    var balance: Double? = null,
    var active: String? = null,
    var modifiedAt: LocalDateTime? = null,
    var createdAt: LocalDateTime? = null,
    var user: User? = null,
    var bank: Bank? = null,
    var typeAccount: TypeAccount? = null
) {
}