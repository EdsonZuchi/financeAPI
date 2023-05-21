package io.github.edsonzuchi.FinanceAPI.bank.domain.repository

import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import java.util.UUID

interface BankRepository {

    fun getAll(): List<Bank>
    fun findByUUID(uuid: UUID): Bank?
    fun addBank(bank: Bank)
}