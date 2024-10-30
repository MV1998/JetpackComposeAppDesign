package com.example.jetpackcomposeuidesigns

import android.accounts.AccountManager
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.icu.number.NumberFormatter.UnitWidth
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShoppingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val channelId = "timer_channel_id"
            val channelName = "Timer Channel"
            val channelDescription = "Channel for timer notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
                setSound(null, null)
            }

            val manager = getSystemService(NotificationManager::class.java) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        val newList = makeList {
            add("Simple")
            add("Another")
        }
    }

        fun makeList(init : MutableList<String>.() -> Unit) : List<String> {
            val newList = mutableListOf<String>()
            newList.init()
            return newList
        }
}