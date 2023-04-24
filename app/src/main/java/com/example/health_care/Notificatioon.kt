package com.example.health_care

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

const val notificatioon=1
const val channelID="channel1"
const val titleExtra="titleExtra"
const val messageExtra="messageExtra"

class Notificatioon(val notificatioonID: Int) : BroadcastReceiver()
{
    override fun onReceive(context: Context, intent: Intent)
    {
       val notificatioon =NotificationCompat.Builder(context, channelID)
           .setSmallIcon(R.drawable.dentist)
           .setContentTitle(intent.getStringExtra(titleExtra))
           .setContentText(intent.getStringExtra(titleExtra))
           .build()

        val manager =context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
       manager.notify(notificatioonID,notificatioon)
    }
}