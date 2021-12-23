package com.example.notes.ui.presentation.notes.list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.example.notes.ui.presentation.notes.list.NotesScreenViewModel
import com.example.notes.ui.theme.TOP_APP_BAR_HEIGHT
import com.example.notes.ui.theme.topAppBarBackgroundColor
import com.example.notes.ui.theme.topAppBarContentColor
import com.example.notes.util.SearchAppBarState

@Composable
fun SearchAppBar(
    notesScreenViewModel: NotesScreenViewModel,
    searchAppBarState: SearchAppBarState,
    searchText: String
) {

    when (searchAppBarState) {

        SearchAppBarState.CLOSED -> {
            AppBar(onSearchClicked = {
                notesScreenViewModel.searchAppBarState.value = SearchAppBarState.OPENED
            })

        }

        SearchAppBarState.OPENED -> {

            SearchBar(
                searchText = searchText,
                onValueChanged = {
                    notesScreenViewModel.searchTextState.value = it
                    notesScreenViewModel.getSearchedTasks(it)
                },
                onSearchClicked = {
                    notesScreenViewModel.getSearchedTasks(it)
                },
                closeIconClicked = {
                    notesScreenViewModel.searchAppBarState.value = SearchAppBarState.CLOSED
                }
            )
        }

        SearchAppBarState.TRIGGERED -> {
            SearchBar(
                searchText = searchText,
                onValueChanged = {
                    notesScreenViewModel.searchTextState.value = it
                    notesScreenViewModel.getSearchedTasks(it)
                },
                onSearchClicked = {
                    notesScreenViewModel.getSearchedTasks(it)
                },
                closeIconClicked = {
                    notesScreenViewModel.searchAppBarState.value = SearchAppBarState.CLOSED
                }
            )
        }


    }

}

@Composable
fun AppBar(
    onSearchClicked: () -> Unit,
) {

    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            SearchIcon(searchClicked = onSearchClicked)
        }
    )
}

@Composable
fun SearchIcon(
    searchClicked: () -> Unit
) {
    IconButton(onClick = {
        searchClicked()
    }) {

        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "searchIcon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SearchBar(
    searchText: String,
    onValueChanged: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    closeIconClicked: () -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                TOP_APP_BAR_HEIGHT
            ),
        color = MaterialTheme.colors.topAppBarBackgroundColor,
        elevation = AppBarDefaults.TopAppBarElevation
    ) {

        TextField(
            value = searchText,
            onValueChange = {
                onValueChanged(it)
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = "Search here...",
                    color = Color.White
                )
            },
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.disabled),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search_Icon",
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (searchText.isNotEmpty()) {
                            onValueChanged("")
                        } else {
                            closeIconClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Close_Icon",
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(

                onSearch = {
                    onSearchClicked(searchText)
                }
            )

        )

    }
}

@Preview
@Composable
fun AppBarPreview() {

    AppBar(onSearchClicked = {})
}

@Preview
@Composable
fun SearchPreview() {
    SearchBar(
        searchText = "",
        onValueChanged = {},
        onSearchClicked = {}) {

    }
}

