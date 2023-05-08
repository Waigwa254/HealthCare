package com.example.health_care

import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class CardioDocActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio_doc)

        val list_view: ListView =findViewById(R.id.list_dentist)

        val list= mutableListOf<model>()
        list.add(model("DR.Mary", "Hospital Address:675667                                              EXP:5yrs              Mobilie:07476363666      CONS.FEE=500", R.drawable.france))
        list.add(model("DR.Kelly", "Hospital Address:3637889                                              EXP:3yrs              Mobilie:07476467848      CONS.FEE=300", R.drawable.france))
        list.add(model("DR.Denzel", "Hospital Address:57678                                             EXP:6yrs              Mobilie:07645653767      CONS.FEE=600", R.drawable.peter))
        list.add(model("DR.John", "Hospital Address:690989                                             EXP:8yrs              Mobilie:07388973478      CONS.FEE=800", R.drawable.tess))
        list.add(model("DR.Jane", "Hospital Address:980890                                              EXP:4yrs              Mobilie:07368497237      CONS.FEE=400", R.drawable.jane))
        list.add(model("DR.Kihui", "Hospital Address:6343544                                             EXP:2yrs              Mobilie:07467678348      CONS.FEE=200", R.drawable.james))
        list.add(model("DR.Mary", "Hospital Address:675667                                              EXP:5yrs              Mobilie:07476363666      CONS.FEE=500", R.drawable.france))
        list.add(model("DR.Kelly", "Hospital Address:3637889                                              EXP:3yrs              Mobilie:07476467848      CONS.FEE=300", R.drawable.france))
        list.add(model("DR.Denzel", "Hospital Address:57678                                             EXP:6yrs              Mobilie:07645653767      CONS.FEE=600", R.drawable.peter))
        list.add(model("DR.John", "Hospital Address:690989                                             EXP:8yrs              Mobilie:07388973478      CONS.FEE=800", R.drawable.tess))
        list.add(model("DR.Jane", "Hospital Address:980890                                              EXP:4yrs              Mobilie:07368497237      CONS.FEE=400", R.drawable.jane))
        list.add(model("DR.Kihui", "Hospital Address:6343544                                             EXP:2yrs              Mobilie:07467678348      CONS.FEE=200", R.drawable.james))



        list_view.adapter=MyAdapter(this,R.layout.row,list)

        list_view.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->

            val selecteditem=parent.getItemAtPosition(position) as model

                        val click=Intent(this,BookAppointment::class.java).apply {
                            putExtra("selecteditem", selecteditem.Description)
                        }
                        startActivity(click)
                        Toast.makeText(this,"appointment clicked", Toast.LENGTH_SHORT).show()}



            }

        }
