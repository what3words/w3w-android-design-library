package com.what3words.design.library.ui.models

import androidx.compose.runtime.Immutable
import kotlin.reflect.KProperty

@Immutable
data class ImmutableWrapper<T>(val value: T)

fun <T> T.toImmutableWrapper() = ImmutableWrapper(this)

operator fun <T> ImmutableWrapper<T>.getValue(thisRef: Any?, property: KProperty<*>) = value