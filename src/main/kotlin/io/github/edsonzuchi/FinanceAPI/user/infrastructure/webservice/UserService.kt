package io.github.edsonzuchi.FinanceAPI.user.infrastructure.webservice

import io.github.edsonzuchi.FinanceAPI.user.domain.usecases.UserUseCase
import io.github.edsonzuchi.FinanceAPI.user.domain.usecases.response.UserResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserService(
    val userUseCase: UserUseCase
) {

    @GetMapping("/{userCode}")
    fun getUser(@PathVariable(value = "userCode") userCode: String): UserResponse{
        return userUseCase.getUser(userCode)
    }
}