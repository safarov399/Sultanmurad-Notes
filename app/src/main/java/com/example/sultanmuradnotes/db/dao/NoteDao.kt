package com.example.sultanmuradnotes.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.sultanmuradnotes.db.domain.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAll(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun createNote(note: Note)

    @Query("SELECT * FROM notes WHERE id IN (:id)")
    fun getById(id: Long?): Note

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM notes WHERE content like :search")
    fun searchNotes(search: String): Flow<List<Note>>
}