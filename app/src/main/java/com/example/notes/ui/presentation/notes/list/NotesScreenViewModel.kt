package com.example.notes.ui.presentation.notes.list

import androidx.lifecycle.ViewModel
import com.example.notes.data.local.source.NoteDao
import com.example.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

class NotesScreenViewModel(
    private val dao: NoteDao,
) : ViewModel() {


    fun getNote(): Flow<List<Note>> {
        return dao.getNotes()
    }
}