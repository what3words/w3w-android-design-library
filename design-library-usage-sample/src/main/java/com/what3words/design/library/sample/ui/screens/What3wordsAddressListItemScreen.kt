package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.components.What3wordsAddressListItem

/**
 * A screen showcasing various implementations of the What3words address list item component.
 * This screen displays the What3words address list item in different configurations,
 * including simple list items, list items with detailed information such as nearest places and labels,
 * and list items with right-to-left language support.
 *
 * This screen serves as a demonstration of how to use the What3words address list item component
 * in various contexts within a UI, catering to different language directions and providing
 * additional information when needed.
 */
@Composable
fun What3wordsAddressListItemScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        What3wordsAddressListItem("filled.count.soap")

        What3wordsAddressListItem(
            words = "filled.count.soap",
            nearestPlace = "Bayswater, London",
            distance = 0,
            isLand = false,
            label = "Label name",
            onClick = {}
        )

        What3wordsAddressListItem(
            words = "filled.count.soap",
            nearestPlacePrefix = "",
            nearestPlace = "有些.明细.火星",
            onClick = {}
        )

        What3wordsAddressListItem(
            words = "congratulations.congratulations.congratulations",
            nearestPlace = "Bayswater, London",
            distance = 0,
            isLand = false,
            label = "Label name",
            onClick = {}
        )

        What3wordsAddressListItem(
            words = "filled.count.soap",
            distance = 20,
            label = "Label name",
            onClick = {}
        )

        CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
            What3wordsAddressListItem("لبن.درجات.عنق")

            What3wordsAddressListItem(
                words = "لبن.درجات.عنق",
                nearestPlacePrefix = "الرياض",
                nearestPlace = "Bayswater, London",
                distance = 0,
                isLand = false,
                label = "اسم الطابع",
                onClick = {}
            )

            What3wordsAddressListItem(
                words = "لبن.درجات.عنق",
                nearestPlacePrefix = "",
                nearestPlace = "有些.明细.火星",
                onClick = {}
            )
        }
    }
}