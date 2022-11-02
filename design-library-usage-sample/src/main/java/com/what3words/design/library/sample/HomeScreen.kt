package com.what3words.design.library.sample

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.theme.W3WTheme

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
                backgroundColor = W3WTheme.colors.background,
                title = {
                    Text(
                        text = title.orEmpty(),
                        color = W3WTheme.colors.textPrimary,
                        style = W3WTheme.typography.headline
                    )
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
        title = "What3words Android Design Library",
        navController = navController
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(W3WTheme.colors.background)
                .verticalScroll(rememberScrollState())
                .padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
        ) {
            Text(
                text = "Colours",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary
            )
            Row(
                Modifier
                    .padding(W3WTheme.dimensions.paddingMedium)
                    .horizontalScroll(rememberScrollState())
            ) {
                ColorSystemItem(
                    context,
                    W3WTheme.colors.primary,
                    "primary",
                    W3WTheme.colors.primary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.background,
                    "background",
                    W3WTheme.colors.background.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundHighlighted,
                    "highlightedBackground",
                    W3WTheme.colors.backgroundHighlighted.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textPrimary,
                    "textPrimary",
                    W3WTheme.colors.textPrimary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textSecondary,
                    "textSecondary",
                    W3WTheme.colors.textSecondary.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textAccent,
                    "textAccent",
                    W3WTheme.colors.textAccent.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textFootnote,
                    "textFootnote",
                    W3WTheme.colors.textFootnote.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.backgroundError,
                    "backgroundError",
                    W3WTheme.colors.backgroundError.toHexCode()
                )
                ColorSystemItem(
                    context,
                    W3WTheme.colors.textError,
                    "textError",
                    W3WTheme.colors.textError.toHexCode()
                )
            }
            Divider(
                color = W3WTheme.colors.primary,
                modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "Typography",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: title",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.title,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: headline",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: body",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.body,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: caption1",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.caption1,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: caption2",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.caption2,
                color = W3WTheme.colors.textPrimary
            )
            Text(
                text = "- This text is using typography: footnote",
                modifier = Modifier.padding(W3WTheme.dimensions.paddingMedium),
                style = W3WTheme.typography.footnote,
                color = W3WTheme.colors.textPrimary
            )

            Divider(
                color = W3WTheme.colors.primary,
                modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "SuggestionWhat3words >",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall)
                    .clickable {
                        navController.navigate("SuggestionWhat3wordsScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary,
            )
            SuggestionWhat3wordsExample(
                title = "",
                words = "index.home.raft",
                country = "GB",
                near = "Bayswater, London",
                distance = 30,
                onClick = { navController.navigate("SuggestionWhat3wordsScreen") }
            )
            Divider(
                color = W3WTheme.colors.primary,
                modifier = Modifier.padding(
                    top = W3WTheme.dimensions.paddingMedium,
                    bottom = W3WTheme.dimensions.paddingMedium
                )
            )
            Text(
                text = "SuggestionGeolocation >",
                modifier = Modifier
                    .padding(W3WTheme.dimensions.paddingSmall)
                    .clickable {
                        navController.navigate("SuggestionGeolocationScreen")
                    },
                style = W3WTheme.typography.headline,
                color = W3WTheme.colors.textPrimary,
            )
            GeolocationItemExample(
                title = "",
                primaryAddress = "Alfred Road",
                secondaryAddress = "London",
                isGeolocationGroup = true
            ) {
                navController.navigate("SuggestionGeolocationScreen")
            }
        }
    }
}

@Composable
fun ColorSystemItem(context: Context, color: Color, colorName: String, hex: String) {
    Box(
        modifier = Modifier
            .padding(W3WTheme.dimensions.paddingTiny)
            .size(32.dp)
            .clip(CircleShape)
            .background(color)
            .border(1.dp, Color.Gray, CircleShape)
            .clickable {
                Toast
                    .makeText(
                        context,
                        "$colorName: $hex",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
    )
}

private fun Color.toHexCode(): String {
    val red = this.red * 255
    val green = this.green * 255
    val blue = this.blue * 255
    return String.format("#%02x%02x%02x", red.toInt(), green.toInt(), blue.toInt())
}
