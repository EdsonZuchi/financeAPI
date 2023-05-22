package io.github.edsonzuchi.FinanceAPI.account.infrastructure.webservice

import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.AccountUseCase
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.TypeAccountUseCase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountService(
    val accountUseCase: AccountUseCase,
    val typeAccountUseCase: TypeAccountUseCase
) {

}