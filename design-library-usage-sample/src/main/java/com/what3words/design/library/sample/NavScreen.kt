package com.what3words.design.library.sample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class NavScreen(val route: String) {
    object Home : NavScreen("Home")
    object SuggestionWhat3wordsScreen : NavScreen("SuggestionWhat3wordsScreen")
    object SuggestionGeolocationScreen : NavScreen("SuggestionGeolocationScreen")
    object ListItemNavigationScreen : NavScreen("ListItemNavigationScreen")
    object ListItemActionScreen : NavScreen("ListItemActionScreen")
    object FormFieldsScreen : NavScreen("FormFieldsScreen")
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.Home.route) {
        composable(NavScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(NavScreen.SuggestionWhat3wordsScreen.route) {
            SuggestionWhat3wordsScreen(navController)
        }
        composable(NavScreen.SuggestionGeolocationScreen.route) {
            SuggestionGeolocationScreen(navController)
        }
        composable(NavScreen.ListItemNavigationScreen.route) {
            ListItemNavigationScreen(navController)
        }
        composable(NavScreen.ListItemActionScreen.route) {
            ListItemActionScreen(navController)
        }
        composable(NavScreen.FormFieldsScreen.route) {
            FormFieldsScreen(navController)
        }
    }
}
