package ca.kittle.routing

import ca.kittle.components.navigation
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.script

fun Routing.index() {
    get {
        call.respondHtml {
            head {
                script {
//                        src = "https://unpkg.com/htmx.org@1.9.10"
                    src = "static/assets/htmx.min.js"
                }
                script {
//                        src = "https://cdn.tailwindcss.com"
                    src = "static/assets/tailwind.js"
                }
            }
            body {
                navigation()
            }
        }
    }
    static("/static") {
        resources("static")
    }
}
