package com.example.notes.ui.presentation.notes.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.notes.domain.model.Note
import com.example.notes.ui.theme.NoteTheme


@ExperimentalMaterialApi
@Composable
fun ListViewItem(
    note: Note,
    onClick: () -> Unit,
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .background(color = NoteTheme.colors.primary)
        .shadow(4.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick) {

        Column(modifier = Modifier
            .padding(8.dp)) {

            Text(text = note.title,
                style = MaterialTheme.typography.h1,
                color = NoteTheme.colors.title
            )
            Text(text = note.content,
                style = MaterialTheme.typography.h2,
                color = NoteTheme.colors.content
            )
            Text(text = note.dateCreatedFormatted,
                style = MaterialTheme.typography.subtitle1,
                color = NoteTheme.colors.content
            )
        }
    }
}

@Composable
fun GridViewItem() {

}