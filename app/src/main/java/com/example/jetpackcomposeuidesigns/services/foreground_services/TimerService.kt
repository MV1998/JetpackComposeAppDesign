package com.example.jetpackcomposeuidesigns.services.foreground_services

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.jetpackcomposeuidesigns.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class TimerService : Service() {

    private lateinit var manager : NotificationManagerCompat
    private var seconds = 0
    private var isServiceStarted = false

    override fun onCreate() {
        super.onCreate()
        // create notification channel
        manager = NotificationManagerCompat.from(this)
        startForeground(1, createNotification("Timer: $seconds seconds"))
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isServiceStarted = true
        updateNotification()
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun updateNotification() {
        CoroutineScope(Dispatchers.Main).launch {
            generateSeconds().collect {
                if (ActivityCompat.checkSelfPermission(
                        this@TimerService,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    manager.notify(1, createNotification("Timer: $seconds seconds"))
                }
            }
        }
    }

    private fun generateSeconds(): Flow<Int> {
        return flow {
            while (isServiceStarted) {
                seconds++
                delay(1000)
                emit(seconds)
            }
        }
    }

    private fun createNotification(content : String) : Notification {
        val channelId = "timer_channel_id"
        return NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.veg4) // Your notification icon
            .setContentTitle("Timer")
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setOngoing(true) // Prevent user from swiping away the notification
            .build()
    }

    override fun onDestroy() {
        super.onDestroy()
        isServiceStarted = false
        manager.cancel(1)
    }
}