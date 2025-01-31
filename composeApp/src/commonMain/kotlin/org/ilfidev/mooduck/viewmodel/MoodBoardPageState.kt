package org.ilfidev.mooduck.viewmodel

import org.ilfidev.mooduck.models.MoodBoardCard

data class MoodBoardPageState(
    val moodBoardCards: List<MoodBoardCard> = listOf(MoodBoardCard()),
    val moodBoardItemSwitchState: Boolean = true,
    val profileDropDownIsOpen: Boolean = false,
    val searchText: String = "",
)
