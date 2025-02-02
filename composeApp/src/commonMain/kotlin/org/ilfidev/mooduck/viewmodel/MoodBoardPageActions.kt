package org.ilfidev.mooduck.viewmodel

import org.ilfidev.mooduck.repository.MoodBoardRepository

sealed interface MoodBoardPageActions {
    data class ClickLike(val moodBoardId: Int) : MoodBoardPageActions
    data class ChangeSearchText(val newText: String) : MoodBoardPageActions
    data object ToggleSwitch : MoodBoardPageActions
    data object FetchData: MoodBoardPageActions


}