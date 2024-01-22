package com.example.sultanmuradnotes

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sultanmuradnotes.navigation.Navigation
import com.example.sultanmuradnotes.ui.theme.SultanmuradNotesTheme
import com.example.sultanmuradnotes.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        lateinit var VERSION_NAME: String
        val colorList: List<Color> = listOf(Color(red = 0, green = 104, blue = 132))
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel: HomeViewModel by viewModels()

        VERSION_NAME = getVersionName(applicationContext)
//        TODO("Implement sorting with different properties.")
//        TODO("Change font size setting")
//        TODO("Backup to cloud")
//        TODO("Make UI beautiful")
//        TODO("Complete Settings Page")

//        homeViewModel.deleteAll()


        setContent {
            SultanmuradNotesTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Surface(
                        modifier = Modifier.padding(top = it.calculateTopPadding()),
                    ) {
                        Navigation(
                            homeViewModel = homeViewModel,
                        )


                    }
                }
            }


        }
    }
}


fun getVersionName(context: Context): String {
    return try {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        packageInfo.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        "N/A"
    }
}

