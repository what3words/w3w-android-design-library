package com.what3words.design.library.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.NavigationBarScaffold
import com.what3words.design.library.ui.components.SuggestionGeolocation
import com.what3words.design.library.ui.theme.Grey40
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun SuggestionGeolocationScreen(navController: NavController) {
    val navigationIcon: (@Composable () -> Unit)? =
        if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = W3WTheme.colors.primary)
                }
            }
        } else {
            null
        }
    NavigationBarScaffold(
        title = "SuggestionGeolocation",
        navigationIcon = navigationIcon
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
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
private fun GeolocationItemExampleRtl(
    title: String,
    primaryAddress: String,
    secondaryAddress: String,
    isGeolocationGroup: Boolean
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textFootnote
    )
    Divider(color = Grey40)
    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        SuggestionGeolocation(
            primaryAddress = primaryAddress,
            secondaryAddress = secondaryAddress,
            isGeolocationGroup = isGeolocationGroup,
            onClick = {})
    }
    Divider(color = Grey40)
}

@Composable
internal fun GeolocationItemExample(
    title: String,
    primaryAddress: String,
    isGeolocationGroup: Boolean,
    secondaryAddress: String? = null,
    onClick: (() -> Unit)? = null
) {
    if (title.isNotEmpty()) {
        Text(
            text = title,
            modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
            style = W3WTheme.typography.footnote,
            color = W3WTheme.colors.textFootnote
        )
    }
    Divider(color = Grey40)
    SuggestionGeolocation(
        primaryAddress = primaryAddress,
        secondaryAddress = secondaryAddress,
        isGeolocationGroup = isGeolocationGroup,
        onClick = onClick
    )
    Divider(color = Grey40)
}