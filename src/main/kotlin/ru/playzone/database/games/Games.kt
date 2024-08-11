package ru.playzone.database.games

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object Games: IdTable<String>() {
    val gameId = Games.varchar("gameId", 100)
    val name = Games.varchar("name", 100)
    val backdrop = Games.varchar("backdrop", 50).nullable()
    val logo = Games.varchar("logo", 50)
    val description = Games.varchar("description", 500)
    val downloadCount = Games.integer("download_count")
    val version = Games.varchar("version", 15)
    val weight = Games.varchar("weight", 10)

    override val id: Column<EntityID<String>> = gameId.entityId()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}