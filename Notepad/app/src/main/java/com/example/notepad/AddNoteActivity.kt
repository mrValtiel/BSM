package com.example.notepad

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val database = getSharedPreferences("database", Context.MODE_PRIVATE)

        saveNoteButton.setOnClickListener {
            database.edit().apply {
                putString("savedNote", noteEditField.text.toString())
            }.apply()
        }
    }
}