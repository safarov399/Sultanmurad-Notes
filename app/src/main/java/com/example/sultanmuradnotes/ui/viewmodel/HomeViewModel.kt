package com.example.sultanmuradnotes.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.sultanmuradnotes.db.domain.Note
import com.example.sultanmuradnotes.db.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject




@HiltViewModel
class HomeViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    private val _selectedNoteState: MutableState<Note?> = mutableStateOf(null)

     val selectedNoteState: State<Note?>
        get() = _selectedNoteState

     val noteListFlow: Flow<List<Note>> = noteRepository.getAll()

     fun getById(id: Long?): Flow<Note> {
        return noteRepository.getById(id)
    }
     fun addOrUpdateNote(note: Note) {
        ioScope.launch {
            if (note.id == null) {
                noteRepository.insert(note = note)
            } else {
                noteRepository.update(note = note)
            }
        }
    }

     fun deleteNote(note: Note) {
        ioScope.launch {
            noteRepository.delete(note = note)
        }
    }

     fun deleteAllNotes() {
        ioScope.launch {
            noteRepository.deleteAll()
        }
    }

     fun selectNote(note: Note) {
        _selectedNoteState.value = note
    }

     fun resetSelectedNote() {
        _selectedNoteState.value = null
    }


}
