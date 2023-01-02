package com.swancompany.journal.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "noteModel")
data class NoteModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title:String,
    var notes:String
)