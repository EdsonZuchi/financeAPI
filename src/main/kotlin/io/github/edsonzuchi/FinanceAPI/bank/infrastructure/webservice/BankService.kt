package io.github.edsonzuchi.FinanceAPI.bank.infrastructure.webservice

import io.github.edsonzuchi.FinanceAPI.bank.domain.entity.Bank
import io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.BankUseCase
import io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.response.BankResponse
import io.github.edsonzuchi.FinanceAPI.bank.domain.usecases.response.ListBankResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/bank")
class BankService (
    val bankUseCase: BankUseCase
){

    @GetMapping
    fun getAll(): ListBankResponse{
        return bankUseCase.getAll()
    }

    @GetMapping("/{uuid}")
    fun getBank(@PathVariable uuid: UUID): BankResponse{
        return bankUseCase.findByUUID(uuid)
    }

    @PostMapping
    fun addUser(@RequestBody bank: Bank): BankResponse{
        return bankUseCase.addBank(bank)
    }
}