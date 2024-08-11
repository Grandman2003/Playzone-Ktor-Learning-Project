package ru.playzone.features.registration

import io.ktor.http.*
import ru.playzone.database.tokens.TokenDTO
import ru.playzone.database.tokens.TokensRepository
import ru.playzone.database.users.UserDTO
import ru.playzone.database.users.UsersRepository
import java.util.*

object RegisterController {

    suspend fun registerNewUser(
        registerRemoteRequest: RegisterRemoteRequest,
        onSuccess: suspend (token: String) -> Unit,
        onError: suspend (errorCode: HttpStatusCode, message: String) -> Unit
    ) {
        val userDTO = UsersRepository.fetchUser(registerRemoteRequest.login)

        if (userDTO != null) {
            onError(HttpStatusCode.Conflict, "User already exists")
        } else {
            val token = UUID.randomUUID().toString()
            UsersRepository.insert(
                UserDTO(
                    login = registerRemoteRequest.login,
                    password = registerRemoteRequest.password,
                    email = registerRemoteRequest.email,
                    username = ""
                )
            )
            TokensRepository.insert(
                TokenDTO(
                    login = registerRemoteRequest.login,
                    token = token,
                    id = UUID.randomUUID().toString()
                )
            )
            onSuccess(token)
        }
    }
}