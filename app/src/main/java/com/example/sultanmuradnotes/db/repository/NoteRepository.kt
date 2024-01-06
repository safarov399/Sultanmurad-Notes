package com.example.sultanmuradnotes.db.repository

import kotlinx.coroutines.flow.Flow
import com.example.sultanmuradnotes.db.dao.NoteDao
import com.example.sultanmuradnotes.db.domain.Note

class NoteRepository(
    private val noteDao: NoteDao
) {

     fun getAll(): Flow<List<Note>> = noteDao.getAll()

     fun getById(id: Long?): Note = noteDao.getById(id)

     suspend fun insert(note: Note) = noteDao.createNote(note = note)

     suspend fun update(note: Note) = noteDao.update(note = note)

     suspend fun delete(note: Note) = noteDao.delete(note = note)

     suspend fun deleteAll() = noteDao.deleteAllNotes()
}