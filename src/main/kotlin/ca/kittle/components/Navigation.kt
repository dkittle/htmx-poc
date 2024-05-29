@file:Suppress("ktlint:standard:no-wildcard-imports")

package ca.kittle.components

import kotlinx.html.*

fun FlowContent.navigation() {
    // List of tabs
    val tabs =
        listOf(
            Tab("Tabs", "/content/empty"),
            Tab("Input updates a separate component", "/content/multi-select"),
            Tab("Animation", "/content/animation"),
            Tab("Asynchronous Loading", "/content/loading"),
            Tab("Chat", "/content/chat"),
        )
    div {
        classes = setOf("min-h-full")
        nav {
            classes = setOf("bg-gray-800")
            div {
                classes = setOf("mx-auto", "max-w-7xl", "px-4", "sm:px-6", "lg:px-8")
                div {
                    classes = setOf("flex", "h-16", "items-center", "justify-between")
                    div {
                        classes = setOf("flex", "items-center")
                        div {
                            classes = setOf("flex-shrink-0")
                            img {
                                classes = setOf("h-8", "w-8")
                                src = "https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=500"
                                alt = "Your Company"
                            }
                        }
                        div {
                            classes = setOf("hidden", "md:block")
                            div {
                                classes = setOf("ml-10", "flex", "items-baseline", "space-x-4")
                                tabs.map {
                                    a {
                                        // Fetch from the URL and update the content div
                                        attributes["hx-get"] = it.url
                                        attributes["hx-target"] = "#content"
                                        attributes["hx-push-url"] = "true"

                                        classes =
                                            setOf(
                                                "text-gray-300",
                                                "hover:bg-gray-700",
                                                "hover:text-white",
                                                "rounded-md",
                                                "px-3",
                                                "py-2",
                                                "text-sm",
                                                "font-medium",
                                            )
                                        +it.name
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        div {
            // ID of "content" is used to switch the page
            id = "content"
            emptyTabPage()
        }
    }
}

private data class Tab(
    val name: String,
    val url: String,
)
