package com.what3words.design.library.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SettingsVoice
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.what3words.design.library.ui.theme.W3WTheme
import com.what3words.design.library.ui.theme.surfaceVariationsColors

/**
 * A composable function that represents a search bar in the What3words design system.
 *
 * @param content A composable lambda which will be the content of the search bar.
 * @param onContentClick A lambda function that will be invoked when the content of the search bar is clicked.
 * @param modifier The modifier to be applied to the search bar.
 * @param layoutConfig The layout configuration for the search bar. Default is set by [W3WSearchBarDefaults.defaultLayoutConfig].
 * @param leadingActions A composable lambda which will be the leading actions of the search bar.
 * @param trailingActions A composable lambda which will be the trailing actions of the search bar.
 * @param cardColors The colors to be used for the card. Default is set by [CardDefaults.cardColors].
 */
@Composable
fun What3wordsSearchBar(
    content: @Composable RowScope.() -> Unit,
    onContentClick: () -> Unit,
    modifier: Modifier = Modifier,
    layoutConfig: W3WSearchBarDefaults.LayoutConfig = W3WSearchBarDefaults.defaultLayoutConfig(),
    leadingActions: @Composable RowScope.() -> Unit = {},
    trailingActions: (@Composable RowScope.() -> Unit)? = null,
    cardColors: CardColors = CardDefaults.elevatedCardColors(
        containerColor = MaterialTheme.surfaceVariationsColors.surfaceContainerLowest,
    ),
    cardElevation: CardElevation = CardDefaults.elevatedCardElevation()
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Max),
        shape = RoundedCornerShape(layoutConfig.cornerRadius),
        colors = cardColors,
        elevation = cardElevation
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = layoutConfig.paddingHorizontal,
                    vertical = layoutConfig.paddingVertical
                )
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (trailingActions != null) {
                trailingActions()
                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(layoutConfig.dividerWidth)
                        .background(MaterialTheme.colorScheme.outlineVariant)
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { onContentClick() }, verticalAlignment = Alignment.CenterVertically
            ) {
                content()
            }

            leadingActions()
        }
    }
}

/**
 * Object containing default configurations for W3WSearchBar composable.
 * It includes default settings for [LayoutConfig] which can be customized as needed.
 */
object W3WSearchBarDefaults {
    /**
     * Data class that holds layout configurations for the W3WSearchBar composable function.
     *
     * @property cornerRadius The corner radius of the search bar.
     * @property paddingHorizontal The horizontal padding of the search bar.
     * @property paddingVertical The vertical padding of the search bar.
     * @property dividerWidth The width of the divider in the search bar.
     */
    data class LayoutConfig(
        val cornerRadius: Dp,
        val paddingHorizontal: Dp,
        val paddingVertical: Dp,
        val dividerWidth: Dp
    )

    /**
     * Composable function that provides default layout configurations for the W3WSearchBar composable function.
     *
     * @param cornerRadius The corner radius of the search bar. Default is 16.dp.
     * @param paddingHorizontal The horizontal padding of the search bar. Default is 4.dp.
     * @param paddingVertical The vertical padding of the search bar. Default is 9.dp.
     * @param dividerWidth The width of the divider in the search bar. Default is 1.dp.
     * @return A LayoutConfig object with the provided layout configurations.
     */
    @Composable
    fun defaultLayoutConfig(
        cornerRadius: Dp = 16.dp,
        paddingHorizontal: Dp = 4.dp,
        paddingVertical: Dp = 9.dp,
        dividerWidth: Dp = 1.dp
    ): LayoutConfig {
        return LayoutConfig(
            cornerRadius = cornerRadius,
            paddingHorizontal = paddingHorizontal,
            paddingVertical = paddingVertical,
            dividerWidth = dividerWidth
        )
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Day/LTR/Full",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun A1() {
    W3WTheme {
        Surface {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                trailingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                leadingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Default.SettingsVoice,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Default.DocumentScanner,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                },
                content = {
                    Spacer(modifier = Modifier.size(8.dp))
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Search")
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Day/LTR/NoLeadingActions",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun A2() {
    W3WTheme {
        Surface {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                trailingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                content = {
                    Spacer(modifier = Modifier.size(8.dp))
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Search")
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Day/LTR/NoTrailingActions",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun A3() {
    W3WTheme {
        Surface {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                leadingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                content = {
                    Spacer(modifier = Modifier.size(8.dp))
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Search")
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Day/LTR/JustContent",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun A4() {
    W3WTheme {
        Surface {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                content = {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(text = "Search")
                    }
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Day/RTL/Full",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun A5() {
    W3WTheme {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Surface {
                What3wordsSearchBar(
                    modifier = Modifier
                        .padding(4.dp),
                    trailingActions = {
                        IconButton(
                            onClick = {
                                // Handle action
                            }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    },
                    leadingActions = {
                        IconButton(
                            onClick = {
                                // Handle action
                            }) {
                            Icon(
                                imageVector = Icons.Default.SettingsVoice,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                        }
                        IconButton(
                            onClick = {
                                // Handle action
                            }) {
                            Icon(
                                imageVector = Icons.Default.DocumentScanner,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                        }
                    },
                    content = {
                        Spacer(modifier = Modifier.size(8.dp))
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(text = "تنقيب")
                    },
                    onContentClick = {
                        // Handle action
                    }
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Night/LTR/Full",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun B1() {
    W3WTheme(useDarkTheme = true) {
        Surface {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                trailingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                leadingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Default.SettingsVoice,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Default.DocumentScanner,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        )
                    }
                },
                content = {
                    Spacer(modifier = Modifier.size(8.dp))
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Search")
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Night/LTR/NoLeadingActions",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun B2() {
    W3WTheme(useDarkTheme = true) {
        Surface {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                trailingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                content = {
                    Spacer(modifier = Modifier.size(8.dp))
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Search")
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Night/LTR/NoTrailingActions",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun B3() {
    W3WTheme(useDarkTheme = true) {
        Surface {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                leadingActions = {
                    IconButton(
                        onClick = {
                            // Handle action
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                content = {
                    Spacer(modifier = Modifier.size(8.dp))
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Search")
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Night/LTR/JustContent",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun B4() {
    W3WTheme(useDarkTheme = true) {
        Surface {
            What3wordsSearchBar(
                modifier = Modifier
                    .padding(4.dp),
                content = {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(text = "Search")
                    }
                },
                onContentClick = {
                    // Handle action
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    group = "SearchBar",
    name = "W3WTheme/Night/RTL/Full",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun B5() {
    W3WTheme(useDarkTheme = true) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Surface {
                What3wordsSearchBar(
                    modifier = Modifier
                        .padding(4.dp),
                    trailingActions = {
                        IconButton(
                            onClick = {
                                // Handle action
                            }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    },
                    leadingActions = {
                        IconButton(
                            onClick = {
                                // Handle action
                            }) {
                            Icon(
                                imageVector = Icons.Default.SettingsVoice,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                        }
                        IconButton(
                            onClick = {
                                // Handle action
                            }) {
                            Icon(
                                imageVector = Icons.Default.DocumentScanner,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                        }
                    },
                    content = {
                        Spacer(modifier = Modifier.size(8.dp))
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(text = "يبحث")
                    },
                    onContentClick = {
                        // Handle action
                    }
                )
            }
        }
    }
}