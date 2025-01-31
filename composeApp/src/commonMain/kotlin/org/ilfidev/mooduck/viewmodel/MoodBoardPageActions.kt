package org.ilfidev.mooduck.viewmodel

sealed interface MoodBoardPageActions {
    data class ClickLike(val moodBoardId: Int) : MoodBoardPageActions
    data class ChangeSearchText(val newText: String) : MoodBoardPageActions
    data object ToggleSwitch : MoodBoardPageActions


}