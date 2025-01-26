package org.ilfidev.mooduck

import io.ktor.client.engine.HttpClientEngine
import org.ilfidev.mooduck.models.UserReg
import org.ilfidev.mooduck.networking.RegisterClient

interface RegistrationRepository {
    suspend fun register(user: UserReg)
}

class RegistrationRepositoryImpl(private val client: RegisterClient): RegistrationRepository {
    override suspend fun register(user: UserReg) {
        val result = client.sendRegisterRequest(user)
        println(result)
    }

}