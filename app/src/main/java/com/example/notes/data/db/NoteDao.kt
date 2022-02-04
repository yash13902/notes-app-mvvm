package com.example.notes.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.data.db.entities.NoteItem

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: NoteItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: NoteItem)

    @Delete
    suspend fun delete(item: NoteItem)

    @Query("SELECT * FROM note_item")
    fun getAllNotes(): LiveData<List<NoteItem>>
}