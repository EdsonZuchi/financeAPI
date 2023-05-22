package io.github.edsonzuchi.FinanceAPI.account.domain.usecases.implementation

import io.github.edsonzuchi.FinanceAPI.account.domain.repository.AccountRepository
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.AccountUseCase
import org.springframework.stereotype.Service

@Service
class AccountUseCaseImplementation(
    val accountRepository: AccountRepository
): AccountUseCase {
}