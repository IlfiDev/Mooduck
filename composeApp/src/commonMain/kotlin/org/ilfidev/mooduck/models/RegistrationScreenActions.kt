package org.ilfidev.mooduck.models

 sealed interface RegistrationScreenActions {
     data object PressRegisterButton: RegistrationScreenActions
     data object PressLoginButton: RegistrationScreenActions
     data class PressPageButton(val pageButton: RegisterPageState) : RegistrationScreenActions
     data class ChangeUsernameText(val newText: String): RegistrationScreenActions
     data class ChangeEmailText(val newText: String): RegistrationScreenActions
     data class ChangePasswordText(val newText: String): RegistrationScreenActions
     data class ChangeAuthUsernameText(val newText: String): RegistrationScreenActions
     data class ChangeAuthPasswordText(val newText: String): RegistrationScreenActions
}