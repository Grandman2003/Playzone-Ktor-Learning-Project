package ru.playzone.database.users

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UsersDAO(id: EntityID<String>): Entity<String>(id) {
    companion object : EntityClass<String, UsersDAO>(Users)

    var login by Users.login
    var password by Users.password
    var username by Users.username
    var email by Users.email
}
