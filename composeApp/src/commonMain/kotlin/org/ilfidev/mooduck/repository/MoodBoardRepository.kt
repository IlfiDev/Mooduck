package org.ilfidev.mooduck.repository

import org.ilfidev.mooduck.models.MoodBoardPage
import org.ilfidev.mooduck.networking.WebClient
import org.ilfidev.mooduck.util.NetworkError
import org.ilfidev.mooduck.util.Result

interface MoodBoardRepository {
    suspend fun fetchBoards(query: String, page: Int) : Result<MoodBoardPage, NetworkError>
}

class MoodBoardRepositoryImpl(private val client: WebClient) : MoodBoardRepository{
    override suspend fun fetchBoards(
        query: String,
        page: Int
    ) = client.getMoodBoards(query, page)

}