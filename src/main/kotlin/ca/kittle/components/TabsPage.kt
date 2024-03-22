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
            }
        }
    }
