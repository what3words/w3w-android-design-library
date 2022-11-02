package com.what3words.design.library.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.what3words.design.library.ui.theme.W3WTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            W3WTheme {
                MainScreen()
            }
        }
    }
}

