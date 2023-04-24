package com.example.health_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    lateinit var labtest:CardView
    lateinit var buymedicine:CardView
    lateinit var finddoc:CardView
    lateinit var h_Articles:CardView
    lateinit var orderdetails:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        labtest=findViewById(R.id.labtest)
        buymedicine=findViewById(R.id.buymedicine)
        finddoc=findViewById(R.id.finddoc)
        h_Articles=findViewById(R.id.h_articles)
        orderdetails=findViewById(R.id.orderdetails)


        labtest.setOnClickListener {
            val labtest=Intent(this,MainActivity::class.java)
            startActivity(labtest)

        }


            finddoc.setOnClickListener {
                val finddoc=Intent(this,finddocActivity::class.java)
                startActivity(finddoc)
                Toast.makeText(this,"Find-doc clicked", Toast.LENGTH_SHORT).show()

            }
         buymedicine.setOnClickListener {
            val buyme=Intent(this,Forgetpassword::class.java)
            startActivity(buyme)
            Toast.makeText(this,"buy-medicine clicked", Toast.LENGTH_SHORT).show()

        }
        h_Articles.setOnClickListener {
            val articles=Intent(this,Forgetpassword::class.java)
            startActivity(articles)
            Toast.makeText(this,"health-articles clicked", Toast.LENGTH_SHORT).show()

        }
        orderdetails.setOnClickListener {
            val details=Intent(this,Forgetpassword::class.java)
            startActivity(details)
            Toast.makeText(this,"orderdetails clicked", Toast.LENGTH_SHORT).show()

        }


    }
}