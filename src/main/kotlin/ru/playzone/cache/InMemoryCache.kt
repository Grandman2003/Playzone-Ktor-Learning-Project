package ru.playzone.cache

import ru.playzone.features.registration.RegisterRemoteRequest

data class TokenCache(
    val login: String,
    val token: String
)

object InMemoryCache {
    val userList: MutableList<RegisterRemoteRequest> = mutableListOf()
    val tokenList: MutableList<TokenCache> = mutableListOf()
}