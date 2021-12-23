package com.example.notes.domain.navigation

sealed class Screen(val route: String) {

    object AddEdit : Screen("add_edit_notes")

    object Notes : Screen("notes")
}
