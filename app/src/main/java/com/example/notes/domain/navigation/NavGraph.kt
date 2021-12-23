package com.example.notes.domain.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.notes.domain.model.Note
import com.example.notes.ui.presentation.notes.add_edit.components.AddEditScreen
import com.example.notes.ui.presentation.notes.add_edit.components.AddEditViewModel
import com.example.notes.ui.presentation.notes.list.NotesDetail
import com.example.notes.ui.presentation.notes.list.NotesScreenViewModel
import com.example.notes.util.Constants.NOTES_SCREEN

@ExperimentalMaterialApi
@Composable
fun SetUpNavigation(
    navController: NavHostController,
    addEditViewModel: AddEditViewModel,
    notesScreenViewModel: NotesScreenViewModel
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Notes.route
    ) {

        composable(route = Screen.Notes.route) {
            NotesDetail(navController, viewModel = notesScreenViewModel)
        }

        composable(
            route = "add_edit_notes/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                    defaultValue = -1
                    nullable = false
                }
            )
        ) {
            val id = it.arguments?.getInt("id") ?: -1

            if (id != -1) {
                addEditViewModel.getNoteById(id)
            }

            AddEditScreen(
                navController,
                id = id,
                viewModel = addEditViewModel
            )
        }
    }
}