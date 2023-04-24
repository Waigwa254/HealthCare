package com.example.health_care

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.health_care.databinding.ActivityMainBinding
import com.example.health_care.databinding.ActivityNotificationBinding
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar
import java.util.Date

class Notification : AppCompatActivity() {
    private lateinit var binding:ActivityNotificationBinding


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        


        super.onCreate(savedInstanceState)
        binding=ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        creatNotificationChannel()
        binding.submitButton.setOnClickListener{scheduleNotification()}
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun scheduleNotification() {
        val intent = Intent(applicationContext,Notification::class.java)
        val title =binding.titleET.text.toString()
        val message=binding.messageET.tag.toString()
        intent.putExtra(messageExtra,message)
        intent.putExtra(titleExtra,title)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            notificatioon,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )
        showAlert(time,title,message)
    }

    private fun showAlert(time: Long, title: String, message: String)
    {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)

        AlertDialog.Builder(this)
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title:" + title +
                "\nMessage:" + message +
                "\nAt:" + dateFormat.format(date)+" "+timeFormat.format(date))
            .setPositiveButton( "Okay"){ _,_->}
            .show()


    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getTime(): Long
    {
        val minute = binding.timepicker.minute
        val hour = binding.timepicker.hour
        val day = binding.datepicker.dayOfMonth
        val month = binding.datepicker.month
        val year = binding.datepicker.year


        val calendar = Calendar.getInstance()
        calendar.set(year,month, day,hour,minute)
        return calendar.timeInMillis


    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun creatNotificationChannel() {
        val name = "Notif Channel"
        val desc = "A Description of the Channel"
        val importance = NotificationManager .IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID , name , importance)
        channel.description = desc
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }
}