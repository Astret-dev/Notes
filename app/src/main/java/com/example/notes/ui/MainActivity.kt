package com.example.notes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.rememberNavController
import com.example.notes.domain.navigation.SetUpNavigation
import com.example.notes.ui.presentation.notes.add_edit.components.AddEditViewModel
import com.example.notes.ui.presentation.notes.list.NotesScreenViewModel
import com.example.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity() : ComponentActivity() {


    private val notesViewModel: NotesScreenViewModel by viewModels()
    private val addEditViewModel: AddEditViewModel by viewModels()


    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NotesTheme {
                val navController = rememberNavController()
                /*SetUpNavigation(
                    navController = navController,
                    addEditViewModel = addEditViewModel,
                    notesScreenViewModel = notesViewModel
                )
*/

                //map - sort the list
                // map with index - sort list & op using index
                // flatMap - combine lists.


            }

        }

    }

}

data class Persons(
    val name: String,
    val age: Int
)






