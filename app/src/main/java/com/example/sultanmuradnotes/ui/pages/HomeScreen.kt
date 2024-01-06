package com.example.sultanmuradnotes.ui.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel
import com.example.sultanmuradnotes.ui.widgets.VerticalScrollingNoteList


@Composable
fun HomeScreen( homeViewModel: HomeViewModel, navController: NavController) {
    val noteListState = homeViewModel.noteListFlow.collectAsState(initial = listOf())
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        VerticalScrollingNoteList(noteListState.value, homeViewModel, navController = navController)
    }
}


