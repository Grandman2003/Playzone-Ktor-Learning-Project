package ru.playzone.database.tokens

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class TokensDAO(id: EntityID<String>): Entity<String>(id) {
    companion object: EntityClass<String, TokensDAO>(Tokens)

    var tokenId by Tokens.tokenId
    var login by Tokens.login
    var token by Tokens.token
}