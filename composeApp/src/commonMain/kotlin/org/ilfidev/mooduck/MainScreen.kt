package org.ilfidev.mooduck

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ilfidev.mooduck.ui.MainActivityTopBar
import org.ilfidev.mooduck.ui.MoodboardCard
import org.ilfidev.mooduck.ui.SearchBarWithButtons
import org.ilfidev.mooduck.viewmodel.MoodBoardPageActions
import org.ilfidev.mooduck.viewmodel.MoodBoardsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen() {
    val viewModel = koinViewModel<MoodBoardsViewModel>()
    val state = viewModel.state.collectAsState()
    Scaffold(topBar = {
        MainActivityTopBar(
            headerMainText = "MOOOODUCK",
            switch = { Switch(state.value.moodBoardItemSwitchState, onCheckedChange = {viewModel.onAction(MoodBoardPageActions.ToggleSwitch)}) },
            searchField = { SearchBarWithButtons(hint = "Start searching", cornerShape = RoundedCornerShape(100.dp)) })

    }
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(500.dp),
            verticalItemSpacing = 40.dp,
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            content = {
                items(state.value.moodBoardCards) { card ->
                    MoodboardCard(card, onCardClick = {text -> })
                }
            },
            modifier = Modifier.fillMaxSize().padding(vertical = 50.dp, horizontal = 170.dp)
        )

    }
}

data class MainCardData(
    val title: String,
    val likesCount: Int,
    val description: String,
    val author: String? = null,
    val imageUrl: String? = "https://upload.wikimedia.org/wikipedia/en/6/64/Morrigan%28Darkstalkers%29.png",
)