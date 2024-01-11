package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.components.What3wordsAddress
import com.what3words.design.library.ui.components.What3wordsAddressDefaults
import java.util.Locale

@Composable
fun What3wordsAddressScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Simple SuggestionWhat3words",
            modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
            style = MaterialTheme.typography.titleSmall
        )

        What3wordsAddress("index.home.raft")
        What3wordsAddress(modifier = Modifier.width(120.dp).padding(top = 4.dp), words = "index.\nhome.\nraft")

        What3wordsAddressExample(
            title = "Normal SuggestionWhat3words",
            words = "index.home.raft",
            country = "GB",
            near = "Bayswater, London",
            distance = 30
        )

        What3wordsAddressExample(
            title = "Highlighted SuggestionWhat3words",
            words = "index.home.raft",
            country = "GB",
            near = "Bayswater, London",
            distance = 30,
            isHighlighted = true
        )

        What3wordsAddressExample(
            title = "Normal SuggestionWhat3words with large address",
            words = "congratulations.congratulations.congratulations",
            country = "NZ",
            near = "Taumatawhakatangihangakoauauo, Porangahau sdsdsds",
            distance = 6800
        )


        What3wordsAddressExample(
            title = "Water SuggestionWhat3words",
            words = "shivers.endangers.whence",
            country = "ZZ",
            near = "St Agnes, Isles of Scilly",
            distance = 300
        )

        What3wordsAddressExample(
            title = "Water SuggestionWhat3words without near",
            words = "cheerfulness.miming.thereby",
            country = "ZZ",
            near = null,
            distance = 200
        )

        What3wordsAddressExample(
            title = "SuggestionWhat3words full with label",
            words = "cheerfulness.miming.thereby",
            country = "ZZ",
            near = "St Agnes, Isles of Scilly",
            distance = 200,
            label = "My label here"
        )

        What3wordsAddressExampleRtl(
            title = "Arabic right-to-left SuggestionWhat3words",
            words = "القطار.مسعف.شخصيات",
            country = "UK",
            distance = 20,
            near = "لندن"
        )
    }
}

@Composable
fun What3wordsAddressExampleRtl(
    title: String,
    words: String,
    country: String,
    near: String? = null,
    distance: Int? = null
) {
    Text(
        text = title,
        modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
        style = MaterialTheme.typography.titleSmall
    )
    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        What3wordsAddress(
            words = words,
            nearestPlace = near,
            distance = distance,
            isLand = country.lowercase(Locale.getDefault()) != "zz",
            onClick = {})
    }
}

@Composable
fun What3wordsAddressExample(
    title: String,
    words: String,
    country: String,
    isHighlighted: Boolean = false,
    near: String? = null,
    distance: Int? = null,
    label: String? = null,
    onClick: (() -> Unit)? = null
) {
    if (title.isNotEmpty()) {
        Text(
            text = title,
            modifier = Modifier.padding(top = 20.dp, start = 12.dp, bottom = 4.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
    What3wordsAddress(
        words = words,
        nearestPlace = near,
        distance = distance,
        isLand = country.lowercase(Locale.getDefault()) != "zz",
        onClick = onClick,
        isHighlighted = isHighlighted,
        label = label,
        colors = What3wordsAddressDefaults.defaultColors(
            dividerColor = MaterialTheme.colorScheme.outlineVariant
        )
    )
}