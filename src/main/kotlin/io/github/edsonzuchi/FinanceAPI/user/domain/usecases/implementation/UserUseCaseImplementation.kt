package io.github.edsonzuchi.FinanceAPI.user.domain.usecases.implementation

import io.github.edsonzuchi.FinanceAPI.user.domain.exceptions.USER_ERROR_DATABASE
import io.github.edsonzuchi.FinanceAPI.user.domain.exceptions.USER_NOT_FOUND
import io.github.edsonzuchi.FinanceAPI.user.domain.repository.UserRepository
import io.github.edsonzuchi.FinanceAPI.user.domain.usecases.UserUseCase
import io.github.edsonzuchi.FinanceAPI.user.domain.usecases.response.UserResponse
import org.springframework.stereotype.Service

@Service
class UserUseCaseImplementation(
    val userRepository: UserRepository
): UserUseCase {

    override fun getUser(userCode: String): UserResponse {
        return try {
            val user = userRepository.findByCodeUser(userCode)
            if(user == null){
                UserResponse(error = USER_NOT_FOUND)
            }else{
                UserResponse(user = user)
            }
        } catch (e: Exception){
            print(e)
            UserResponse(error = USER_ERROR_DATABASE)
        }
    }
}