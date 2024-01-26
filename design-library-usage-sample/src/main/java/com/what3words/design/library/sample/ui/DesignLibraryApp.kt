package com.what3words.design.library.sample.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.what3words.design.library.sample.MainActivityViewModel
import com.what3words.design.library.sample.R
import com.what3words.design.library.sample.ui.screens.ButtonScreen
import com.what3words.design.library.sample.ui.screens.ColorPaletteScreen
import com.what3words.design.library.sample.ui.screens.HomeScreen
import com.what3words.design.library.sample.ui.screens.IconButtonScreen
import com.what3words.design.library.sample.ui.screens.ListItemScreen
import com.what3words.design.library.sample.ui.screens.What3wordsAddressListItemScreen
import com.what3words.design.library.sample.ui.screens.What3wordsAddressScreen


@ExperimentalMaterial3Api
@Composable
fun DesignLibraryApp(
    navController: NavHostController,
    title: String,
    currentTheme: MainActivityViewModel.Theme,
    currentColours: MainActivityViewModel.Colours,
    onThemeChanged: (MainActivityViewModel.Theme) -> (Unit),
    onColourChanged: (MainActivityViewModel.Colours) -> (Unit),
    onTitleChanged: (String) -> (Unit)
) {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(),
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = {
                        onColourChanged.invoke(if (currentColours == MainActivityViewModel.Colours.Day) MainActivityViewModel.Colours.Night else MainActivityViewModel.Colours.Day)
                    }) {
                        Icon(
                            painter = if (currentColours == MainActivityViewModel.Colours.Day) painterResource(
                                R.drawable.ic_day_mode
                            ) else painterResource(R.drawable.ic_dark_mode),
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = {
                        onThemeChanged.invoke(if (currentTheme == MainActivityViewModel.Theme.Material) MainActivityViewModel.Theme.What3words else MainActivityViewModel.Theme.Material)
                    }) {
                        Icon(
                            painter = if (currentTheme == MainActivityViewModel.Theme.Material) painterResource(
                                R.drawable.ic_material_design
                            ) else painterResource(R.drawable.ic_w3w),
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) {
        NavHost(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(it),
            navController = navController,
            startDestination = NavScreen.Home.route
        ) {
            composable(NavScreen.Home.route) {
                onTitleChanged.invoke("What3words Android Design Library")
                HomeScreen(navController)
            }
            composable(NavScreen.ColorPaletteScreen.route) {
                onTitleChanged.invoke("Colour Palettes")
                ColorPaletteScreen()
            }
            composable(NavScreen.What3wordsAddressScreen.route) {
                onTitleChanged.invoke("What3words Address")
                What3wordsAddressScreen()
            }
            composable(NavScreen.What3wordsAddressListItemScreen.route) {
                onTitleChanged.invoke("What3words Address List Item")
                What3wordsAddressListItemScreen()
            }
            composable(NavScreen.ButtonScreen.route) {
                onTitleChanged.invoke("Buttons")
                ButtonScreen()
            }
            composable(NavScreen.IconButtonScreen.route) {
                onTitleChanged.invoke("Icon buttons")
                IconButtonScreen()
            }
            composable(NavScreen.ListItemScreen.route) {
                onTitleChanged.invoke("List Items")
                ListItemScreen()
            }
        }
    }
}