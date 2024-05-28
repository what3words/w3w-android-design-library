package com.what3words.design.library.sample.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.components.VoiceAnimation
import com.what3words.design.library.ui.components.VoiceAnimationState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun VoiceAnimationScreen() {
    val context = LocalContext.current
    val state: MutableState<VoiceAnimationState> =
        remember { mutableStateOf(VoiceAnimationState.Idle) }

    val coroutineScope = rememberCoroutineScope()

    val job: MutableState<Job?> = remember {
        mutableStateOf(null)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        VoiceAnimation(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .aspectRatio(1f)
                .align(Alignment.CenterHorizontally),
            state = state.value,
            activeOnClick = {
                Toast.makeText(context, "Active clicked", Toast.LENGTH_SHORT).show()
            },
            inactiveOnClick = {
                Toast.makeText(context, "Inactive clicked", Toast.LENGTH_SHORT).show()
            }
        )

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = {
                    job.value?.cancel()
                    state.value = VoiceAnimationState.Idle
                }) {
                    Text("Idle")
                }

                Button(onClick = {
                    job.value?.cancel()
                    state.value = VoiceAnimationState.Loading
                }) {
                    Text("Loading")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = {
                    job.value?.cancel()
                    state.value = VoiceAnimationState.Active(0f)
                }) {
                    Text("Active 0%")
                }

                Button(onClick = {
                    job.value?.cancel()
                    state.value = VoiceAnimationState.Active(0.5f)
                }) {
                    Text("Active 50%")
                }

                Button(onClick = {
                    job.value?.cancel()
                    state.value = VoiceAnimationState.Active(1f)
                }) {
                    Text("Active 100%")
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = {
                    job.value?.cancel()
                    job.value = coroutineScope.launch {
                        while (this.isActive) {
                            delay(200)
                            state.value =
                                VoiceAnimationState.Active(Random.nextFloat().coerceIn(0f, 1f))
                        }
                    }
                }) {
                    Text("Active Random")
                }
            }
        }

    }
}

@Preview
@Composable
fun VoiceAnimationScreenPreview() {
    VoiceAnimationScreen()
}