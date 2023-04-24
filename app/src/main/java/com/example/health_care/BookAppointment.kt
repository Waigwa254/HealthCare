package com.example.health_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class BookAppointment : AppCompatActivity() {
    lateinit var bookapp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        bookapp=findViewById(R.id.bookappp)


        bookapp.setOnClickListener {
            val bookapp=Intent(this,Notification::class.java)
            startActivity(bookapp)
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT ).show()
        }
    }
}