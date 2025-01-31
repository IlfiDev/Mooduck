package org.ilfidev.mooduck.models

import kotlinx.serialization.Serializable


@Serializable
data class MoodBoardCard(
    val id: Int = -1,
    val author: UserRegResponse = UserRegResponse(-1, "", "", "", null, null),
    val name: String = "",
    val description: String = "",
    val cover: String = "",
    val createdAt: String = "", // Using OffsetDateTime for ISO 8601 date-time format
    val isPrivate: Boolean = true,
    val isChaotic: Boolean = true,
    val likes: Int = -1

)
