package ru.playzone.plugins

import io.ktor.server.application.*
import ru.playzone.features.games.configureGamesRouting
import ru.playzone.features.login.configureLoginRouting
import ru.playzone.features.registration.configureRegisterRouting
import ru.playzone.features.test.configureTestRouting

fun Application.configureRouting() {
    configureLoginRouting()
    configureRegisterRouting()
    configureGamesRouting()
    configureTestRouting()
}
