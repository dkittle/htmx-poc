package ca.kittle.models

data class Message(
    val message: String,
    val sent: Boolean,
)

data class Person(
    val name: String,
    val email: String,
    val role: String,
    val imageUrl: String,
    val lastSeen: String?,
    val lastSeenDateTime: String? = null,
)
