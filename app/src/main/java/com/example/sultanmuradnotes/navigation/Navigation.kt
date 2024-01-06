package com.example.sultanmuradnotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sultanmuradnotes.ui.pages.HomeScreen
import com.example.sultanmuradnotes.ui.pages.IndividualNoteScreen
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel


@Composable
fun Navigation(
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HOME.name) {
        composable(route = "home") {
            HomeScreen(homeViewModel = homeViewModel, navController = navController)
        }

        composable(route = Screen.NOTE.name + "/{id}", arguments = listOf(
            navArgument("id") {
                type = NavType.LongType
//                nullable = true
//                defaultValue = null
            }
        )
        ) {

            IndividualNoteScreen(id = it.arguments?.getLong("id"), homeViewModel = homeViewModel)
        }
    }
}