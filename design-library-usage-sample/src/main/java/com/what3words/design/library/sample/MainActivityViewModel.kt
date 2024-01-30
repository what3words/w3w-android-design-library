package com.what3words.design.library.sample

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivityViewModel : ViewModel() {
    enum class Theme {
        Material,
        What3words
    }

    enum class Colours {
        Day,
        Night
    }

    var selectedTheme = MutableStateFlow(Theme.Material)
    var selectedColours = MutableStateFlow(Colours.Day)
}