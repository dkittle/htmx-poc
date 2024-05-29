@file:Suppress("ktlint:standard:no-wildcard-imports")

package ca.kittle.routing

import ca.kittle.components.navigation
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Routing.index() {
    get {
        call.respondHtml {
            head {
                script {
//                        src = "https://unpkg.com/htmx.org@1.9.10"
                    src = "static/assets/htmx.min.js"
                }
                meta {
                    name = "viewport"
                    content = "width=device-width, initial-scale=1.0"
                }
                link {
                    href = "static/assets/output.css"
                    rel = "stylesheet"
                }
            }
            body {
                classes = setOf("md:container", "md:mx-auto", "px-4")
                navigation()
            }
        }
    }
    static("/static") {
        resources("static")
    }
}
