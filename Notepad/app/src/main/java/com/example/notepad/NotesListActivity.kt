package com.example.notepad

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_notes_list.*

class NotesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        val sharedPref = getSharedPreferences("database", Context.MODE_PRIVATE)
        val note = sharedPref.getString("note", "").toString()
        editTextNote.text.append(note)

        buttonAddNote.setOnClickListener {
            sharedPref.edit().apply {
                putString("note", editTextNote.text.toString())
            }.apply()
        }

        //notesListView.addView()
    }

}
