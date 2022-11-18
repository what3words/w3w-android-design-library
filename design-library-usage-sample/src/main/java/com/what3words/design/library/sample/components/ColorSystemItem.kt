package com.what3words.design.library.sample.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.theme.W3WTheme

@Composable
fun ColorSystemItem(context: Context, color: Color, colorName: String, hex: String) {
    Box(modifier = Modifier
        .padding(W3WTheme.dimensions.paddingTiny)
        .size(32.dp)
        .clip(CircleShape)
        .background(color)
        .border(1.dp, Color.Gray, CircleShape)
        .clickable {
            Toast
                .makeText(
                    context, "$colorName: $hex", Toast.LENGTH_SHORT
                )
                .show()
        })
}