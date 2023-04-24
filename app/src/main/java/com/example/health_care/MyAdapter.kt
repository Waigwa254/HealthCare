package com.example.health_care

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.ColorSpace.Model
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var mctx:Context,var resources:Int,var items:List<model>):ArrayAdapter<model> (mctx,resources,items){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater=LayoutInflater.from(mctx)
        val view:View=layoutInflater.inflate(resources,null)



        val image_View:ImageView=view.findViewById(R.id.imageView)
        val txt_tittle:TextView=view.findViewById(R.id.txt_tittle)
        val txt_description:TextView=view.findViewById(R.id.txt_Description)


        var  myitem:model=items[position]
        image_View.setImageDrawable(mctx.resources.getDrawable(myitem.img))
        txt_tittle.text=myitem.title
        txt_description.text=myitem.Description

        return view


    }
}