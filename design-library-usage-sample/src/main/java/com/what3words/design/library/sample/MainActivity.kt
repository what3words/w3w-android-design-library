@file:OptIn(ExperimentalMaterial3Api::class)

package com.what3words.design.library.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.what3words.design.library.sample.ui.DesignLibraryApp
import com.what3words.design.library.ui.theme.W3WTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainActivityViewModel by viewModels()

        setContent {
            val selectedTheme by viewModel.selectedTheme.collectAsState()
            val selectedColours by viewModel.selectedColours.collectAsState()
            val navController = rememberNavController()
            var title by remember { mutableStateOf(value = "What3words Android Design Library") }

            val mainScreen: (@Composable () -> Unit) = {
                DesignLibraryApp(
                    navController = navController,
                    title = title,
                    currentTheme = selectedTheme,
                    currentColours = selectedColours,
                    onThemeChanged = { theme -> viewModel.selectedTheme.value = theme },
                    onColourChanged = { colours -> viewModel.selectedColours.value = colours },
                    onTitleChanged = { newTitle -> title = newTitle }
                )
            }

            when {
                selectedTheme == MainActivityViewModel.Theme.Material && selectedColours == MainActivityViewModel.Colours.Day -> {
                    MaterialTheme(colorScheme = lightColorScheme()) {
                        mainScreen()
                    }
                }

                selectedTheme == MainActivityViewModel.Theme.Material && selectedColours == MainActivityViewModel.Colours.Night -> {
                    MaterialTheme(colorScheme = darkColorScheme()) {
                        mainScreen()
                    }
                }

                selectedTheme == MainActivityViewModel.Theme.What3words && selectedColours == MainActivityViewModel.Colours.Day -> {
                    W3WTheme {
                        mainScreen()
                    }
                }

                selectedTheme == MainActivityViewModel.Theme.What3words && selectedColours == MainActivityViewModel.Colours.Night -> {
                    W3WTheme(true) {
                        mainScreen()
                    }
                }
            }
        }
    }
}

