package com.what3words.design.library.ui.components

import android.util.Log
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieDynamicProperties
import com.airbnb.lottie.compose.rememberLottieDynamicProperty
import com.what3words.design.library.R
import com.what3words.design.library.ui.components.VoiceRecognitionAnimationDefaults.activeAnimationDurationMs
import com.what3words.design.library.ui.theme.w3wColorScheme

/**
 * This object contains default values used by the [VoiceRecognitionAnimation].
 */
object VoiceRecognitionAnimationDefaults {

    const val activeAnimationDurationMs = 200

    /**
     * A data class representing the colors used in the [VoiceRecognitionAnimation].
     *
     * @property orbColors The color of the orbs in [VoiceRecognitionState.Active] and the icon background color in [VoiceRecognitionState.Idle].
     * @property loadingIconColor The color of the loading icon in [VoiceRecognitionState.Loading].
     * @property idleIconColor The color of the idle icon in [VoiceRecognitionState.Idle].
     */
    data class Colors(
        val orbColors: Color,
        val loadingIconColor: Color,
        val idleIconColor: Color,
    )

    /**
     * A data class representing the sizes used in the [VoiceRecognitionAnimation].
     *
     * @property innerOrbSize The size of the inner orb.
     * @property middleOrbSize The size of the middle orb.
     * @property outerOrbSize The size of the outer orb.
     * @property iconSize The size of the icon.
     */
    data class Size(
        val innerOrbSize: Dp,
        val middleOrbSize: Dp,
        val outerOrbSize: Dp,
        val iconSize: Dp
    )

    /**
     * This function returns the default colors for the Voice Animation.
     *
     * @return A Colors object with the default colors.
     */
    @Composable
    fun defaultColors(): Colors = Colors(
        orbColors = MaterialTheme.w3wColorScheme.brand,
        loadingIconColor = MaterialTheme.w3wColorScheme.brand,
        idleIconColor = Color.White,
    )

    /**
     * This function returns the default sizes for the Voice Animation.
     *
     * @return A Size object with the default sizes.
     */
    @Composable
    fun defaultSize(): Size = Size(
        innerOrbSize = 124.dp,
        middleOrbSize = 186.dp,
        outerOrbSize = 248.dp,
        iconSize = 64.dp
    )
}

/**
 * This is a sealed interface that represents the state of the Voice Recognition.
 */
sealed interface VoiceRecognitionState {
    /**
     * Represents the Idle state of the Voice Recognition.
     * In this state, the Voice Recognition is not actively listening or loading.
     *
     * Use this state when waiting for the user to start the Voice Recognition process or
     * when the Voice Recognition process has the errors.
     */
    object Idle : VoiceRecognitionState

    /**
     * Represents the Active state of the Voice Recognition.
     * In this state, the Voice Recognition is actively listening.
     * @property signalStrength The strength of the signal being received by the Voice Recognition. It is a Float value between 0 and 1.
     */
    data class Active(val signalStrength: Float) : VoiceRecognitionState

    /**
     * Represents the Loading state of the Voice Recognition.
     * In this state, the Voice Recognition is processing the user's voice.
     */
    object Loading : VoiceRecognitionState
}

/**
 * This is a Composable function that represents the Voice Recognition Animation.
 *
 * Depending on the state of the Voice Recognition, it displays the corresponding animation:
 * - If the state is Idle, it displays the IdleVoiceAnimation.
 * - If the state is Active, it displays the ActiveVoiceAnimation.
 * - If the state is Loading, it displays the LoadingVoiceAnimation.
 *
 * @param modifier The modifier to be applied to the animation. Default is Modifier.
 * @param color The colors to be used in the animation. Default is the default colors defined in VoiceRecognitionAnimationDefaults.
 * @param size The sizes to be used in the animation. Default is the default sizes defined in VoiceRecognitionAnimationDefaults.
 * @param state The current state of the Voice Recognition. It can be Idle, Active, or Loading.
 * @param onClick The function to be called when the animation is clicked AND the state is Idle.
 */
@Composable
fun VoiceRecognitionAnimation(
    modifier: Modifier = Modifier,
    color: VoiceRecognitionAnimationDefaults.Colors = VoiceRecognitionAnimationDefaults.defaultColors(),
    size: VoiceRecognitionAnimationDefaults.Size = VoiceRecognitionAnimationDefaults.defaultSize(),
    state: VoiceRecognitionState,
    onClick: () -> Unit,
) {
    when (state) {
        is VoiceRecognitionState.Idle -> IdleVoiceAnimation(
            modifier = modifier,
            color = color,
            size = size,
            onClick = onClick
        )

        is VoiceRecognitionState.Active -> ActiveVoiceAnimation(
            signalStrength = state.signalStrength,
            modifier = modifier,
            color = color,
            size = size
        )

        is VoiceRecognitionState.Loading -> LoadingVoiceAnimation(
            modifier = modifier,
            color = color,
            size = size
        )
    }
}

@Composable
private fun IdleVoiceAnimation(
    modifier: Modifier = Modifier,
    color: VoiceRecognitionAnimationDefaults.Colors = VoiceRecognitionAnimationDefaults.defaultColors(),
    size: VoiceRecognitionAnimationDefaults.Size = VoiceRecognitionAnimationDefaults.defaultSize(),
    onClick: () -> Unit,
) {
    Box(modifier = modifier.size(size.outerOrbSize)) {
        Box(
            modifier = Modifier
                .size(size.innerOrbSize)
                .clip(CircleShape)
                .align(Alignment.Center)
                .background(color.orbColors)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_voice_inactive),
                contentDescription = null,
                modifier = Modifier
                    .size(size.iconSize)
                    .align(Alignment.Center)
                    .clickable { onClick() },
                colorFilter = ColorFilter.tint(color.idleIconColor)
            )
        }
    }
}

@Composable
private fun ActiveVoiceAnimation(
    modifier: Modifier = Modifier,
    color: VoiceRecognitionAnimationDefaults.Colors = VoiceRecognitionAnimationDefaults.defaultColors(),
    size: VoiceRecognitionAnimationDefaults.Size = VoiceRecognitionAnimationDefaults.defaultSize(),
    signalStrength: Float,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "infiniteOrbAnimation")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = signalStrength.coerceIn(0f, 1f),
        animationSpec = infiniteRepeatable(
            animation = tween(activeAnimationDurationMs),
            repeatMode = RepeatMode.Reverse
        ),
        label = "orbScaleAnimation"
    )
    Box(modifier = modifier.size(size.outerOrbSize)) {
        Surface(
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale)
                .size(size.innerOrbSize),
            shape = CircleShape,
            color = color.orbColors.copy(alpha = 0.32f),
            content = {}
        )
        Surface(
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale)
                .size(size.middleOrbSize),
            shape = CircleShape,
            color = color.orbColors.copy(alpha = 0.16f),
            content = {}
        )
        Surface(
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale)
                .size(size.outerOrbSize),
            shape = CircleShape,
            color = color.orbColors.copy(alpha = 0.08f),
            content = {}
        )
        Image(
            painter = painterResource(id = R.drawable.ic_voice_active),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(size.iconSize),
        )
    }
}


@Composable
private fun LoadingVoiceAnimation(
    modifier: Modifier = Modifier,
    color: VoiceRecognitionAnimationDefaults.Colors = VoiceRecognitionAnimationDefaults.defaultColors(),
    size: VoiceRecognitionAnimationDefaults.Size = VoiceRecognitionAnimationDefaults.defaultSize(),
) {
    val dynamicProperties = rememberLottieDynamicProperties(
        rememberLottieDynamicProperty(
            property = LottieProperty.COLOR_FILTER,
            value = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                color.loadingIconColor.hashCode(),
                BlendModeCompat.SRC_ATOP
            ),
            keyPath = arrayOf(
                "**"
            )
        )
    )
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.voice_loading_lottie))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
    Box(modifier = modifier.size(size.outerOrbSize)) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            dynamicProperties = dynamicProperties,
            modifier = Modifier
                .size(size.iconSize)
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun VoiceAnimationIdlePreview() {
    Column {
        VoiceRecognitionAnimation(state = VoiceRecognitionState.Idle, onClick = {})
    }
}

@Preview
@Composable
fun VoiceAnimationLoadingPreview() {
    Column {
        VoiceRecognitionAnimation(state = VoiceRecognitionState.Loading, onClick = {})
    }
}

@Preview
@Composable
fun VoiceAnimationActivePreview() {
    Column {
        VoiceRecognitionAnimation(
            state = VoiceRecognitionState.Active(signalStrength = 0.8f),
            onClick = {})
    }
}