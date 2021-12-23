package com.example.notes.ui.presentation.notes.add_edit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.notes.domain.model.Note
import com.example.notes.domain.navigation.Screen
import com.example.notes.ui.theme.*

@Composable
fun AddEditScreen(
    navController: NavController,
    id: Int = -1,
    viewModel: AddEditViewModel
) {

    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }


    var notes = viewModel.selectedNote.collectAsState().value

    if (id == -1) {
        notes = null
    } else {
        title = notes?.title ?: ""
        description = notes?.content ?: ""
    }

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        scaffoldState = scaffoldState,
        topBar = {
            if (notes == null) {
                NewTopAppBar(navigateListScreen = {
                    navController.navigate(Screen.Notes.route)
                },
                    saveClicked = {
                        val noteNew =
                            Note(
                                title = title,
                                content = description
                            )
                        viewModel.insertNote(noteNew)
                        navController.navigate(Screen.Notes.route)
                    })
            } else {
                ExistingAppBar(
                    navigateListScreen = { navController.navigate(Screen.Notes.route) },
                    updateClicked = {
                        viewModel.updateNote(
                            Note(
                                title = title,
                                content = description
                            )
                        )
                        navController.navigate(Screen.Notes.route)
                    },
                    deleteClicked = { viewModel.deleteNote(notes)
                        navController.navigate(Screen.Notes.route) },
                    name = title
                )
            }
        },
        content = {
            AddEditContent(
                title = title,
                notes = notes,
                description = description,
                onTitleChange = {
                    title = it
                },
                onDescriptionChange = {
                    description = it
                })
        }
    )
}

@Composable
fun NewTopAppBar(
    navigateListScreen: () -> Unit,
    saveClicked: () -> Unit
) {

    TopAppBar(modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = "Add Task",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        navigationIcon = { BackIcon(backClicked = navigateListScreen) },

        actions = {
            TicIcon(ticClicked = saveClicked)
        }
    )

}

@Composable
fun ExistingAppBar(
    navigateListScreen: () -> Unit,
    updateClicked: () -> Unit,
    deleteClicked: () -> Unit,
    name: String
) {

    TopAppBar(modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = name,
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        navigationIcon = { CloseIcon(closeClicked = navigateListScreen) },

        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,

        actions = {
            DeleteIcon(deleteClicked = deleteClicked)
            TicIcon(ticClicked = updateClicked)
        }


    )
}

@Composable
fun BackIcon(
    backClicked: () -> Unit
) {

    IconButton(onClick = {
        backClicked()
    }) {

        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "back_icon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun CloseIcon(
    closeClicked: () -> Unit
) {
    IconButton(onClick = {
        closeClicked()
    }) {

        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "close_icon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun TicIcon(
    ticClicked: () -> Unit
) {
    IconButton(onClick = {
        ticClicked()
    }) {

        Icon(
            contentDescription = "add_icon",
            imageVector = Icons.Filled.Check,
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun DeleteIcon(
    deleteClicked: () -> Unit
) {
    IconButton(onClick = {
        deleteClicked()
    }) {

        Icon(
            contentDescription = "delete_icon",
            imageVector = Icons.Filled.Delete,
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun AddEditContent(
    title: String,
    notes: Note?,
    description: String,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.taskItemBackgroundColor)
            .padding(all = LARGE_PADDING)
    ) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.taskItemBackgroundColor),
            value = notes?.title ?: title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = "Title") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )

        Divider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color = MaterialTheme.colors.background
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.taskItemBackgroundColor),
            value = notes?.content ?: description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = "Descriptions") },
            textStyle = MaterialTheme.typography.body1
        )

    }


}

@Preview
@Composable
fun NewUser(
) {
    NewTopAppBar(navigateListScreen = { }) {

    }
}


@Preview
@Composable
fun ExistingUser() {

    ExistingAppBar(
        navigateListScreen = { /*TODO*/ },
        updateClicked = { /*TODO*/ },
        deleteClicked = { /*TODO*/ },
        name = "New Title"
    )
}

