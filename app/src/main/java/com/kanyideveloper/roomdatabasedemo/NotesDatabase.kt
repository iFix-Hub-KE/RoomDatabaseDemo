package com.kanyideveloper.roomdatabasedemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notes::class])
class NotesDatabase : RoomDatabase() {
}