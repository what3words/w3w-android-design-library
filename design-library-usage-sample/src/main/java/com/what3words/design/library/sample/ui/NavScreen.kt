@file:OptIn(ExperimentalMaterial3Api::class)

package com.what3words.design.library.sample.ui

import androidx.compose.material3.ExperimentalMaterial3Api

sealed class NavScreen(val route: String) {
    object Home : NavScreen("Home")
    object What3wordsAddressScreen : NavScreen("What3wordsAddressScreen")
    object ColorPaletteScreen : NavScreen("ColorPaletteScreen")
    object SuggestionGeolocationScreen : NavScreen("SuggestionGeolocationScreen")
    object ListItemNavigationScreen : NavScreen("ListItemNavigationScreen")
    object ListItemActionScreen : NavScreen("ListItemActionScreen")
    object FormFieldsScreen : NavScreen("FormFieldsScreen")
    object NotificationScreen : NavScreen("NotificationScreen")
    object ButtonScreen : NavScreen("ButtonScreen")
    object IconButtonScreen : NavScreen("IconButtonScreen")
}