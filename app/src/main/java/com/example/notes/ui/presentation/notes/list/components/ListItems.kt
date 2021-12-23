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
import com.example.notes.ui.theme.taskItemBackgroundColor
import com.example.notes.ui.theme.taskItemTextColor


@ExperimentalMaterialApi
@Composable
fun ListViewItem(
    note: Note,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.taskItemBackgroundColor)
            .shadow(4.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {

            Text(
                text = note.title,
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.taskItemTextColor
            )
            Text(
                text = note.content,
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.taskItemTextColor
            )
            Text(
                text = note.dateCreatedFormatted,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.taskItemTextColor
            )
        }
    }
}

@Composable
fun GridViewItem() {

}