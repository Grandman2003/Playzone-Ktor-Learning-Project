package ru.playzone.database.games

import org.jetbrains.exposed.sql.transactions.transaction

object GamesRepository {
    fun insert(gameDTO: GameDTO) = transaction {
        GamesDAO.new {
            gameId = gameDTO.gameId
            name = gameDTO.name
            backdrop = gameDTO.backdrop
            logo = gameDTO.logo
            description = gameDTO.description
            downloadCount = gameDTO.downloadCount
            version = gameDTO.version
            weight = gameDTO.weight
        }
    }

    fun fetchGames() = transaction {
        GamesDAO.all().map(::daoToDTO)
    }

    private fun daoToDTO(dao: GamesDAO) = GameDTO(
        gameId = dao.gameId,
        name = dao.name,
        backdrop = dao.backdrop,
        logo = dao.logo,
        description = dao.description,
        downloadCount = dao.downloadCount,
        version = dao.version,
        weight = dao.weight
    )
}