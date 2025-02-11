package org.ilfidev.mooduck.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ilfidev.mooduck.viewmodel.MoodBoardPageActions

@Composable
fun MoodBoardCreationScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        MainActivityTopBar(
            headerMainText = "MOOOODUCK",
            switch = {
                Switch(state.value.moodBoardItemSwitchState, onCheckedChange = {
                    viewModel.onAction(
                        MoodBoardPageActions.ToggleSwitch
                    )
                })
            },
            searchField = {
                SearchBarWithButtons(
                    hint = "Start searching",
                    cornerShape = RoundedCornerShape(100.dp)
                )
            })
    }
}

@Composable
fun MainContent() {
    MainRegisterCard()
}

