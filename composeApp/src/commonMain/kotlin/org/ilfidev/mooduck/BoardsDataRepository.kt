package org.ilfidev.mooduck

interface BoardsDataRepository {
    fun getBoard(): String
}

class BoardsRepositoryBackendImpl() : BoardsDataRepository {
    override fun getBoard(): String {
        return ""
    }
}

class BoardsRepositoryDbImpl(
    private val dbClient: DbClient
) : BoardsDataRepository {
    override fun getBoard(): String {
        return ""
    }

}