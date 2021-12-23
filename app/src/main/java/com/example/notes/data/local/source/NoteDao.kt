package com.example.notes.data.local.source

import androidx.room.*
import com.example.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE id=:noteId")
    fun getNoteById(noteId: Int): Flow<Note>

    @Query("Select * From Note Where title Like '%' || :searchQuery || '%'")
    fun getSearchList(searchQuery: String): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}