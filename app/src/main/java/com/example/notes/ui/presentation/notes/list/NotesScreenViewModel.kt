package com.example.notes.ui.presentation.notes.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.local.source.NoteDao
import com.example.notes.domain.model.Note
import com.example.notes.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NotesScreenViewModel @Inject constructor(
    val dao: NoteDao
) : ViewModel() {

    private val _allTasks = MutableStateFlow<List<Note>>(emptyList())
    val allTasks: StateFlow<List<Note>> = _allTasks

    private val _searchTasks = MutableStateFlow<List<Note>>(emptyList())
    val searchTasks: StateFlow<List<Note>> = _searchTasks

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")

    init {

        getAllTasks()
    }

    private fun getAllTasks() {
        viewModelScope.launch {
            dao.getNotes().collect {
                _allTasks.value = it
            }
        }
    }

    fun getSearchedTasks(searchQuery: String) {
        viewModelScope.launch {
            dao.getSearchList(searchQuery).collect {
                _searchTasks.value = it
            }
        }

        searchAppBarState.value = SearchAppBarState.TRIGGERED
    }
}