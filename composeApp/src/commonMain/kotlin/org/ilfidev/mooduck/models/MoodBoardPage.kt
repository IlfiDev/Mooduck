package org.ilfidev.mooduck.models

import kotlinx.serialization.Serializable

@Serializable
data class MoodBoardPage(
    val page: Int,
    val limit: Int,
    val prevPage: String,
    val nextPage: String,
    val amount: Int,
    val items: List<MoodBoardCard>
)
