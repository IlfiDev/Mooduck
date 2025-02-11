package org.ilfidev.mooduck.networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.ilfidev.mooduck.models.MoodBoardPage
import org.ilfidev.mooduck.models.UserReg
import org.ilfidev.mooduck.models.UserRegResponse
import org.ilfidev.mooduck.util.NetworkError
import org.ilfidev.mooduck.util.Result

class WebClient (
    private val httpClientConfig: HttpClientConfig
) {
    private val httpClient: HttpClient = httpClientConfig.getHttpClient()
    suspend fun sendRegisterRequest(user: UserReg) : Result<Int, NetworkError> {
        val response = try {

            httpClient.post(
                urlString = "https://mooduckapi.ilfidevservices.keenetic.pro/user"
            ) {
//                contentType(ContentType.Application.Json)
                header("Origin", "https://mooduck.ilfidevservices.keentic.pro")
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
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    suspend fun sendAuthRequest(username: String, password: String) : Result<String, NetworkError> {
        val response = try {
            httpClient.post(
                urlString = "https://mooduckapi.ilfidevservices.keenetic.pro/auth"
            ) {
                header("Origin", "https://mooduck.ilfidevservices.keentic.pro")
                setBody(FormDataContent(Parameters.build {
                    append("username", username)
                    append("password", password)
                }))
//                parameter("text", "")
//                contentType(ContentType.Application.Json)
//                setBody(
//                    user
//                )
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }
        return when(response.status.value) {
            in 200..299 -> {
                val result = response.body<String>()
                Result.Success(result)
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }

    suspend fun getMoodBoards(searchQuery: String, page: Int) : Result<MoodBoardPage, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = "https://mooduckapi.ilfidevservices.keenetic.pro/moodboard"
            ) {

                header("Origin", "https://mooduck.ilfidevservices.keentic.pro")
                contentType(ContentType.Application.FormUrlEncoded)
                url {
                    parameters.append("search", searchQuery)
                    parameters.append("page", page.toString())
                }
//                parameter("text", "")
//                contentType(ContentType.Application.Json)
//                setBody(
//                    user
//                )
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }
        return when(response.status.value) {
            in 200..299 -> {
                val result = response.body<MoodBoardPage>()
                Result.Success(result)
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }
}