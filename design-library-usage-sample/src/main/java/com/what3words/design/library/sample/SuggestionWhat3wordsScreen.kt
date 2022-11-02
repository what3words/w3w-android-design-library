package com.what3words.design.library.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.what3words.design.library.ui.components.SuggestionWhat3words
import com.what3words.design.library.ui.theme.Grey40
import com.what3words.design.library.ui.theme.W3WTheme
import java.util.Locale

@Composable
fun SuggestionWhat3wordsScreen(navController: NavController) {
    NavigationScaffold(
        title = "SuggestionWhat3words",
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(W3WTheme.colors.background)
        ) {
            SuggestionWhat3wordsExample(
                title = "Normal SuggestionWhat3words",
                words = "index.home.raft",
                country = "GB",
                near = "Bayswater, London",
                distance = 30
            )

            SuggestionWhat3wordsExample(
                title = "Highlighted SuggestionWhat3words",
                words = "index.home.raft",
                country = "GB",
                near = "Bayswater, London",
                distance = 30,
                isHighlighted = true
            )

            SuggestionWhat3wordsExample(
                title = "Normal SuggestionWhat3words with large address",
                words = "congratulations.congratulations.congratulations",
                country = "NZ",
                near = "Taumatawhakatangihangakoauauo, Porangahau sdsdsds",
                distance = 6800
            )


            SuggestionWhat3wordsExample(
                title = "Water SuggestionWhat3words",
                words = "shivers.endangers.whence",
                country = "ZZ",
                near = "St Agnes, Isles of Scilly",
                distance = 300
            )

            SuggestionWhat3wordsExample(
                title = "Water SuggestionWhat3words without near",
                words = "cheerfulness.miming.thereby",
                country = "ZZ",
                near = null,
                distance = 200
            )

            SuggestionItemExampleRtl(
                title = "Arabic right-to-left SuggestionWhat3words",
                words = "القطار.مسعف.شخصيات",
                country = "UK",
                distance = 20,
                near = "لندن"
            )
        }
    }
}

@Composable
fun SuggestionItemExampleRtl(
    title: String,
    words: String,
    country: String,
    near: String? = null,
    distance: Int? = null
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = W3WTheme.typography.footnote,
        color = W3WTheme.colors.textFootnote
    )
    Divider(color = Grey40)
    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        SuggestionWhat3words(
            words = words,
            near = near,
            distance = "${distance}km",
            isLand = country.lowercase(Locale.getDefault()) != "zz",
            onClick = {})
    }
    Divider(color = Grey40)
}

@Composable
fun SuggestionWhat3wordsExample(
    title: String,
    words: String,
    country: String,
    isHighlighted: Boolean = false,
    near: String? = null,
    distance: Int? = null,
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
    SuggestionWhat3words(
        words = words,
        near = near,
        distance = "${distance}km",
        isLand = country.lowercase(Locale.getDefault()) != "zz",
        onClick = onClick,
        isHighlighted = isHighlighted
    )
    Divider(color = Grey40)
}