package com.example.sultanmuradnotes.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.sultanmuradnotes.db.domain.NoteEntity
import com.example.sultanmuradnotes.db.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


interface HomeViewModelAbstract {
    val noteEntityListFlow: Flow<List<NoteEntity>>
    fun getById(id: Long?): Flow<NoteEntity>
    fun addOrUpdateNote(noteEntity: NoteEntity)
    fun deleteNote(noteEntity: NoteEntity)
    fun deleteAll()
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel(),
    HomeViewModelAbstract {
    private val ioScope = CoroutineScope(Dispatchers.IO)

//    private val _selectedNoteStateEntity: MutableState<NoteEntity?> = mutableStateOf(null)

//     val selectedNoteStateEntity: State<NoteEntity?>
//        get() = _selectedNoteStateEntity

     override val noteEntityListFlow: Flow<List<NoteEntity>> = noteRepository.getAll()

     override fun getById(id: Long?): Flow<NoteEntity> {
        return noteRepository.getById(id)
    }
     override fun addOrUpdateNote(noteEntity: NoteEntity) {
        ioScope.launch {
            if (noteEntity.id == null) {
                noteRepository.insert(noteEntity = noteEntity)
            } else {
                noteRepository.update(noteEntity = noteEntity)
            }
        }
    }

     override fun deleteNote(noteEntity: NoteEntity) {
        ioScope.launch {
            noteRepository.delete(noteEntity = noteEntity)
        }
    }

    override fun deleteAll() {
        ioScope.launch {
            noteRepository.deleteAll()

        }

    }

//     fun deleteAllNotes() {
//        ioScope.launch {
//            noteRepository.deleteAll()
//        }
//    }

//     fun selectNote(noteEntity: NoteEntity) {
//        _selectedNoteStateEntity.value = noteEntity
//    }

//     fun resetSelectedNote() {
//        _selectedNoteStateEntity.value = null
//    }


}
