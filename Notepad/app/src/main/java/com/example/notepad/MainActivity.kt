package com.example.notepad

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val x = findViewById<TextView>(R.id.mainAppText)
        x.setOnClickListener {
            Toast.makeText(this@MainActivity, "Click!", Toast.LENGTH_SHORT).show()
        }

         */

        val sharedPref = getSharedPreferences("database", Context.MODE_PRIVATE)
        val password = sharedPref.getString("password", "").toString()
        if(password.equals("")) {
            //if there is no password
            setContentView(R.layout.activity_create_password)
        } else {
            //if password exists
            setContentView(R.layout.activity_enter_password)
        }

    }
}