package com.example.sultanmuradnotes.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel
import com.example.sultanmuradnotes.ui.widgets.VerticalScrollingNoteList
import com.example.sultanmuradnotes.ui.widgets.appbars.HomeScreenTopAppBar


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavController) {
    val noteListState = homeViewModel.noteEntityListFlow.collectAsState(initial = listOf())

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        topBar = {
            HomeScreenTopAppBar(navController)
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


