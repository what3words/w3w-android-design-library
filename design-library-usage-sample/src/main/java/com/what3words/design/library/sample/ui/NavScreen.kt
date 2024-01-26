@file:OptIn(ExperimentalMaterial3Api::class)

package com.what3words.design.library.sample.ui

import androidx.compose.material3.ExperimentalMaterial3Api

sealed class NavScreen(val route: String) {
    object Home : NavScreen("Home")
    object What3wordsAddressListItemScreen : NavScreen("What3wordsAddressListItemScreen")
    object What3wordsAddressScreen : NavScreen("What3wordsAddressScreen")
    object ColorPaletteScreen : NavScreen("ColorPaletteScreen")
    object ListItemScreen : NavScreen("ListItemScreen")
    object ButtonScreen : NavScreen("ButtonScreen")
    object IconButtonScreen : NavScreen("IconButtonScreen")
}