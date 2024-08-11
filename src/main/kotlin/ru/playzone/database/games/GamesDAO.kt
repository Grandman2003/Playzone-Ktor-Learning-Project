package ru.playzone.database.games

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class GamesDAO(id: EntityID<String>): Entity<String>(id) {
    companion object : EntityClass<String, GamesDAO>(Games)

    var gameId by Games.gameId
    var name by Games.name
    var backdrop by Games.backdrop
    var logo by Games.logo
    var description by Games.description
    var downloadCount by Games.downloadCount
    var version by Games.version
    var weight by Games.weight
}