package ru.playzone.features.games

import io.ktor.http.*
import ru.playzone.database.games.*
import ru.playzone.utils.token.TokenChecker

object GamesController {

    suspend fun performSearch(
        token: String?,
        gamesRequest: FetchGamesRequest,
        onSuccess: suspend (FetchGamesResponse) -> Unit,
        onError: suspend (errorCode: HttpStatusCode, message: String) -> Unit
    ) {
        if (TokenChecker.isTokenValid(token.orEmpty()) || TokenChecker.isTokenAdmin(token.orEmpty())) {
            onSuccess(
                FetchGamesResponse(
                    games = GamesRepository.fetchGames()
                        .filter { it.name.contains(gamesRequest.searchQuery, ignoreCase = true) }
                        .map(GameDTO::mapToGameResponse)
                )
            )
        } else {
            onError(HttpStatusCode.Unauthorized, "Token Expired")
        }
    }

    suspend fun addGame(
        token: String?,
        request: CreateGameRequest,
        onSuccess: suspend (CreateGameResponse) -> Unit,
        onError: suspend (errorCode: HttpStatusCode, message: String) -> Unit
    ) {
        if (TokenChecker.isTokenAdmin(token.orEmpty())) {
            val game = request.mapToDTO()
            GamesRepository.insert(game)
            onSuccess(game.mapToCreateGameResponse())
        } else {
            onError(HttpStatusCode.Unauthorized, "Token expired")
        }
    }
}