package com.example.appquanlythoigian

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

@RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
fun sendNotification(context: Context, title: String, message: String) {
    val channelId = "timer_channel"
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            "Timer Notifications",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)
    }

    val notification = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_launcher_foreground) // đổi icon theo project bạn
        .setContentTitle(title)
        .setContentText(message)
        .setAutoCancel(true)
        .build()

    NotificationManagerCompat.from(context).notify(1, notification)
}
