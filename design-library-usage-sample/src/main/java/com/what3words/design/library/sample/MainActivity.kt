@file:OptIn(ExperimentalMaterial3Api::class)

package com.what3words.design.library.sample

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.what3words.design.library.sample.ui.DesignLibraryApp
import com.what3words.design.library.ui.theme.LocalW3WColorScheme
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.design.library.ui.theme.m3DarkW3WSchemeColors
import com.what3words.design.library.ui.theme.m3LightW3WSchemeColors

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainActivityViewModel by viewModels()
        viewModel.selectedColours.value =
            if (isDarkMode()) MainActivityViewModel.Colours.Night else MainActivityViewModel.Colours.Day
        enableEdgeToEdge()
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
                    CompositionLocalProvider(
                        LocalW3WColorScheme provides m3LightW3WSchemeColors
                    ) {
                        MaterialTheme(colorScheme = lightColorScheme()) {
                            enableEdgeToEdge()
                            mainScreen()
                        }
                    }
                }

                selectedTheme == MainActivityViewModel.Theme.Material && selectedColours == MainActivityViewModel.Colours.Night -> {
                    CompositionLocalProvider(
                        LocalW3WColorScheme provides m3DarkW3WSchemeColors
                    ) {
                        MaterialTheme(colorScheme = darkColorScheme()) {
                            enableEdgeToEdge()
                            mainScreen()
                        }
                    }
                }

                selectedTheme == MainActivityViewModel.Theme.What3words && selectedColours == MainActivityViewModel.Colours.Day -> {
                    W3WTheme(false) {
                        SetEdgeToEdge(false)
                        mainScreen()
                    }
                }

                selectedTheme == MainActivityViewModel.Theme.What3words && selectedColours == MainActivityViewModel.Colours.Night -> {
                    W3WTheme(true) {
                        SetEdgeToEdge(true)
                        mainScreen()
                    }
                }
            }
        }
    }

    @Composable
    private fun SetEdgeToEdge(isDarkMode: Boolean) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = MaterialTheme.colorScheme.secondaryContainer.toArgb(),
                darkScrim = MaterialTheme.colorScheme.secondaryContainer.toArgb()
            ){
                isDarkMode
            },
            navigationBarStyle = SystemBarStyle.auto(
                lightScrim = MaterialTheme.colorScheme.surfaceContainerLow.toArgb(),
                darkScrim = MaterialTheme.colorScheme.surfaceContainerLow.toArgb()
            ) {
                isDarkMode
            }
        )
    }

    private fun isDarkMode(): Boolean {
        return when (resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> true
            else -> false
        }
    }
}

