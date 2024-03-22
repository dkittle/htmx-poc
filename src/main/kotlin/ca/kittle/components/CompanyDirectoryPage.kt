@file:Suppress("ktlint:standard:no-wildcard-imports")

package ca.kittle.components

import ca.kittle.models.Person
import ca.kittle.services.PeopleService
import kotlinx.html.*

fun FlowContent.companyDirectoryPage(
    nameEnabled: Boolean = true,
    emailEnabled: Boolean = true,
    lastOnlineEnabled: Boolean = true,
) = div {
    // List of people
    val people = PeopleService.getPeople()

    header {
        classes = setOf("bg-white", "shadow")
        div {
            classes = setOf("mx-auto", "max-w-7xl", "px-4", "py-6", "sm:px-6", "lg:px-8")
            h1 {
                classes = setOf("text-3xl", "font-bold", "tracking-tight", "text-gray-900")
                +"Input updates a separate component"
            }
        }
    }
    main {
        div {
            classes = setOf("mx-auto", "max-w-7xl", "py-6", "sm:px-6", "lg:px-8")
            // Inputs post a form request with the updated values
            // Response updates the whole content div
            div {
                personDataFilter(nameEnabled, emailEnabled, lastOnlineEnabled)
                people(people, nameEnabled, emailEnabled, lastOnlineEnabled)
            }
        }
    }
}

private fun FlowContent.personDataFilter(
    nameEnabled: Boolean,
    emailEnabled: Boolean,
    lastOnlineEnabled: Boolean,
) = form {
    classes = setOf("max-w-sm", "mx-auto", "my-4", "gap-2")

    input {
        attributes["hx-post"] = "/content/multi-select/table/name/$nameEnabled"
        attributes["hx-target"] = "#content"

        id = "name"
        type = InputType.checkBox
        name = "name"
        value = nameEnabled.toString()
        checked = nameEnabled
    }
    label {
        htmlFor = "multi-select"
        +" Name"
    }
    br { }
    input {
        attributes["hx-post"] = "/content/multi-select/table/email/$emailEnabled"
        attributes["hx-target"] = "#content"

        id = "email"
        type = InputType.checkBox
        name = "email"
        value = emailEnabled.toString()
        checked = emailEnabled
    }
    label {
        htmlFor = "email"
        +" Email"
    }
    br { }
    input {
        attributes["hx-post"] = "/content/multi-select/table/last-online/$lastOnlineEnabled"
        attributes["hx-target"] = "#content"

        id = "last-online"
        type = InputType.checkBox
        name = "last-online"
        value = lastOnlineEnabled.toString()
        checked = lastOnlineEnabled
    }
    label {
        htmlFor = "last-online"
        +" Last Online"
    }
    br { }
}

private fun FlowContent.people(
    people: List<Person>,
    nameEnabled: Boolean,
    emailEnabled: Boolean,
    lastOnlineEnabled: Boolean,
) = ul {
    role = "list"
    classes = setOf("divide-y", "divide-gray-100")
    people.map { person ->
        li {
            classes = setOf("flex", "justify-between", "gap-x-6", "py-5")
            div {
                classes = setOf("flex", "min-w-0", "gap-x-4")
                img {
                    classes = setOf("h-12", "w-12", "flex-none", "rounded-full", "bg-gray-50")
                    src = person.imageUrl
                    alt = ""
                }
                div {
                    classes = setOf("min-w-0", "flex-auto")
                    // Conditional rendering
                    if (nameEnabled) {
                        p {
                            classes = setOf("text-sm", "font-semibold", "leading-6", "text-gray-900")
                            +person.name
                        }
                    }
                    if (emailEnabled) {
                        p {
                            classes = setOf("mt-1", "truncate", "text-xs", "leading-5", "text-gray-500")
                            +person.email
                        }
                    }
                }
            }
            div {
                classes = setOf("hidden", "shrink-0", "sm:flex", "sm:flex-col", "sm:items-end")
                p {
                    classes = setOf("text-sm", "leading-6", "text-gray-900")
                    +person.role
                }
                if (lastOnlineEnabled) {
                    if (person.lastSeenDateTime != null && person.lastSeen != null) {
                        p {
                            classes = setOf("mt-1", "text-xs", "leading-5", "text-gray-500")
                            +"Last seen "
                            time {
                                attributes["datetime"] = person.lastSeenDateTime
                                +person.lastSeen
                            }
                        }
                    } else {
                        div {
                            classes = setOf("mt-1", "flex", "items-center", "gap-x-1.5")
                            div {
                                classes = setOf("flex-none", "rounded-full", "bg-emerald-500/20", "p-1")
                                div {
                                    classes = setOf("h-1.5", "w-1.5", "rounded-full", "bg-emerald-500")
                                }
                            }
                            p {
                                classes = setOf("text-xs", "leading-5", "text-gray-500")
                                +"Online"
                            }
                        }
                    }
                }
            }
        }
    }
}
