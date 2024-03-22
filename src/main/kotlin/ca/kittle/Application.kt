@file:Suppress("ktlint:standard:no-wildcard-imports")

package ca.kittle

import ca.kittle.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    // Create a websocket for the chat example
    configureSockets()
    // Content will be returned as json, by detail, from routes
    configureSerialization()
    // Configure simple call logging
    configureMonitoring()
    // Configure CORS and compression
    configureHTTP()
    // Sample OAuth and JWT security
    configureSecurity()
    // Configure routes
    configureRouting()
}
