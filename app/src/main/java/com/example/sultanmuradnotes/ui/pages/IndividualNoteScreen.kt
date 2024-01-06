package com.example.sultanmuradnotes.ui.pages

import android.app.Activity
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sultanmuradnotes.db.domain.Note
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndividualNoteScreen(id: Long?, homeViewModel: HomeViewModel) {
    val activity = (LocalContext.current as? Activity)
    var note: Note = homeViewModel.getById(id)
    var text by remember {mutableStateOf (note.content)}
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = { activity?.finish() },
                        content = {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = ""
                            )
                        }
                    )
                    Button(onClick = {
                        note.content = text
                        if(note.id == 0.toLong()) {
                            note.id = null
                        }
                        homeViewModel.addOrUpdateNote(note)
                        if(note.content.isBlank()) {
                            homeViewModel.deleteNote(note)
                        }
                    }) {
                        Text("Save")
                    }
                },

                title = {},
                modifier = Modifier.padding(start = 10.dp)
            )
        }, modifier = Modifier.fillMaxSize()
    ) { it ->
        Surface(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxSize()
        ) {
            TextField(value = text, onValueChange = {
                text = it
            })
        }
    }
}



