package org.ilfidev.mooduck

import io.ktor.client.engine.HttpClientEngine
import org.ilfidev.mooduck.models.UserReg
import org.ilfidev.mooduck.networking.RegisterClient
import org.ilfidev.mooduck.util.NetworkError
import org.ilfidev.mooduck.util.Result

interface RegistrationRepository {
    suspend fun register(user: UserReg) : Result<Int, NetworkError>
    suspend fun auth(username: String, password: String ): Result<String, NetworkError>
}

class RegistrationRepositoryImpl(private val client: RegisterClient): RegistrationRepository {
    override suspend fun register(user: UserReg) = client.sendRegisterRequest(user)
    override suspend fun auth(username: String, password: String) = client.sendAuthRequest(username, password)


}