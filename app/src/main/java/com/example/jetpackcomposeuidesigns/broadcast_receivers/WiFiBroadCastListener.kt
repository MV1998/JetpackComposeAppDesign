package com.example.jetpackcomposeuidesigns.broadcast_receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class WiFiBroadCastListener : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(WiFiBroadCastListener::class.simpleName, "onReceive: ")
        intent?.let { _ ->
            intent.action?.let {
                Log.d(WiFiBroadCastListener::class.simpleName, "onReceive: $it")
                if (it == "android.intent.action.AIRPLANE_MODE") {
                    Log.d(WiFiBroadCastListener::class.simpleName, "onReceive: ")
                }
            }
        }
    }
}