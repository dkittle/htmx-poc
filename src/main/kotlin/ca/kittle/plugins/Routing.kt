@file:Suppress("ktlint:standard:no-wildcard-imports")

package ca.kittle.plugins

import ca.kittle.routing.*
import ca.kittle.routing.users.listUsers
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        index()
        tabs()
        multiSelect()
        animation()
        loading()
        chat()
        // Users
        listUsers()
    }
}
