package com.example.sultanmuradnotes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.sultanmuradnotes.navigation.Navigation
import com.example.sultanmuradnotes.ui.theme.SultanmuradNotesTheme
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel: HomeViewModel by viewModels()
//        val db = AppDatabase.getInstance(applicationContext)
//
//        for(i in 1..10) {
//            homeViewModel.addOrUpdateNote(Note(id = null, content = "Note number $i"))
//        }

//        homeViewModel.deleteAllNotes()

        /*
        TODO
        sorting with different properties.
         */

        /*
        TODO
        change font size
         */

        /*
        TODO
        Backup to cloud
         */

        setContent {
            SultanmuradNotesTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Notes", fontSize = 30.sp) },
                        )
                    }, modifier = Modifier.fillMaxSize()
                ) {
                    Surface(
                        modifier = Modifier.padding(top = it.calculateTopPadding())
                    ) {
//                        HomeScreen(homeViewModel = homeViewModel)
                        Navigation(homeViewModel = homeViewModel)
                    }
                }
            }
        }
    }
}


