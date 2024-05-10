package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.components.AutoSizeText
import com.what3words.design.library.ui.components.What3wordsAddress
import com.what3words.design.library.ui.theme.w3wColorScheme

/**
 * A screen displaying examples of What3words address components.
 * This screen showcases the use of the What3words address in both standard and right-to-left (RTL) layout directions.
 *
 * The screen serves as a demonstration of the What3words address component's adaptability to different
 * language layouts, making it suitable for internationalization and localization in UI design.
 */
@Composable
fun What3wordsAddressScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        What3wordsAddress(
            "filled.count.soap",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
        What3wordsAddress(
            "props.rest.power", secondaryText = "long.live.fever", modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        What3wordsAddress(
            "index.home.raft", secondaryText = "congratulations.congratulations.congratulations"
            , modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
            What3wordsAddress(
                "لبن.درجات.عنق",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            )
        }
    }
}