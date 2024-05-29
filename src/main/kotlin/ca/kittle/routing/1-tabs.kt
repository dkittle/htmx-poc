@file:Suppress("ktlint:standard:filename")

package ca.kittle.routing

import ca.kittle.components.emptyTabPage
import io.ktor.server.application.call
import io.ktor.server.html.respondHtml
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import kotlinx.html.body
import kotlinx.html.div
import kotlin.collections.set

fun Routing.tabs() {
    get("/content/empty") {
        call.respondHtml {
            body {
                emptyTabPage()
            }
        }
    }
}
