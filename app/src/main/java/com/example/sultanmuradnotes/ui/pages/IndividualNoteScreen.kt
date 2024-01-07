package com.example.sultanmuradnotes.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sultanmuradnotes.db.domain.Note
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndividualNoteScreen(id: Long?, homeViewModel: HomeViewModel, navController: NavController) {
//    val note: Note = homeViewModel.getById(id)
    val noteState by homeViewModel.getById(id).collectAsState(initial = Note())

    var text by remember { mutableStateOf(noteState.content) }
    LaunchedEffect(noteState) {
        // Update text when noteState changes
        text = noteState?.content ?: ""
    }
    var buttonEnabled by remember { mutableStateOf(true)}
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = { navController.popBackStack() },
                            content = {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = ""
                                )
                            }
                        )
                        Box(modifier = Modifier.padding(end = 10.dp)) {
                            Button(enabled = buttonEnabled,onClick = {
                                noteState.content = text
                                homeViewModel.addOrUpdateNote(noteState)
                                if (noteState?.content.isNullOrBlank()) {
                                    homeViewModel.deleteNote(noteState)
                                    buttonEnabled = false
                                    navController.popBackStack()
                                }
                                else {
                                    noteState?.content = text
                                    homeViewModel.addOrUpdateNote(noteState)
                                }
                            }) {
                                Text("Save", color = Color.Black)
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
                title = {},
            )
        }, modifier = Modifier.fillMaxSize()
    ) { it ->
        Surface(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxSize()
        ) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Black,
                    unfocusedContainerColor = Color.Black
                ),
                placeholder = { Text("New Note...") },
            )

        }
    }
}



