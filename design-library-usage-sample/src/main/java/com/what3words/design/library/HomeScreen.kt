package com.what3words.design.library

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationScaffold(
    title: String? = null,
    navController: NavController? = null,
    bodyContent: @Composable (PaddingValues) -> Unit
) {
    val navigationIcon: (@Composable () -> Unit)? =
        if (navController?.previousBackStackEntry != null) {
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        } else {
            // this can be null or another component
            // If null, the navigationIcon won't be rendered at all
            null
        }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = title.orEmpty())
                },
                navigationIcon = navigationIcon,
            )
        }
    ) {
        bodyContent(it)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    NavigationScaffold(
        title = "Home",
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(12.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate("SuggestionItemScreen") }
            ) {
                Text(text = "Suggestion Item")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate("GeolocationItemScreen") }
            ) {
                Text(text = "Geolocation Item")
            }
        }
    }
}