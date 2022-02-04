package com.example.notes.other

import com.example.notes.data.db.entities.NoteItem

interface NoteItemClickListener {

    fun onItemClick(notesItem: NoteItem, action: ClickAction)
}

enum class ClickAction{
    DELETE,
    OPEN
}

