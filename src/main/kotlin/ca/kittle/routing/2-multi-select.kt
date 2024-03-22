package ca.kittle.routing

import ca.kittle.components.companyDirectoryPage
import io.ktor.server.application.call
import io.ktor.server.html.respondHtml
import io.ktor.server.request.receiveParameters
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import kotlinx.html.body
import kotlinx.html.div

fun Routing.multiSelect() {
    get("/content/multi-select") {
        call.respondHtml {
            body {
                companyDirectoryPage()
            }
        }
    }

    post("/content/multi-select/table/{attribute}/{enabled}") {
        val attribute = call.parameters["attribute"]
        val enabled = call.parameters["enabled"].toBoolean()
        val parameters = call.receiveParameters()

        val name = if (attribute == "name") !enabled else parameters["name"].toBoolean()
        val email = if (attribute == "email") !enabled else parameters["email"].toBoolean()
        val lastOnline = if (attribute == "last-online") !enabled else parameters["last-online"].toBoolean()

        call.respondHtml {
            body {
                companyDirectoryPage(name, email, lastOnline)
            }
        }
    }
}
