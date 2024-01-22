package com.example.sultanmuradnotes.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AboutUsTile(
    mainText: String,
    descriptionText: String
) {
    Box(modifier = Modifier
        .fillMaxWidth().padding(start = 10.dp)
        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = mainText, color = Color.White, fontSize = 16.sp)
            Text(text = descriptionText, color = Color.LightGray, fontSize = 14.sp)
        }
    }
}