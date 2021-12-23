package com.example.notes.ui.presentation.notes.add_edit.components

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.local.source.NoteDao
import com.example.notes.domain.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val dao: NoteDao
) : ViewModel() {


    val title: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")

  /*  private var _title: MutableStateFlow<String> = MutableStateFlow("")
    var title: StateFlow<String> = _title

    private var _description: MutableStateFlow<String> = MutableStateFlow("")
    var description : StateFlow<String> = _description*/

    private val _selectedNote: MutableStateFlow<Note?> = MutableStateFlow(null)
    val selectedNote: StateFlow<Note?> = _selectedNote


    fun getNoteById(id: Int) {

        if (id != -1) {
            viewModelScope.launch {
                dao.getNoteById(id).collect {
                    _selectedNote.value = it
                }
            }
        }
    }


    fun insertNote(note: Note) {
        viewModelScope.launch {
            dao.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            dao.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            dao.deleteNote(note)
        }
    }

}