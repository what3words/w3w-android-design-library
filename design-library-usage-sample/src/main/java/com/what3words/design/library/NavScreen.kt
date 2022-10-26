package com.what3words.design.library

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class NavScreen(val route: String) {
    object Home : NavScreen("Home")
    object SuggestionItemScreen : NavScreen("SuggestionItemScreen")
    object GeolocationItemScreen : NavScreen("GeolocationItemScreen")
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.Home.route) {
        composable(NavScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(NavScreen.SuggestionItemScreen.route) {
            SuggestionItemScreen(navController)
        }
        composable(NavScreen.GeolocationItemScreen.route) {
            GeolocationItemScreen(navController)
        }
    }
}