package org.ilfidev.mooduck.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoodBoardPage(
    val page: Int,
    val limit: Int,
    @SerialName("prev_page") val prevPage: String?,
    @SerialName("next_page") val nextPage: String?,
    val amount: Int,
    val items: List<MoodBoardCard>
)
