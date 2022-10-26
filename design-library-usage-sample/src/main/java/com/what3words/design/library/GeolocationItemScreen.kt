package com.what3words.design.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.GeolocationItem
import com.what3words.design.library.ui.theme.Grey40

@Composable
fun GeolocationItemScreen(navController: NavController) {
    NavigationScaffold(
        title = "Suggestion Item Component",
        navController = navController
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            GeolocationItemExample(
                title = "Normal Group GeolocationItem",
                primaryAddress = "Alfred Road",
                secondaryAddress = "London",
                isGeolocationGroup = true
            )

            GeolocationItemExample(
                title = "No secondary Address Group GeolocationItem",
                primaryAddress = "Alfred Road",
                isGeolocationGroup = true
            )

            GeolocationItemExample(
                title = "Normal Single GeolocationItem",
                primaryAddress = "what3words Ltd., 65 Alfred Road",
                secondaryAddress = "London, W2 5EU",
                isGeolocationGroup = false
            )

            GeolocationItemExample(
                title = "No secondary Single GeolocationItem",
                primaryAddress = "what3words Ltd., 65 Alfred Road",
                isGeolocationGroup = false
            )

            GeolocationItemExample(
                title = "Long Addresses Group GeolocationItem",
                primaryAddress = "Alfred Road, More text here to make it long",
                secondaryAddress = "London, Greater London, United Kingdom, Europe, Planet Earth",
                isGeolocationGroup = true
            )

            GeolocationItemExample(
                title = "Long Addresses Single GeolocationItem",
                primaryAddress = "what3words Ltd., 65 Alfred Road, More text here to make it long",
                secondaryAddress = "London, W2 5EU, Greater London, United Kingdom, Europe",
                isGeolocationGroup = false
            )

            GeolocationItemExampleRtl(
                title = "Arabic Right-to-left Group GeolocationItem",
                primaryAddress = "ابو فيوض لادوات الصيد",
                secondaryAddress = "المحمودية، سنابادة، مركز المحمودية،، البحيرة 5872461",
                isGeolocationGroup = true
            )

            GeolocationItemExampleRtl(
                title = "Arabic Right-to-left Single GeolocationItem",
                primaryAddress = "ابو فيوض لادوات الصيد",
                secondaryAddress = "المحمودية، سنابادة، مركز المحمودية،، البحيرة 5872461",
                isGeolocationGroup = false
            )
        }
    }
}

@Composable
fun GeolocationItemExampleRtl(
    title: String,
    primaryAddress: String,
    secondaryAddress: String,
    isGeolocationGroup: Boolean
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.primary
    )
    Divider(color = Grey40)
    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        GeolocationItem(
            primaryAddress = primaryAddress,
            secondaryAddress = secondaryAddress,
            isGeolocationGroup = isGeolocationGroup,
            onClick = {})
    }
    Divider(color = Grey40)
}

@Composable
fun GeolocationItemExample(
    title: String,
    primaryAddress: String,
    isGeolocationGroup: Boolean,
    secondaryAddress: String? = null
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.primary
    )
    Divider(color = Grey40)
    GeolocationItem(
        primaryAddress = primaryAddress,
        secondaryAddress = secondaryAddress,
        isGeolocationGroup = isGeolocationGroup,
        onClick = {})
    Divider(color = Grey40)
}