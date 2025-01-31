package org.ilfidev.mooduck.models

import org.ilfidev.mooduck.util.NetworkError
import org.ilfidev.mooduck.util.Result

data class RegistrationScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val registerResult: Result<Int, NetworkError> = Result.Success(-1),
)

