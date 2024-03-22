@file:Suppress("ktlint:standard:filename")

package ca.kittle.routing

import ca.kittle.components.chatInput
import ca.kittle.components.chatMessages
import ca.kittle.components.chatPage
import ca.kittle.models.Message
import io.ktor.server.application.call
import io.ktor.server.html.respondHtml
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.websocket.webSocket
import io.ktor.utils.io.core.buildPacket
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import util.with
import util.withHTML
import kotlin.random.Random

fun Routing.chat() {
    get("/content/chat") {
        call.respondHtml {
            body {
                chatPage()
            }
        }
    }

    @Serializable
    data class Payload(val message: String)

    val json =
        Json {
            ignoreUnknownKeys = true
        }

    webSocket("/content/chat/ws") {
        val messages = mutableListOf<Message>()
        for (frame in incoming) {
            frame as? Frame.Text ?: continue
            val data = frame.readText()
            val payload = json.decodeFromString<Payload>(data)
            val output =
                payload.message.map { if (Random.nextBoolean()) it.uppercase() else it.lowercase() }.joinToString("")
            messages += Message(payload.message, true)
            messages += Message(output, false)
            val response =
                buildPacket {
                    // Websocket replies with updated list of messages
                    withHTML().with {
                        chatMessages(messages.toList())
                        chatInput()
                    }
                }.readText()
            send(Frame.Text(response))
        }
    }
}
