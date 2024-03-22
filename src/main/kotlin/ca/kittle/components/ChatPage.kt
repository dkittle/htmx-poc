@file:Suppress("ktlint:standard:no-wildcard-imports")

package ca.kittle.components

import ca.kittle.models.Message
import kotlinx.html.*

fun FlowContent.chatPage() =
    div {
        header {
            classes = setOf("bg-white", "shadow")
            div {
                classes = setOf("mx-auto", "max-w-7xl", "px-4", "py-6", "sm:px-6", "lg:px-8")
                h1 {
                    classes = setOf("text-3xl", "font-bold", "tracking-tight", "text-gray-900")
                    +"Chat"
                }
            }
        }
        main {
            div {
                attributes["hx-ws"] = "connect:/content/chat/ws"
                classes = setOf("mx-auto", "max-w-7xl", "py-6", "sm:px-6", "lg:px-8")

                // This div matches the id of the div returned by the
                // Websocket, so it will be replaced

                chatMessages(listOf())
                // Input submits form as JSON to the websocket
                form {
                    attributes["hx-ws"] = "send:submit"
                    chatInput()
                }
            }
        }
    }

fun FlowContent.chatMessages(messages: List<Message>) =
    div {
        id = "messages"
        messages.map {
            p {
                classes = setOf(
                    "rounded-md",
                    "my-2",
                    "w-full",
                    "px-4",
                    "py-2",
                ) + if (it.sent) "bg-blue-200" else "bg-neutral-200"
                +it.message
            }
        }
    }

fun FlowContent.chatInput() =
    input {
        id = "input"
        name = "message"
        type = InputType.text
        classes = setOf("w-full", "h-8", "border-2", "border-neutral-200", "rounded-md")
        value = ""
        autoFocus = true
    }
