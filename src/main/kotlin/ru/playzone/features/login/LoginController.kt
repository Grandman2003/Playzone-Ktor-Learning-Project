package ru.playzone.features.login

import io.ktor.http.*
import ru.playzone.database.tokens.TokenDTO
import ru.playzone.database.tokens.TokensRepository
import ru.playzone.database.users.UsersRepository
import java.util.*

object LoginController {
    suspend fun performLogin(
        loginRequest: LoginRemoteRequest,
        onSuccess: suspend (token: String) -> Unit,
        onError: suspend (errorCode: HttpStatusCode, message: String) -> Unit
    ) {
        val userDTO = UsersRepository.fetchUser(loginRequest.login)

        userDTO?.let { dto ->
            if (dto.password == loginRequest.password) {
                val token = UUID.randomUUID().toString()
                TokensRepository.insert(
                    TokenDTO(
                        login = loginRequest.login,
                        token = token,
                        id = UUID.randomUUID().toString()
                    )
                )

                onSuccess(token)
            } else {
                onError(HttpStatusCode.BadRequest, "Invalid password")
            }
        } ?: onError(HttpStatusCode.BadRequest,  "User not found")
    }
}