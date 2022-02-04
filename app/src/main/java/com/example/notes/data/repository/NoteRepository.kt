package com.example.notes.data.repository

import android.content.Context
import com.example.notes.data.db.NoteDatabase
import com.example.notes.data.db.entities.NoteItem

class NoteRepository(
    context: Context,
) {
    private val databaseDao = NoteDatabase.invoke(context).getNoteDao()

    suspend fun insert(item: NoteItem) = databaseDao.insert(item)
    suspend fun delete(item: NoteItem) = databaseDao.delete(item)
    suspend fun update(noteItem: NoteItem) = databaseDao.update(noteItem)
    fun getAllNotes() = databaseDao.getAllNotes()
}