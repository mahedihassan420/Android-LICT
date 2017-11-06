package com.hisoft.ovi.displaycalendarevent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById(R.id.dispbut) as Button
        button.setOnClickListener { disp() }
    }

    fun disp() {
        val startTime = Calendar.getInstance()
        startTime.set(2013, 2, 13, 11, 35)
        val uri = Uri.parse("content://com.android.calendar/time/" + startTime.timeInMillis.toString())
        val intent = Intent(Intent.ACTION_VIEW, uri)
        // Use the Calendar app to view the time.
        startActivity(intent)
    }
}
