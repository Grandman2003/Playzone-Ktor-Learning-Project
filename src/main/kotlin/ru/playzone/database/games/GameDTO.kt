package ru.playzone.database.games

import ru.playzone.features.games.CreateGameRequest
import ru.playzone.features.games.CreateGameResponse
import ru.playzone.features.games.GameResponse
import java.util.*

data class GameDTO(
    val gameId: String,
    val name: String,
    val backdrop: String?,
    val logo: String,
    val description: String,
    val downloadCount: Int,
    val version: String,
    val weight: String
)

fun CreateGameRequest.mapToDTO(): GameDTO =
    GameDTO(
        gameId = UUID.randomUUID().toString(),
        name = title,
        description =description,
        version = version,
        weight = size,
        backdrop = "",
        logo = "",
        downloadCount = 0
    )

fun GameDTO.mapToCreateGameResponse(): CreateGameResponse =
    CreateGameResponse(
        gameId = gameId,
        title = name,
        description = description,
        version = version,
        size = weight
    )

fun GameDTO.mapToGameResponse(): GameResponse =
    GameResponse(
        gameId = gameId,
        title = name,
        description= description,
        version = version,
        size = weight
    )