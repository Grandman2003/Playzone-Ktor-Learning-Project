package ru.playzone.features.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRemoteRequest(
    val login: String,
    val password: String
)

@Serializable
data class LoginRemoteResponse(
    val token: String
)