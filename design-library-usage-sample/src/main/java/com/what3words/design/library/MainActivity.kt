package com.what3words.design.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.what3words.androidwrapper.What3WordsV3
import com.what3words.design.library.ui.components.SuggestionItem
import com.what3words.design.library.ui.theme.Grey40
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.javawrapper.request.Coordinates
import com.what3words.javawrapper.response.Suggestion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = What3WordsV3("YOUR_API_KEY_HERE", this@MainActivity)
        setContent {
            W3WTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var suggestions by remember { mutableStateOf(emptyList<Suggestion>()) }
                    LaunchedEffect(key1 = true, block = {
                        suggestions = withContext(Dispatchers.IO) {
                            val res = api.autosuggest("index.home.r").focus(Coordinates(51.02,-1.23)).execute()
                            if (res.isSuccessful) res.suggestions else emptyList()
                        }
                    })
                    SuggestionList(suggestions)
                }
            }
        }
    }
}

@Composable
fun SuggestionList(suggestions: List<Suggestion>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(suggestions) {
            SuggestionItem(words = it.words, near = it.nearestPlace, distance = "${it.distanceToFocusKm}km", onClick = {})
            Divider(color = Grey40)
        }
    }
}