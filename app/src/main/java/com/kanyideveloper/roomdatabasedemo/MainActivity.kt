package com.kanyideveloper.roomdatabasedemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kanyideveloper.roomdatabasedemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var notesDatabase: NotesDatabase
    private lateinit var notesDao: NotesDao

    private val adapter by lazy { NotesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesDatabase = NotesDatabase.getInstance(applicationContext)
        notesDao = notesDatabase.notesDao

        GlobalScope.launch {

                adapter.submitList(notesDao.getAllNotes())
                binding.recyclerview.adapter = adapter

        }

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }
}