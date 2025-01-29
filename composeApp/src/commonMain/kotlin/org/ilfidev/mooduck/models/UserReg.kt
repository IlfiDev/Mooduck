package org.ilfidev.mooduck.models

import kotlinx.serialization.Serializable


@Serializable
data class UserReg(
    val username: String,
    val email: String,
    val password: String,
    val name: String = ".",
    val bio: String = "."
)
