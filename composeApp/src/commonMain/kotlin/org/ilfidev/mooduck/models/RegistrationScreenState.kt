package org.ilfidev.mooduck.models

data class RegistrationScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
)

