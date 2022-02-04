package com.example.notes.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.db.entities.NoteItem
import com.example.notes.data.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(
    application: Application,
): AndroidViewModel(application) {

    private val repository: NoteRepository = NoteRepository(application.applicationContext)

    fun insert(item: NoteItem) = viewModelScope.launch{
        repository.insert(item)
    }
    fun delete(item: NoteItem) = viewModelScope.launch {
        repository.delete(item)
    }
    fun getAllNotes() = repository.getAllNotes()

    fun update(noteItem: NoteItem) {
        viewModelScope.launch {
            repository.update(noteItem)
        }
    }
}