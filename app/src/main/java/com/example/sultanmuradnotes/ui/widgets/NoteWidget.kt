package com.example.sultanmuradnotes.ui.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.sultanmuradnotes.db.domain.Note
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.navigation.NavController
import com.example.sultanmuradnotes.navigation.Screen
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun NoteWidget(note: Note) {
    val text: String = note.content

    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(PaddingValues(start = 10.dp, top = 24.dp, bottom = 24.dp, end = 24.dp)),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis,
            color = Color.Gray,
            modifier = Modifier
                .padding(PaddingValues(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 35.dp))
                .fillMaxWidth(),
            maxLines = 1
        )
//
//        Spacer(modifier = Modifier.width(20.dp))
//
//        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterEnd)) {
//            Icon(
//                imageVector = Icons.Default.Edit,
//                contentDescription = "Edit Icon",
//                tint = Color.Green,
//                modifier = Modifier.align(Alignment.CenterEnd)
//            )
//        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VerticalScrollingNoteList(notes: List<Note>, homeViewModel: HomeViewModel, navController: NavController) {
    var fabHeight by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.onGloballyPositioned {
                    fabHeight = it.size.height
                },
                shape = CircleShape,
                onClick = {
//                    homeViewModel.addOrUpdateNote(note = Note(null, "New Note"))
                    navController.navigate(Screen.EMPTY.name)
                },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "icon")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp
            )
        ) {
            items(notes) {
                Box(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .clip(RoundedCornerShape(15))
                        .clickable { navController.navigate(Screen.NOTE.name +"/" +it.id)}
                ) {
                    NoteWidget(it)
                }
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}


