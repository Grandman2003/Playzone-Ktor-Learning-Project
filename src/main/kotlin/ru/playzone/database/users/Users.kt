package ru.playzone.database.users

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object Users: IdTable<String>() {
    val login = Users.varchar("login", 25)
    val password = Users.varchar("password", 25)
    val username = Users.varchar("username", 30)
    val email = Users.varchar("email", 25).nullable()

    override val id: Column<EntityID<String>> = login.entityId()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}