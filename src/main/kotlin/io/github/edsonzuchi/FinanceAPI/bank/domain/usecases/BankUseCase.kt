package io.github.edsonzuchi.FinanceAPI.bank.domain.usecases

import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.response.BankResponse
import io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.response.ListBankResponse
import java.util.UUID

interface BankUseCase {

    fun getAll(): ListBankResponse
    fun findByUUID(uuid: UUID): BankResponse
    fun addBank(bank: Bank?): BankResponse
}