package io.github.edsonzuchi.FinanceAPI.user.domain.entity

import java.time.LocalDate
import java.util.UUID

class User(
    var uuid: UUID? = null,
    var name: String? = null,
    var birthDate: LocalDate? = null,
    var userCode: String? = null
) {
}