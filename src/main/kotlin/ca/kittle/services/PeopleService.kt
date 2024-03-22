package ca.kittle.services

import ca.kittle.models.Person

object PeopleService {
    fun getPeople(): List<Person> =
        listOf(
            Person(
                "Leslie Alexander",
                "leslie.alexander@example.com",
                "Co-Founder / CEO",
                "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                "3h ago",
                "2023-01-23T13:23Z",
            ),
            Person(
                "Michael Foster",
                "michael.foster@example.com",
                "Co-Founder / CTO",
                "https://images.unsplash.com/photo-1519244703995-f4e0f30006d5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                "3h ago",
                "2023-01-23T13:23Z",
            ),
            Person(
                "Dries Vincent",
                "dries.vincent@example.com",
                "Business Relations",
                "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                null,
            ),
            Person(
                "Lindsay Walton",
                "lindsay.walton@example.com",
                "Front-end Developer",
                "https://images.unsplash.com/photo-1517841905240-472988babdf9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                "3h ago",
                "2023-01-23T13:23Z",
            ),
            Person(
                "Courtney Henry",
                "courtney.henry@example.com",
                "Designer",
                "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                "3h ago",
                "2023-01-23T13:23Z",
            ),
            Person(
                "Tom Cook",
                "tom.cook@example.com",
                "Director of Product",
                "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                null,
            ),
        )
}
