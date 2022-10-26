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
import com.what3words.design.library.ui.components.SuggestionItem
import com.what3words.design.library.ui.theme.Grey40
import java.util.Locale

@Composable
fun SuggestionItemScreen(navController: NavController) {
    NavigationScaffold(
        title = "Suggestion Item Component",
        navController = navController
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SuggestionItemExample(
                title = "Normal SuggestionItem",
                words = "index.home.raft",
                country = "GB",
                near = "Bayswater, London",
                distance = 30
            )

            SuggestionItemExample(
                title = "Normal SuggestionItem with large what3words address",
                words = "congratulations.congratulations.congratulations",
                country = "NZ",
                near = "Taumatawhakatangihangakoauauo, Porangahau sdsdsds",
                distance = 6800
            )


            SuggestionItemExample(
                title = "Water SuggestionItem",
                words = "shivers.endangers.whence",
                country = "ZZ",
                near = "St Agnes, Isles of Scilly",
                distance = 300
            )

            SuggestionItemExample(
                title = "Water SuggestionItem without near",
                words = "cheerfulness.miming.thereby",
                country = "ZZ",
                near = null,
                distance = 200
            )

            SuggestionItemExampleRtl(
                title = "Arabic right-to-left SuggestionItem",
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
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.primary
    )
    Divider(color = Grey40)
    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        SuggestionItem(
            words = words,
            near = near,
            distance = "${distance}km",
            isLand = country.lowercase(Locale.getDefault()) != "zz",
            onClick = {})
    }
    Divider(color = Grey40)
}

@Composable
fun SuggestionItemExample(
    title: String,
    words: String,
    country: String,
    near: String? = null,
    distance: Int? = null
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = MaterialTheme.typography.caption,
        color = MaterialTheme.colors.primary
    )
    Divider(color = Grey40)
    SuggestionItem(
        words = words,
        near = near,
        distance = "${distance}km",
        isLand = country.lowercase(Locale.getDefault()) != "zz",
        onClick = {})
    Divider(color = Grey40)
}