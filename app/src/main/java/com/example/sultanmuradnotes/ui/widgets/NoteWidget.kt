package com.example.sultanmuradnotes.ui.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sultanmuradnotes.R
import com.example.sultanmuradnotes.db.domain.NoteEntity
import com.example.sultanmuradnotes.navigation.Screen
import com.example.sultanmuradnotes.ui.theme.Rubik
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Composable
fun NoteWidget(noteEntity: NoteEntity) {
    val text: String = noteEntity.content
    val timeOfModification = noteEntity.timeOfModification
    val timeOfCreation = noteEntity.timeOfCreation
    val isEqual = timeOfCreation == timeOfModification
    val formattedTime = if (isEqual) {
        formatDateTime(timeOfCreation)
    } else {
        // Replace with your actual time of modification
        formatDateTime(LocalDateTime.now()) // Example: using current time for modification
    }

    Box(
        modifier = Modifier
            .background(Color(noteEntity.backgroundColor))
            .padding(PaddingValues(start = 10.dp, top = 24.dp, bottom = 24.dp, end = 24.dp)),
    ) {

        Column {
            Text(
                text = text,
//                style = MaterialTheme.typography.bodyMedium,
                fontFamily = Rubik,
                fontSize = 15.sp,
                overflow = TextOverflow.Ellipsis,
                color = Color(noteEntity.textColor),
                modifier = Modifier
                    .padding(PaddingValues(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 35.dp))
                    .fillMaxWidth(),
                maxLines = 3
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth(), contentAlignment = Alignment.BottomEnd
            ) {
                Text(
                    text = formattedTime,
                    fontSize = 10.sp
                )
            }
        }


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
fun VerticalScrollingNoteList(
    noteEntities: List<NoteEntity>,
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    var count = 0
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


        if (noteEntities.isEmpty()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.empty_note_image),
                    contentDescription = null
                )

                Text(text = "Create your first note!")
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp
                )
            ) {
                items(noteEntities.size) {

                    Box(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .clip(RoundedCornerShape(15))

                            // TODO("fix this shit")
                            .clickable {
                                navController.navigate(Screen.NOTE.name + "/" + noteEntities[count].id)
                            }
                    ) {
                        NoteWidget(noteEntities[count])
                    }
                    Spacer(Modifier.height(20.dp))
                    if (count != noteEntities.size - 1) {
                        count++
                    }
                }
            }
        }
    }
}


fun formatDateTime(dateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm")
    return dateTime.format(formatter)
}