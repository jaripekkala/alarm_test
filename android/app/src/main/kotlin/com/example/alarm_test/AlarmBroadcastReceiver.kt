package com.example.alarm_test

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        Log.d("AlarmBroadcastReceiver", "onReceive")

        val icon = context.resources.getIdentifier("@mipmap/ic_launcher", "drawable", context.packageName)
        val channel = NotificationChannel("test", "test", NotificationManager.IMPORTANCE_HIGH)
        val notification = Notification.Builder(context, channel.id)
                .setSmallIcon(icon)
                .setContentTitle("foo")
                .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
        manager.notify(1, notification)
    }
}