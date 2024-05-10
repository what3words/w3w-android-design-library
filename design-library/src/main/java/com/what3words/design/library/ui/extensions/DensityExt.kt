package com.what3words.design.library.ui.extensions

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit

internal fun Density.roundToPx(sp: TextUnit): Int = sp.roundToPx()
internal fun Density.toSp(px: Int): TextUnit = px.toSp()
internal fun Density.toIntSize(dpSize: DpSize): IntSize =
    IntSize(dpSize.width.roundToPx(), dpSize.height.roundToPx())
