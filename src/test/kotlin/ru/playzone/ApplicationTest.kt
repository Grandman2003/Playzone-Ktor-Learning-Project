package ru.playzone

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.playzone.features.login.LoginRemoteRequest
import ru.playzone.features.login.configureLoginRouting
import ru.playzone.features.registration.RegisterRemoteRequest
import ru.playzone.features.registration.configureRegisterRouting
import ru.playzone.plugins.configureDatabase
import ru.playzone.plugins.configureRouting
import ru.playzone.plugins.configureSerialization
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        val response = client.get("/test")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Hello World!", response.bodyAsText())
    }

    @Test
    fun testRegistration() = testApplication {
        application {
            defaultConfig()
            configureRegisterRouting()
        }
        val response = client.post("/register") {
            val body = Json.encodeToString(RegisterRemoteRequest(login = "test", email = "test", password = "test"))
            contentType(ContentType.Application.Json)
            setBody(body)
        }
        assertEquals(HttpStatusCode.Conflict, response.status)
    }

    @Test
    fun testLogin() = testApplication {
        application {
            defaultConfig()
            configureLoginRouting()
        }
        val response = client.post("/login") {
            val body = Json.encodeToString(LoginRemoteRequest(login = "test", password = "test"))
            contentType(ContentType.Application.Json)
            setBody(body)
        }
        assert(response.bodyAsText().contains("token"))
    }

    private fun Application.defaultConfig() {
        configureDatabase()
        configureSerialization()
    }
}
