package ru.playzone.features.registration

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.playzone.utils.isValidEmail

fun Application.configureRegisterRouting() {
    routing {
        post("/register") {
            val request = call.receive<RegisterRemoteRequest>()
            if (!request.email.isValidEmail()) {
                call.respond(HttpStatusCode.BadRequest, message = "Email is not valid")
            }
            RegisterController.registerNewUser(
                registerRemoteRequest = request,
                onSuccess = { token -> call.respond(RegisterRemoteResponse(token = token)) },
                onError = { errorCode, message -> call.respond(errorCode, message) }
            )
        }
    }
}