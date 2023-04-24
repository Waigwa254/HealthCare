package com.example.health_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class activity_signup : AppCompatActivity() {
    lateinit var emaill:EditText
    lateinit var passwoord:EditText
    lateinit var cf_password:EditText
    lateinit var signup:Button
    lateinit var redirectlogin:TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

       emaill=findViewById(R.id.edt_emaill)
        passwoord=findViewById(R.id.newpassword)
        cf_password=findViewById(R.id.btnreset)
        signup=findViewById(R.id.btnsaveps)
      redirectlogin=findViewById(R.id.tvRedirectLogin)

        auth = FirebaseAuth.getInstance()




        signup.setOnClickListener {
            SignUpUser()

        }
        redirectlogin.setOnClickListener {
            val intent= Intent(this,LLoginActivity::class.java)
            startActivity(intent)
        }


    }
    private fun SignUpUser(){
        val email=emaill.text.toString()
        val pass=passwoord.text.toString()
        val confirmpass= cf_password.text.toString()
        if (email.isBlank() || pass.isBlank() || confirmpass.isBlank()){
            Toast.makeText(this,"Please Email and password can`t be blank", Toast.LENGTH_LONG).show()
            return
        }  else if (pass != confirmpass){
            Toast.makeText(this,"Password do not match", Toast.LENGTH_LONG).show()
            return

        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Signed successfully", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Failed to create", Toast.LENGTH_LONG).show()
            }

        }
    }
}