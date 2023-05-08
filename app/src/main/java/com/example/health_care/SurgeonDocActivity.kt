package com.example.health_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class  SurgeonDocActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surgeon_doc)

        val list_view: ListView = findViewById(R.id.list_surgeon)

        val list = mutableListOf<model>()
        list.add(model("DR.France", "Hospital Address:675667                                              EXP:5yrs              Mobilie:07476363666      CONS.FEE=500", R.drawable.peter))
        list.add(model("DR.James", "Hospital Address:3637889                                              EXP:3yrs              Mobilie:07476467848      CONS.FEE=300", R.drawable.france))
        list.add(model("DR.Augustine", "Hospital Address:57678                                             EXP:6yrs              Mobilie:07645653767      CONS.FEE=600", R.drawable.antony))
        list.add(model("DR.Peter", "Hospital Address:690989                                             EXP:8yrs              Mobilie:07388973478      CONS.FEE=800", R.drawable.james))
        list.add(model("DR.Waigwa", "Hospital Address:980890                                              EXP:4yrs              Mobilie:07368497237      CONS.FEE=400", R.drawable.peter))
        list.add(model("DR.Antony", "Hospital Address:6343544                                             EXP:2yrs              Mobilie:07467678348      CONS.FEE=200", R.drawable.liz))


        list_view.adapter = MyAdapter(this, R.layout.row, list)

        list_view.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->

            val selecteditem=parent.getItemAtPosition(position) as model

            val click= Intent(this,BookAppointment::class.java).apply {
                putExtra("selecteditem", selecteditem.Description)
            }
            startActivity(click)
            Toast.makeText(this,"appointment clicked", Toast.LENGTH_SHORT).show()}
    }
}