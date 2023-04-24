package com.example.health_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LLoginActivity : AppCompatActivity() {

    private lateinit var tvRedirectSignUp: TextView
    lateinit var etEmail: EditText
    private lateinit var etPass: EditText
    lateinit var btnLogin: Button
    lateinit var forgot_paswd: TextView





    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llogin)

//to hide the status bar
        //  window.decorView.systemUiVisibility = view.SYSTEM_UI_FLAG_FULLSCREEN



        // View Binding
        tvRedirectSignUp = findViewById(R.id.goto_Register)
        btnLogin = findViewById(R.id.Btn_login)
        etEmail = findViewById(R.id.input_Email)
        etPass = findViewById(R.id.input_password)
        forgot_paswd = findViewById(R.id.forgot_Paswword)



        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
        }


        tvRedirectSignUp.setOnClickListener {
//            val intent = Intent(this, Signup_page::class.java)
//            startActivity(intent)
            val sign=Intent(this,activity_signup ::class.java)
            startActivity(sign)
            // Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
            // using finish() to end the activity
            finish()
        }
        forgot_paswd.setOnClickListener {
            val pswd  =Intent(this,Forgetpassword::class.java)
            startActivity(pswd)
            finish()
        }

    }

    private fun login() {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                startActivity(Intent(this,HomeActivity::class.java).apply {  })

                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }

}