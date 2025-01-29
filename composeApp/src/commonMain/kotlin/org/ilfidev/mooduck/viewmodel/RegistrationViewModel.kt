package org.ilfidev.mooduck.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.ilfidev.mooduck.BoardsDataRepository
import org.ilfidev.mooduck.RegistrationRepository
import org.ilfidev.mooduck.models.RegistrationScreenActions
import org.ilfidev.mooduck.models.RegistrationScreenState
import org.ilfidev.mooduck.models.UserReg

class RegistrationViewModel(
    private val registrationRepository: RegistrationRepository
): ViewModel() {

    private val _state = MutableStateFlow(RegistrationScreenState())
    val state: StateFlow<RegistrationScreenState> = _state

    fun onAction(action: RegistrationScreenActions) {
        when (action) {
            is RegistrationScreenActions.PressRegisterButton -> registerUser()
            is RegistrationScreenActions.ChangeEmailText -> updateEmail(action.newText)
            is RegistrationScreenActions.ChangePasswordText -> updatePassword(action.newText)
            is RegistrationScreenActions.ChangeUsernameText -> updateUsername(action.newText)
        }
    }

    private fun updateUsername(newValue: String) {
        _state.value = state.value.copy(username = newValue)
    }

    private fun updateEmail(newValue: String) {
        _state.value = state.value.copy(email = newValue)
    }

    private fun updatePassword(newValue: String) {
        _state.value = state.value.copy(password = newValue)
    }
    fun registerUser() {
        viewModelScope.launch {
            val stateValue = _state.value
            print("HUINYA AAA, $stateValue")
            registrationRepository.register(UserReg(username = stateValue.username, email = stateValue.email, password = stateValue.password))
        }
    }
}