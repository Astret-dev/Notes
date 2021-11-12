package com.example.notes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.view.WindowCompat
import com.example.notes.data.local.source.NoteDatabase
import com.example.notes.ui.presentation.notes.list.components.SearchBar
import com.example.notes.ui.theme.NotesTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = NoteDatabase.createDatabase(this).noteDao()

//        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            NotesTheme {
                SearchBar(onSearch = {

                })
            }
        }
    }
}






