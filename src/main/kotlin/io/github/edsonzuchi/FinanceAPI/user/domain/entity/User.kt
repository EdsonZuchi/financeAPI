package io.github.edsonzuchi.FinanceAPI.user.domain.entity

import java.time.LocalDateTime
import java.util.UUID

class User(
    var uuid: UUID? = null,
    var name: String? = null,
    var birthDate: LocalDateTime? = null,
    var userCode: String? = null
) {
}