package org.ilfidev.mooduck.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ilfidev.mooduck.repository.MoodBoardRepository
import org.ilfidev.mooduck.util.Result

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
            is MoodBoardPageActions.FetchData -> fetchMoodBoards()
        }

    }

    private fun handleSwitchToggle() {
        println("Mod")
        _state.update { it.copy(moodBoardItemSwitchState = !it.moodBoardItemSwitchState) }
    }
    private fun fetchMoodBoards() {
        viewModelScope.launch {
            val query = state.value.searchText
            val page = 1
            val result = moodBoardRepository.fetchBoards(query, page)
            when (result) {
                is Result.Error -> {
                    println("MoodBoardGovnaERROR ${result.error.name}")
                }
                is Result.Success -> {
                    _state.update { it.copy(moodBoardCards = result.data.items)}
                    println("MoodBoardGovnaSuccess $state")
                }
            }
        }
    }
}