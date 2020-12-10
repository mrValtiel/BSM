package com.example.notepad

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CreatePasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password)

        val sharedPref = getSharedPreferences("database", Context.MODE_PRIVATE)
        val pass1 = findViewById<EditText>(R.id.pass1)
        val pass1Text = pass1.text.toString()
        val pass2 = findViewById<EditText>(R.id.pass2)
        val pass2Text = pass2.text.toString()
        val btn = findViewById<Button>(R.id.submitPasswordButton)

        btn.setOnClickListener {
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
            if (pass1Text == "" || pass2Text == "") {
                //any of the two fields is empty
                Toast.makeText(this, "Both fields must be filled", Toast.LENGTH_SHORT).show()
            } else if (pass1Text == pass2Text) {
                //passwords match
                sharedPref.edit().apply {
                    putString("password", pass1Text)
                }.apply()
                Toast.makeText(this, "Password set", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.activity_main)
            } else {
                //passwords don't match
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
            }
        }
    }

}