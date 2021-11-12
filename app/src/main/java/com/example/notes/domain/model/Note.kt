package com.example.notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity
data class Note(
    val title: String,
    val content: String,
    val dateCreated: Long = System.currentTimeMillis(),
    @PrimaryKey
    val id : Int? = null
){
    val dateCreatedFormatted: String
        get() = DateFormat.getDateTimeInstance().format(dateCreated)
}
