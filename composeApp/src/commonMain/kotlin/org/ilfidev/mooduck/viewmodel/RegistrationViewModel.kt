package org.ilfidev.mooduck.viewmodel

import androidx.lifecycle.ViewModel
import org.ilfidev.mooduck.BoardsDataRepository

class RegistrationViewModel(
    private val boardsRepository: BoardsDataRepository
): ViewModel() {
    fun getHelloWorldString(): String {
        return "aboba"
    }
}