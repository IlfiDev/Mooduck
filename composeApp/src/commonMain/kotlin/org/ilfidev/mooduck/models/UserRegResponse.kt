package org.ilfidev.mooduck.models

import kotlinx.serialization.Serializable

@Serializable
data class UserRegResponse(
    val id: Int,
    val username: String,
    val email: String,
    val name: String,
    val role: String,
    val bio: String
)
