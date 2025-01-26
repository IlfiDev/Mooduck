package org.ilfidev.mooduck.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.ilfidev.mooduck.BoardsDataRepository
import org.ilfidev.mooduck.RegistrationRepository
import org.ilfidev.mooduck.models.UserReg

class RegistrationViewModel(
    private val registrationRepository: RegistrationRepository
): ViewModel() {
    fun registerUser(user: UserReg) {
        viewModelScope.launch {
            registrationRepository.register(user)
        }
    }
}