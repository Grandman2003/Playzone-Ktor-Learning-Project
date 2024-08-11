package ru.playzone.utils.token

import ru.playzone.database.tokens.TokensRepository

object TokenChecker {
    fun isTokenValid(token: String) = TokensRepository.fetchTokens().firstOrNull { it.token == token } != null
    fun isTokenAdmin(token: String) = token == "GREAT_TOKEN"
}