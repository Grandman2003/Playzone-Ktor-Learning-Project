package ru.playzone.features.login

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureLoginRouting() {
    routing {
        post("/login") {
            val request = call.receive<LoginRemoteRequest>()
            LoginController.performLogin(
                loginRequest = request,
                onSuccess = { token -> call.respond(LoginRemoteResponse(token = token)) },
                onError = { errorCode, message -> call.respond(errorCode, message) }
            )
        }
    }
}