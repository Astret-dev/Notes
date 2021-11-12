package com.example.notes.ui.presentation.notes.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import com.example.notes.ui.theme.Blue
import com.example.notes.ui.theme.Neutral3
import com.example.notes.ui.theme.NoteTheme

@Composable
fun SearchBar(
    hint: String = "Search...",
    onSearch: (String) -> Unit,
) {
    var searchText by remember {
        mutableStateOf("")
    }

    var isHintEnabled by remember {
        mutableStateOf(true)
    }

    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {

        Row(modifier = Modifier
            .weight(1f)
            .padding(end = 8.dp)
            .background(color = Neutral3, shape = CircleShape)
            .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Icon(imageVector = Icons.Filled.Search,
                contentDescription = "Search_Icon",
                tint = NoteTheme.colors.icons,
                modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .padding(start = 4.dp))

            BasicTextField(
                value = searchText,
                onValueChange = {
                    if (isHintEnabled) {
                        searchText = it
                        onSearch(it)
                    } else {
                        searchText = hint
                        onSearch("")
                    }

                },
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 6.dp)
                    .onFocusChanged {
                        isHintEnabled = !it.hasFocus
                    }
            )

            Icon(imageVector = Icons.Filled.Clear,
                contentDescription = "Clear_Icon",
                tint = NoteTheme.colors.icons,
                modifier = Modifier
                    .wrapContentWidth(Alignment.End)
                    .padding(end = 4.dp))
        }

        Text(text = "Cancel", style = MaterialTheme.typography.h2, color = Blue,
            modifier = Modifier
                .wrapContentWidth(Alignment.End))

    }


}