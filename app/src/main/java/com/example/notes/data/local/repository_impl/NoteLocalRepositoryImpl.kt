package com.example.notes.data.local.repository_impl

import android.content.Context
import com.example.notes.data.local.source.NoteDatabase
import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NotesLocalRepository
import kotlinx.coroutines.flow.Flow

class NoteLocalRepositoryImpl(
    private val context: Context,
) : NotesLocalRepository {

    private val dao = NoteDatabase.createDatabase(context).noteDao()

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun updateNote(note: Note) {
        return dao.updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }

}