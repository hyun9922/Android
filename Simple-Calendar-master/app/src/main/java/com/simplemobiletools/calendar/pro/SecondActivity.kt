package com.simplemobiletools.calendar.pro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("hh","hh")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

     val myText : TextView = findViewById(R.id.button)
        myText.text = add_barchart.toString()

     val intentPie = Intent(this, ChartPieActivity::class.java)
     val intentBar =  Intent(this, ChartBarActivity::class.java)
     button_bar.setOnClickListener {
         startActivity(intentPie)
         Log.e("hh","hh")
     }
     button_pie.setOnClickListener {
         startActivity(intentBar)
     }

    }



}
