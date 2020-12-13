package com.example.notepad

import android.content.Context
import android.os.Bundle
import android.view.View.*
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_create_password.*

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

        findViewById<Button>(R.id.submitPasswordButton).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        submitPasswordButton.setOnClickListener {
            Toast.makeText(this@CreatePasswordActivity, "Click", Toast.LENGTH_SHORT).show()
            if (pass1Text == "" || pass2Text == "") {
                //any of the two fields is empty
                Toast.makeText(this@CreatePasswordActivity, "Both fields must be filled", Toast.LENGTH_SHORT).show()
            } else if (pass1Text == pass2Text) {
                //passwords match
                sharedPref.edit().apply {
                    putString("password", pass1Text)
                }.apply()
                Toast.makeText(this@CreatePasswordActivity, "Password set", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.activity_notes_list)
            } else {
                //passwords don't match
                Toast.makeText(this@CreatePasswordActivity, "Passwords don't match", Toast.LENGTH_SHORT).show()
            }
        }

    }

    /*
    fun clickPasswordButton(view: View) {
        Toast.makeText(this@CreatePasswordActivity, "Click", Toast.LENGTH_SHORT).show()
    }

     */

}