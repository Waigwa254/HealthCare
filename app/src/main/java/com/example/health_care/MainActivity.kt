package com.example.health_care


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

    lateinit var Register:CardView
    lateinit var Login:CardView
    lateinit var setting:CardView
    lateinit var logout:CardView
    lateinit var forgotpsword:CardView
    lateinit var widges:CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Register=findViewById(R.id.cardRegister)
        Login=findViewById(R.id.cardlogin)
        setting=findViewById(R.id.cardsettings)
        logout=findViewById(R.id.cardlogout)
        forgotpsword=findViewById(R.id.cardforgotpassword)
        widges=findViewById(R.id.cardwidges)

        Register.setOnClickListener {
            val register=Intent(this,activity_signup::class.java)
            startActivity(register)
            Toast.makeText(this,"register clicked", Toast.LENGTH_SHORT).show()

        }
        Login.setOnClickListener {
            val login=Intent(this,LLoginActivity::class.java)
            startActivity(login)
            Toast.makeText(this,"login clicked", Toast.LENGTH_SHORT).show()

        }
        forgotpsword.setOnClickListener {
            val forgotpsword=Intent(this,Forgetpassword::class.java)
            startActivity(forgotpsword)
            Toast.makeText(this,"forgot-password clicked", Toast.LENGTH_SHORT).show()

        }




    }
}