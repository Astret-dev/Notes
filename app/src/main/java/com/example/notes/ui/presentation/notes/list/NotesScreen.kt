package com.example.notes.ui.presentation.notes.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.notes.domain.model.Note
import com.example.notes.ui.presentation.notes.list.components.ListViewItem
import com.example.notes.ui.presentation.notes.list.components.SearchAppBar
import com.example.notes.ui.theme.fabBackgroundColor
import com.example.notes.util.SearchAppBarState

@ExperimentalMaterialApi
@Composable
fun NotesDetail(
    navController: NavController,
    viewModel: NotesScreenViewModel
) {
    val searchAppBarState: SearchAppBarState by viewModel.searchAppBarState
    val searchTextState: String by viewModel.searchTextState

    val allNotes = viewModel.allTasks.collectAsState().value
    val searchedNotes = viewModel.searchTasks.collectAsState().value

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier.background(color = MaterialTheme.colors.background),
        scaffoldState = scaffoldState,
        topBar = {
            SearchAppBar(
                notesScreenViewModel = viewModel,
                searchAppBarState = searchAppBarState,
                searchText = searchTextState
            )
        },
        floatingActionButton = {
            ListFab(onFabClicked = {
                navController.navigate("add_edit_notes/-1")
            })
        },
        content = {

            val notes = when (searchAppBarState) {

                SearchAppBarState.TRIGGERED -> {
                    searchedNotes
                }

                SearchAppBarState.OPENED -> {
                    allNotes
                }

                SearchAppBarState.CLOSED -> {
                    allNotes
                }
            }

            ListViewDemo(navController, note = notes)
        },
        drawerBackgroundColor = MaterialTheme.colors.background
    )


}

@ExperimentalMaterialApi
@Composable
fun ListViewDemo(navController: NavController, note: List<Note>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        /*items(items = note, itemContent = {
            ListViewItem(note = it, onClick = {
                navController.navigate("add_edit_notes/${it.id}")
            })
        })*/

        items(
            items = note,
            key = { note ->
                note.id
            }
        ){

        }
    }

}


@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            "Add_btn",
            tint = Color.White
        )
    }
}