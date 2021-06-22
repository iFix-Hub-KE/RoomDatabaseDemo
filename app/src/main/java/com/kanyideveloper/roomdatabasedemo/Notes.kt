package com.kanyideveloper.roomdatabasedemo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Notes (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val noteTitle: String? = null,
    val noteDescription: String? = null
)