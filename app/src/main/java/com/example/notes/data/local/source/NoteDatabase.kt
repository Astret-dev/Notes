package com.example.notes.data.local.source

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.domain.model.Note
import javax.inject.Singleton

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase() : RoomDatabase(){

    abstract fun noteDao() : NoteDao

    companion object {
        private const val DATABASE_NAME = "notes_db"

        @Singleton
        fun createDatabase(context: Context): NoteDatabase {
            println("database created!")
            return Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}
