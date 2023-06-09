package io.github.edsonzuchi.FinanceAPI.account.infrastructure.webservice

import io.github.edsonzuchi.FinanceAPI.account.domain.entity.Account
import io.github.edsonzuchi.FinanceAPI.account.domain.entity.TypeAccount
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.AccountUseCase
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.TypeAccountUseCase
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.AccountResponse
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.ListAccountResponse
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.ListTypeAccountResponse
import io.github.edsonzuchi.FinanceAPI.account.domain.usecases.response.TypeAccountResponse
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/account")
class AccountService(
    val accountUseCase: AccountUseCase,
    val typeAccountUseCase: TypeAccountUseCase
) {

    @GetMapping
    fun listAllAccountUser(@RequestHeader(name = "user") userUUID: UUID?): ListAccountResponse{
        return accountUseCase.listAll(userUUID);
    }

    @GetMapping("/{uuid}")
    fun listAccount(@PathVariable uuid: UUID,
                    @RequestHeader(name = "user") userUUID: UUID?
    ): AccountResponse{
        return accountUseCase.listAccount(uuid, userUUID);
    }

    @PostMapping
    fun registerAccount(@RequestBody account: Account): AccountResponse{
        return accountUseCase.registerAccount(account)
    }

    @GetMapping("/type")
    fun listAllTypes(): ListTypeAccountResponse{
        return typeAccountUseCase.getAllTypes();
    }

    @PostMapping("/type")
    fun addType(@RequestBody typeAccount: TypeAccount?): TypeAccountResponse{
        return typeAccountUseCase.addType(typeAccount);
    }

    @DeleteMapping("/type/{uuid}")
    fun removeType(@PathVariable uuid: UUID?): TypeAccountResponse{
        return typeAccountUseCase.removeType(uuid);
    }

    @PutMapping("/type/{uuid}")
    fun updateDescriptionType(@PathVariable uuid: UUID?,
                              @RequestBody typeAccount: TypeAccount?
    ): TypeAccountResponse{
        return typeAccountUseCase.updateType(uuid, typeAccount);
    }

}