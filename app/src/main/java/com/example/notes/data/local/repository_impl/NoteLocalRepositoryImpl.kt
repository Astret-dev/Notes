package com.example.notes.data.local.repository_impl

import android.content.Context
import com.example.notes.data.local.source.NoteDao
import com.example.notes.data.local.source.NoteDatabase
import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NotesLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteLocalRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NotesLocalRepository {

    override fun getNotes(): Flow<List<Note>> {

        return dao.getNotes()
    }

    override suspend fun insertNote(note: Note) {

        dao.insertNote(note)
    }

    override suspend fun updateNote(note: Note) {

    }

    override suspend fun deleteNote(note: Note) {

    }

}