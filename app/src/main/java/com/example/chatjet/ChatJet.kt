package com.example.chatjet

import android.app.Application
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.client.models.image
import io.getstream.chat.android.client.models.name
import io.getstream.chat.android.livedata.ChatDomain

class ChatJet : Application() {
    override fun onCreate() {
        super.onCreate()

        val client = ChatClient.Builder(appContext = this, apiKey = "w98jse23rkdd")
            .logLevel(ChatLogLevel.ALL)
            .build()

        val user = User().apply {
            id = "ishu"
            image = "https://bit.ly/2TIt8NR"
            name = "Ishu"
        }

        ChatDomain.Builder(client, this)
            .offlineEnabled()
            .build()

        client.connectUser(
            user,
            "mkh2qtjdjgygwkw5gcqzbc337ptgbr3qw59mcamu6hgu95hjyecgk5cqad78adfx"
        ).enqueue()
    }
}