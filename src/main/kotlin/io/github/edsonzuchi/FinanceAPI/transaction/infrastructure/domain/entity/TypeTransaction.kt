package io.github.edsonzuchi.FinanceAPI.transaction.infrastructure.domain.entity

import java.util.UUID

class TypeTransaction(
    var uuid: UUID? = null,
    var description: String? = null
)