package com.what3words.design.library.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
     * This function returns the default colors for the Voice Animation.
     *
     * @return A Colors object with the default colors.
     */
    @Composable
    fun defaultColors(
        orbColors: Color = MaterialTheme.w3wColorScheme.brand,
        loadingIconColor: Color = MaterialTheme.w3wColorScheme.brand,
        idleIconColor: Color = Color.White
    ): Colors = Colors(
        orbColors = orbColors,
        loadingIconColor = loadingIconColor,
        idleIconColor = idleIconColor
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
 * @param state The current state of the Voice Recognition. It can be Idle, Active, or Loading.
 * @param inactiveOnClick The function to be called when the animation is clicked AND the state is Idle.
 * @param activeOnClick The function to be called when the animation is clicked AND the state is Active.
 */
@Composable
fun VoiceRecognitionAnimation(
    modifier: Modifier = Modifier,
    color: VoiceRecognitionAnimationDefaults.Colors = VoiceRecognitionAnimationDefaults.defaultColors(),
    state: VoiceRecognitionState,
    inactiveOnClick: (() -> Unit)? = null,
    activeOnClick: (() -> Unit)? = null
) {
    when (state) {
        is VoiceRecognitionState.Idle -> IdleVoiceAnimation(
            modifier = modifier,
            color = color,
            onClick = inactiveOnClick
        )

        is VoiceRecognitionState.Active -> ActiveVoiceAnimation(
            signalStrength = state.signalStrength,
            modifier = modifier,
            color = color,
            onClick = activeOnClick
        )

        is VoiceRecognitionState.Loading -> LoadingVoiceAnimation(
            modifier = modifier,
            color = color
        )
    }
}

@Composable
private fun IdleVoiceAnimation(
    modifier: Modifier = Modifier,
    color: VoiceRecognitionAnimationDefaults.Colors,
    onClick: (() -> Unit)? = null
) {
    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .aspectRatio(1f)
                .clip(CircleShape)
                .align(Alignment.Center)
                .background(color.orbColors)
                .clickable(enabled = onClick != null, onClick = { onClick?.invoke() })
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_voice_inactive),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(.5f)
                    .align(Alignment.Center),
                colorFilter = ColorFilter.tint(color.idleIconColor)
            )
        }
    }
}

@Composable
private fun ActiveVoiceAnimation(
    modifier: Modifier = Modifier,
    color: VoiceRecognitionAnimationDefaults.Colors,
    signalStrength: Float,
    onClick: (() -> Unit)? = null,
) {
    val scale = animateFloatAsState(
        signalStrength.coerceIn(0f, 1f),
        label = "orbScaleAnimation",
        animationSpec = tween(activeAnimationDurationMs)
    )
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                enabled = onClick != null,
                onClick = { onClick?.invoke() })
    )
    {
        Surface(
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale.value)
                .fillMaxSize(.33f),
            shape = CircleShape,
            color = color.orbColors.copy(alpha = 0.32f),
            content = {}
        )
        Surface(
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale.value)
                .fillMaxSize(.66f),
            shape = CircleShape,
            color = color.orbColors.copy(alpha = 0.16f),
            content = {}
        )
        Surface(
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale.value)
                .fillMaxSize(.99f),
            shape = CircleShape,
            color = color.orbColors.copy(alpha = 0.08f),
            content = {}
        )
        Image(
            painter = painterResource(id = R.drawable.ic_voice_active),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(.25f),
        )
    }
}


@Composable
private fun LoadingVoiceAnimation(
    modifier: Modifier = Modifier,
    color: VoiceRecognitionAnimationDefaults.Colors,
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
    Box(modifier = modifier.fillMaxSize()) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            dynamicProperties = dynamicProperties,
            modifier = Modifier
                .fillMaxSize(0.25f)
                .scale(1.35f) // to remove when we get a new lottie file
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun VoiceAnimationIdlePreview() {
    Column(
        modifier = Modifier
            .width(248.dp)
            .height(248.dp)
    ) {
        VoiceRecognitionAnimation(state = VoiceRecognitionState.Idle)
    }
}

@Preview
@Composable
fun VoiceAnimationLoadingPreview() {
    Column(
        modifier = Modifier
            .width(248.dp)
            .height(248.dp)
    ) {
        VoiceRecognitionAnimation(state = VoiceRecognitionState.Loading)
    }
}

@Preview
@Composable
fun VoiceAnimationActivePreview() {
    Column(
        modifier = Modifier
            .width(248.dp)
            .height(248.dp)
    ) {
        VoiceRecognitionAnimation(
            state = VoiceRecognitionState.Active(signalStrength = 0.2f)
        )
    }
}