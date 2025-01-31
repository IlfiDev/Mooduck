package org.ilfidev.mooduck.models

import org.ilfidev.mooduck.util.NetworkError
import org.ilfidev.mooduck.util.Result

data class RegistrationScreenState(
    val signupUsername: String = "",
    val signupEmail: String = "",
    val signupPassword: String = "",
    val loginUsername: String = "",
    val loginPassword: String = "",
    val page: RegisterPageState = RegisterPageState.REGISTER,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val registerResult: Result<Int, NetworkError> = Result.Success(-1),
    val authResult: Result <String, NetworkError> = Result.Success("")
)

enum class RegisterPageState {
    REGISTER,
    LOGIN,
}