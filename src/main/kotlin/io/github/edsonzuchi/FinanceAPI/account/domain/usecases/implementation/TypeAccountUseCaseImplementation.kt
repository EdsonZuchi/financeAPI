package io.github.edsonzuchi.FinanceAPI.account.domain.usecases.implementation

import io.github.edsonzuchi.FinanceAPI.account.domain.repository.TypeAccountRepository
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.TypeAccountUseCase
import org.springframework.stereotype.Service

@Service
class TypeAccountUseCaseImplementation(
    val typeAccountRepository: TypeAccountRepository
): TypeAccountUseCase {
}