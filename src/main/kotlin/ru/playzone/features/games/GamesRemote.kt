package ru.playzone.features.games

import kotlinx.serialization.Serializable

@Serializable
data class FetchGamesRequest(
    val searchQuery: String
)

@Serializable
data class FetchGamesResponse(
    val games: List<GameResponse>
)

@Serializable
data class CreateGameRequest(
    val title: String,
    val description: String,
    val version: String,
    val size: String
)

@Serializable
data class GameResponse(
    val gameId: String,
    val title: String,
    val description: String,
    val version: String,
    val size: String
)

@Serializable
data class CreateGameResponse(
    val gameId: String,
    val title: String,
    val description: String,
    val version: String,
    val size: String
)