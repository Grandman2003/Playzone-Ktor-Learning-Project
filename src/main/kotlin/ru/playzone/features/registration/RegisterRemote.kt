package ru.playzone.features.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRemoteRequest(
    val login: String,
    val email: String,
    val password: String
)

@Serializable
data class RegisterRemoteResponse(
    val token: String
)