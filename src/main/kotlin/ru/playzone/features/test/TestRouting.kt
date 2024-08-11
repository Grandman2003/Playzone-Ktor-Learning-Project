package ru.playzone.features.test

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureTestRouting() {
    routing {
        get("/test") {
            call.respond("Hello World!")
        }
    }
}