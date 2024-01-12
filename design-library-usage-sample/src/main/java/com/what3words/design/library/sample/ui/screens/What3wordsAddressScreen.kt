package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.components.What3wordsAddress
import com.what3words.design.library.ui.theme.W3WTheme

/**
 * A screen showcasing different implementations of the What3words address component styled by both [MaterialTheme] and [W3WTheme].
 * This screen provides examples of the What3words address composable in various configurations
 * such as simple, normal, highlighted, with large addresses, water theme, with and without labels,
 * and right-to-left language support.
 *
 * This screen serves as a demonstration of how to use the What3words address composable
 * in different contexts and configurations within a UI.
 */
@Composable
fun What3wordsAddressScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        What3wordsAddress("filled.count.soap")

        What3wordsAddress(
            words = "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 0,
            isLand = false,
            label = "Label name",
            onClick = {}
        )

        What3wordsAddress(
            words = "filled.count.soap",
            nearestPlacePrefix = "",
            nearestPlace = "有些.明细.火星",
            onClick = {}
        )

        CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
            What3wordsAddress("لبن.درجات.عنق")

            What3wordsAddress(
                words = "لبن.درجات.عنق",
                nearestPlacePrefix = "الرياض",
                nearestPlace = "Bayswater, London",
                distance = 0,
                isLand = false,
                label = "اسم الطابع",
                onClick = {}
            )

            What3wordsAddress(
                words = "لبن.درجات.عنق",
                nearestPlacePrefix = "",
                nearestPlace = "有些.明细.火星",
                onClick = {}
            )
        }
    }
}