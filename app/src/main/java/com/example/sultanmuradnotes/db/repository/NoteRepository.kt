package com.example.sultanmuradnotes.db.repository

import kotlinx.coroutines.flow.Flow
import com.example.sultanmuradnotes.db.dao.NoteDao
import com.example.sultanmuradnotes.db.domain.NoteEntity

class NoteRepository(
    private val noteDao: NoteDao
) {

     fun getAll(): Flow<List<NoteEntity>> = noteDao.getAll()

     fun getById(id: Long?): Flow<NoteEntity> = noteDao.getById(id)

     suspend fun insert(noteEntity: NoteEntity) = noteDao.createNote(noteEntity = noteEntity)

     suspend fun update(noteEntity: NoteEntity) = noteDao.update(noteEntity = noteEntity)

     suspend fun delete(noteEntity: NoteEntity) = noteDao.delete(noteEntity = noteEntity)

     suspend fun deleteAll() = noteDao.deleteAllNotes()
}