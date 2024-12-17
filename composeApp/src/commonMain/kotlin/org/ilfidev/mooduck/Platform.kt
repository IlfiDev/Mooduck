package org.ilfidev.mooduck

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform