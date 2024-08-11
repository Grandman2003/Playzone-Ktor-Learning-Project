package ru.playzone.features.games

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

const val BEARER_TOKEN = "Bearer-Authorization"

fun Application.configureGamesRouting() {
    routing {
        get("/games/search") {
            GamesController.performSearch(
                token = call.request.headers[BEARER_TOKEN],
                gamesRequest = call.receive<FetchGamesRequest>(),
                onSuccess = call::respond,
                onError = call::respond
            )
        }

        post("/games/create") {
            GamesController.addGame(
                token = call.request.headers[BEARER_TOKEN],
                request = call.receive<CreateGameRequest>(),
                onSuccess = call::respond,
                onError = call::respond
            )
        }
    }
}