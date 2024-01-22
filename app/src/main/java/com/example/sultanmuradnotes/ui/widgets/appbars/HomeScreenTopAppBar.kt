package com.example.sultanmuradnotes.ui.widgets.appbars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sultanmuradnotes.R
import com.example.sultanmuradnotes.ui.theme.Rubik

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopAppBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.home_screen_top_app_bar),
                fontSize = 30.sp,
                fontFamily = Rubik,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
        actions = {
            IconButton(onClick = {
//                navController.navigate(Screen.SETTINGS.name)
            }, colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)) {
                Icon(
                    painter = painterResource(id = R.drawable.settings_dark),
                    contentDescription = ""
                )

            }
        }
    )
}