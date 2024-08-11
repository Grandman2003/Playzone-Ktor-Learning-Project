package ru.playzone.database.tokens

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object Tokens: IdTable<String>() {
    val login = Tokens.varchar("login", 25)
    val token = Tokens.varchar("token", 50)
    val tokenId = Tokens.varchar("id", 50)

    override val id: Column<EntityID<String>> = tokenId.entityId()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
