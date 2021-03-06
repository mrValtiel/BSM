package com.example.notepad

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enter_password.*

class EnterPasswordActivity : AppCompatActivity() {

    val sharedPref = getSharedPreferences("database", Context.MODE_PRIVATE)
    val password = sharedPref.getString("password", "").toString()
    val pass = findViewById<EditText>(R.id.pass)
    var passText = pass.text.toString()
    val button = findViewById<Button>(R.id.loginButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_password)

        loginButton.setOnClickListener {
            if (passText == password) {
                //correct password entered
                setContentView(R.layout.activity_notes_list)
            } else {
                Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show()
            }
        }

        changePasswordButton.setOnClickListener {
            if (passText == password) {
                //correct password entered
                setContentView(R.layout.activity_create_password)
            } else {
                Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}