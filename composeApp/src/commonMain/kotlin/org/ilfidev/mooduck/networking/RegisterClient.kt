package org.ilfidev.mooduck.networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.ilfidev.mooduck.models.UserReg
import org.ilfidev.mooduck.models.UserRegResponse
import org.ilfidev.mooduck.util.NetworkError
import org.ilfidev.mooduck.util.Result

class RegisterClient (
    private val httpClientConfig: HttpClientConfig
) {
    private val httpClient: HttpClient = httpClientConfig.getHttpClient()
    suspend fun sendRegisterRequest(user: UserReg) : Result<Int, NetworkError> {
        val response = try {

            httpClient.post(
                urlString = "http://192.168.1.59:8888/user"
            ) {
                parameter("text", "")
                contentType(ContentType.Application.Json)
                setBody(
                    user
                )
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when(response.status.value) {
            in 200..299 -> {
                val result = response.body<UserRegResponse>()
                Result.Success(result.id)
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            else -> Result.Error(NetworkError.SERVER_ERROR)
        }
    }
}