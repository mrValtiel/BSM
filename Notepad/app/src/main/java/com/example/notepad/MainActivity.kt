package com.example.notepad

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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