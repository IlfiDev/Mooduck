package org.ilfidev.mooduck.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ilfidev.mooduck.repository.MoodBoardRepository

class MoodBoardsViewModel(
    private val moodBoardRepository: MoodBoardRepository
): ViewModel() {
    private val _state = MutableStateFlow(MoodBoardPageState())
    val state: StateFlow<MoodBoardPageState> = _state

    fun onAction(action: MoodBoardPageActions) {
        when (action) {
            is MoodBoardPageActions.ChangeSearchText -> TODO()
            is MoodBoardPageActions.ClickLike -> TODO()
            is MoodBoardPageActions.ToggleSwitch -> handleSwitchToggle()
        }

    }

    private fun handleSwitchToggle() {
        _state.update { it.copy(moodBoardItemSwitchState = !it.moodBoardItemSwitchState) }
    }
    fun fetchMoodBoards(query: String, page: Int) {
        viewModelScope.launch {
            moodBoardRepository.fetchBoards(query, page)
        }
    }
}