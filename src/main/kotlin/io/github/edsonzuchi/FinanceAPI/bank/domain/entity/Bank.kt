package io.github.edsonzuchi.FinanceAPI.bank.domain.entity

import java.time.LocalDateTime
import java.util.*

class Bank (
    var uuid: UUID? = null,
    var name: String? = null,
    var createdAt: LocalDateTime? = null
){

}