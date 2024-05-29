@file:Suppress("ktlint:standard:no-wildcard-imports")

package ca.kittle.routing.users

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.serialization.json.Json

fun Routing.listUsers() {
    get("/users") {
        val users = ListUsersService.getUsers()
//        call.respond(users)
        call.respondHtml {
            body {
                h1 {
                    classes = setOf("text-2xl", "fond-bold", "my-4")
                    +"Users"
                }
                ul {
                    for (user in users) {
                        li {
                            +user.name
                        }
                    }
                }
            }
        }
    }
}

object ListUsersService {
    suspend fun getUsers(): List<User> {
        val client = HttpClient(CIO)
        val response = client.request("https://jsonplaceholder.typicode.com/users")
        return Json.decodeFromString(response.toString())
//        return listOf(
//            User(1, "John Doe"),
//            User(2, "Bob Williams"),
//            User(3, "John Doe"),
//        )
    }
}

data class User(
    val id: Int,
    val name: String,
)
