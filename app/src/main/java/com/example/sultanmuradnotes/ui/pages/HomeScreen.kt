package com.example.sultanmuradnotes.ui.pages

import android.annotation.SuppressLint
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel
import com.example.sultanmuradnotes.ui.widgets.VerticalScrollingNoteList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavController) {
    val noteListState = homeViewModel.noteListFlow.collectAsState(initial = listOf())

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        topBar = {
            TopAppBar(
                title = { Text(text = "Notes", fontSize = 30.sp) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black)
            )
        },
        contentColor = Color.Black
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
                .background(Color.Black),
            color = Color.Black
        ) {
            VerticalScrollingNoteList(
                noteListState.value,
                homeViewModel,
                navController = navController
            )
        }
    }


}


