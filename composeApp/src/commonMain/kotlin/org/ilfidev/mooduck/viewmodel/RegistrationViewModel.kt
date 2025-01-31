package org.ilfidev.mooduck.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.ilfidev.mooduck.RegistrationRepository
import org.ilfidev.mooduck.models.RegisterPageState
import org.ilfidev.mooduck.models.RegistrationScreenActions
import org.ilfidev.mooduck.models.RegistrationScreenState
import org.ilfidev.mooduck.models.UserReg
import org.ilfidev.mooduck.util.Result

class RegistrationViewModel(
    private val registrationRepository: RegistrationRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationScreenState())
    val state: StateFlow<RegistrationScreenState> = _state

    fun onAction(action: RegistrationScreenActions) {
        when (action) {
            is RegistrationScreenActions.PressRegisterButton -> registerUser()
            is RegistrationScreenActions.ChangeEmailText -> updateEmail(action.newText)
            is RegistrationScreenActions.ChangePasswordText -> updatePassword(action.newText)
            is RegistrationScreenActions.ChangeUsernameText -> updateUsername(action.newText)
            is RegistrationScreenActions.ChangeAuthPasswordText -> updateAuthUsername(action.newText)
            is RegistrationScreenActions.ChangeAuthUsernameText -> updateAuthPassword(action.newText)
            is RegistrationScreenActions.PressLoginButton -> authUser()
            is RegistrationScreenActions.PressPageButton -> updatePageState(action.pageButton)
        }
    }

    private fun updatePageState(pageButton: RegisterPageState) {
        _state.value = state.value.copy(page = pageButton)
    }

    private fun authUser() {
        viewModelScope.launch {
            val stateValue = _state.value
            val result = registrationRepository.auth(
                stateValue.loginUsername, stateValue.loginPassword
            )
            _state.value = when (result) {
                is Result.Success -> {
                    state.value.copy(authResult = Result.Success(result.data))
                }

                is Result.Error -> {
                    state.value.copy(authResult = Result.Error(result.error))
                }
            }
        }
    }

    private fun updateAuthPassword(newText: String) {
        _state.value = state.value.copy(loginPassword = newText)
    }

    private fun updateAuthUsername(newText: String) {
        _state.value = state.value.copy(loginUsername = newText)
    }

    private fun updateUsername(newValue: String) {
        _state.value = state.value.copy(signupUsername = newValue)
    }

    private fun updateEmail(newValue: String) {
        _state.value = state.value.copy(signupEmail = newValue)
    }

    private fun updatePassword(newValue: String) {
        _state.value = state.value.copy(signupPassword = newValue)
    }

    fun registerUser() {
        viewModelScope.launch {
            val stateValue = _state.value
            val result = registrationRepository.register(
                UserReg(
                    username = stateValue.signupUsername,
                    email = stateValue.signupEmail,
                    password = stateValue.signupPassword
                )
            )
            _state.value = when (result) {
                is Result.Success -> {
                    state.value.copy(registerResult = Result.Success(result.data))
                }

                is Result.Error -> {
                    state.value.copy(registerResult = Result.Error(result.error))
                }
            }
        }
    }
}