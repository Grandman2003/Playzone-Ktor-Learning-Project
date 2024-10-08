package ru.playzone

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import ru.playzone.plugins.configureDatabase
import ru.playzone.plugins.configureRouting
import ru.playzone.plugins.configureSerialization

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureDatabase()
    configureSerialization()
    configureRouting()
}
