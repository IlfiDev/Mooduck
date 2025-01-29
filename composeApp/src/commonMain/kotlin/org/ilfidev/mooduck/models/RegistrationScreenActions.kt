package org.ilfidev.mooduck.models

 sealed interface RegistrationScreenActions {
     data object PressRegisterButton: RegistrationScreenActions
     data class ChangeUsernameText(val newText: String): RegistrationScreenActions
     data class ChangeEmailText(val newText: String): RegistrationScreenActions
     data class ChangePasswordText(val newText: String): RegistrationScreenActions
}