package com.oakil.notessqlite

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.oakil.notessqlite.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
   private lateinit var binding: ActivityAddNoteBinding
   private lateinit var database: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        database = NotesDatabaseHelper(this)



        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0, title, content)

            database.insertNote(note)
            finish()
            Toast.makeText(this, "notes saved" , Toast.LENGTH_SHORT).show()


        }

    }
}