package com.kanyideveloper.roomdatabasedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kanyideveloper.roomdatabasedemo.databinding.ActivityAddBinding
import kotlinx.coroutines.*

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private lateinit var notesDatabase: NotesDatabase
    private lateinit var notesDao: NotesDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesDatabase =  NotesDatabase.getInstance(applicationContext)
        notesDao = notesDatabase.notesDao

        binding.buttonAdd.setOnClickListener {
            if (binding.noteTitleTextView.text.toString().isEmpty() ||
                    binding.noteDescriptionTextView.text.toString().isEmpty()){
                return@setOnClickListener
            }else{
                CoroutineScope(Dispatchers.IO).launch {
                    val note = Notes(0, binding.noteTitleTextView.text.toString(), binding.noteDescriptionTextView.text.toString())
                    notesDao.insertNote(note)
                    startActivity(Intent(this@AddActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}