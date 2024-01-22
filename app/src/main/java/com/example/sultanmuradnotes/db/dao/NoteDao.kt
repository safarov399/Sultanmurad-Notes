package com.example.sultanmuradnotes.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.sultanmuradnotes.db.domain.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getAll(): Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes WHERE id IN (:id)")
    fun getById(id: Long?): Flow<NoteEntity>



    @Update
    suspend fun update(noteEntity: NoteEntity)

    @Delete
    suspend fun delete(noteEntity: NoteEntity)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM notes WHERE content like :search")
    fun searchNotes(search: String): Flow<List<NoteEntity>>
}