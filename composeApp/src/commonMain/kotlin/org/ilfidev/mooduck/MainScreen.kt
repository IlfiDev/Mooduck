package org.ilfidev.mooduck

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    val list = listOf(
        MainCardData("Аниме бабы", 666, "aaaawrstarstarstarstartarst"),
        MainCardData(
            "Аниме мужики",
            9999,
            "arsiotneariostnoaristnaiorsntoarisetnariosetnoarietnarioetnaristnarietnariosetnariostnioarsntaaaawrstarstarstarstartarst"
        ),
        MainCardData(
            "Аниме мужики",
            9999,
            "arsiotneariostnoaristnaiorsntoarisetnariosetnoarietnarioetnaqwfpqwfpristnarietnariosetnariostnioarsntaaaawrstarstarstarstartarst"
        ),
        MainCardData(
            "Аниме мужики",
            9999,
            "arsiotneariostnoaristnaiorsntoarisetqwfpqwfpqwfpqwfpqwfpqwfpnariosetnoarietnarioetnaristnarietnariosetnariostnioarsntaaaawrstarstarstarstartarst",
            imageUrl = "https://media.themoviedb.org/t/p/w300_and_h450_bestv2/ntwPvV4GKGGHO3I7LcHMwhXfsw9.jpg"
        ),
        MainCardData
            (
            "Аниме мужики",
            9999,
            "iotneariostnoaristnaiorsntoarisearstarsqwfqwfptnariosetnoarietnarioeqwfptnaristnarietnariosetnariostnioarsntaaaawrstarstarstarstartarst"
        ),
        MainCardData(
            "Аниме мужики",
            9999,
            "arsiotneariostnoaristnaiorsntoarisetnariosetnoarietnarioetnaristnarietnaqwfqqqwfpqwfpqwfpriosetnariostnioarsntaaaawrstarstarstarstartarst"
        ),
        MainCardData(
            "Аниме мужики",
            9999,
            "tneariostnoaristnaiorsntoarisetnariosetnoarietnarioetnaristnarietnariosetnariostnioarsntaaaawrstarstarstarstartarst"
        ),
        MainCardData(
            "Аниме мужики",
            9999,
            "arsiotneariostnoaristnaiorsntoarisetnarioseqwfpqwfpqwfpqwfpqwfpqwfpqwfpqwfpqwfpqwfpqwftnoarietnarioetnaristnarietnariosetnariostnioarsntaaaawrstarstarstarstartarst",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Mads_Mikkelsen_by_Gage_Skidmore_2.jpg/1024px-Mads_Mikkelsen_by_Gage_Skidmore_2.jpg",
        ),
        MainCardData(
            "Аниме мужики",
            9999,
            "arsiotneariostnoaristnaiorsntoarisetnariosetnoarietnarioetnaristnarietnariosetnariostqwqwfpqwnioarsntaaaawrstarstarstarstartarst"
        ),
        MainCardData(
            "Аниме мужикииииииИИииииИИИиИИИИиииИИИ",
            9999,
            "tnaiorsntoarisetnariosetnoarietnarioetnaristnarietnariosetnariostnioarsntaaaawrstarstarstarstqwfqwqqqwf34partarst",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/a/ab/Kojima_Death_Stranding_2018.jpg"
        ),
        MainCardData("Аниме мужики", 9999, "aaaawrstarstarstarstartarst"),
        MainCardData(
            "Аниме мужики",
            9999,
            "arsiotneariostnoaristnaiorsntoarisetnariosetnoarietnarioetnaristnarietnariosetnariostnioarsntaaaawrstarstarstarstartarst"
        ),
    )
    Scaffold(topBar = {
        MainActivityTopBar()
    }
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(500.dp),
            verticalItemSpacing = 40.dp,
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            content = {
                items(list) { card ->
                    MainCard(card)
                }
            },
            modifier = Modifier.fillMaxSize().padding(50.dp)
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