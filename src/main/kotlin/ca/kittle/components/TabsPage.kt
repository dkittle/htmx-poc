@file:Suppress("ktlint:standard:no-wildcard-imports")

package ca.kittle.components

import kotlinx.html.*

fun FlowContent.emptyTabPage() =
    div {
        header {
            classes = setOf("bg-white", "shadow")
            div {
                classes = setOf("mx-auto", "max-w-7xl", "px-4", "py-6", "sm:px-6", "lg:px-8")
                h1 {
                    classes = setOf("text-3xl", "font-bold", "tracking-tight", "text-gray-900")
                    +"Tabs"
                }
            }
        }
        main {
            div {
                classes = setOf("mx-auto", "max-w-7xl", "py-6", "sm:px-6", "lg:px-8")
                h1 {
                    classes = setOf("text-2xl", "font-bold", "my-5")
                    +"Simple Request Example!"
                }
                button {
//                    attributes["hx-get"] = "https://jsonplaceholder.typicode.com/users"
                    attributes["hx-get"] = "/users"
//                    attributes["hx-trigger"] = "mouseover"
                    attributes["hx-swap"] = "outerHTML"
                    classes = setOf("bg-blue-500", "text-white", "px-3", "py-2", "rounded-lg")
                    +"Fetch Users"
                }
                div {
                    id = "users"
                }
            }
        }
    }
