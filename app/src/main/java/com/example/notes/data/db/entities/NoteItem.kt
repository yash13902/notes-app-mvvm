package com.example.notes.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_item")
data class NoteItem(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "lock")
    var lock: Boolean
):Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}