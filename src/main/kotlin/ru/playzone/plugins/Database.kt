package ru.playzone.plugins

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    Database.connect(
        url = "GREAT_ADDRESS",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "GREAT_USER_NAME",
        password = "F+GREAT_PASSWORD"
    )
}