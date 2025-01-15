package org.ilfidev.mooduck.model

data class User(
  @SerializedName("username") val username: String,
  @SerializedName("email") val email: String,
  @SerializedName("password") val password: String,
  @SerializedName("name") val name: String,
  @SerializedName("bio") val bio: String,
)