package com.what3words.design.library.sample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.components.VoiceRecognitionAnimation
import com.what3words.design.library.ui.components.VoiceRecognitionState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun VoiceRecognitionAnimationScreen() {

    val state: MutableState<VoiceRecognitionState> =
        remember { mutableStateOf(VoiceRecognitionState.Idle) }

    val coroutineScope = rememberCoroutineScope()

    val job: MutableState<Job?> = remember {
        mutableStateOf(null)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        VoiceRecognitionAnimation(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            state = state.value,
            onClick = {}
        )

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                job.value?.cancel()
                state.value = VoiceRecognitionState.Idle
            }) {
                Text("Idle")
            }

            Button(onClick = {
                job.value?.cancel()
                job.value = coroutineScope.launch {
                    while (this.isActive) {
                        delay(300)
                        state.value =
                            VoiceRecognitionState.Active(Random.nextFloat().coerceIn(0f, 1f))
                    }
                }
            }) {
                Text("Active")
            }

            Button(onClick = {
                job.value?.cancel()
                state.value = VoiceRecognitionState.Loading
            }) {
                Text("Loading")
            }
        }
    }
}

@Preview
@Composable
fun VoiceRecognitionAnimationScreenPreview() {
    VoiceRecognitionAnimationScreen()
}