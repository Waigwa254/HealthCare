package com.example.health_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class finddocActivity : AppCompatActivity() {
    lateinit var familyphy:CardView
    lateinit var cardio:CardView
    lateinit var dentist:CardView
    lateinit var surgeon:CardView
    lateinit var optician:CardView
    lateinit var damatologist:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finddoc)

        familyphy=findViewById(R.id.fdfamilyphysician)
        cardio=findViewById(R.id.fdcardiologist)
        dentist=findViewById(R.id.fddentist)
        surgeon=findViewById(R.id.fdSURGEON)
        optician=findViewById(R.id.fdOPTICIAN)
        damatologist=findViewById(R.id.fddamatologist)


        familyphy.setOnClickListener {
            val phy=Intent(this,MainAddapter::class.java)
            startActivity(phy)
        }

        cardio.setOnClickListener {
            val cardioo=Intent(this,CardioDocActivity::class.java)
            startActivity(cardioo)
        }
        dentist.setOnClickListener {
            val dentist=Intent(this,DentistDocActivity::class.java)
            startActivity(dentist)
        }
        surgeon.setOnClickListener {
            val surgeon=Intent(this,SurgeonDocActivity::class.java)
            startActivity(surgeon)
        }
        optician.setOnClickListener {
            val optician=Intent(this,OpticianDocActivity::class.java)
            startActivity(optician)
        }
        damatologist.setOnClickListener {
            val dama=Intent(this,DamaDocActivity::class.java)
            startActivity(dama )
        }



    }
}