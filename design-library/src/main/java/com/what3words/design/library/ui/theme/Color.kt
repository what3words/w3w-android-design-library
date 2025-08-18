package com.what3words.design.library.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val colors_red_10 = Color(0xff410000)
val colors_blue_10 = Color(0xff001d31)
val colors_green_10 = Color(0xff002112)
val colors_yellow_10 = Color(0xff221b00)
val colors_coral_10 = Color(0xff3e0500)
val colors_orange_10 = Color(0xff370e00)
val colors_orange_20 = Color(0xff7e2c00)
val colors_orange_30 = Color(0xffce5217)
val colors_orange_40 = Color(0xffec692c)
val colors_orange_50 = Color(0xffff7332)
val colors_orange_60 = Color(0xffff7f43)
val colors_orange_70 = Color(0xffff8c5a)
val colors_orange_80 = Color(0xffffb598)
val colors_orange_90 = Color(0xffffdbce)
val colors_orange_95 = Color(0xffffede7)
val colors_orange_99 = Color(0xfffffbff)
val colors_purple_10 = Color(0xff330045)
val colors_pink_10 = Color(0xff3e001d)
val colors_pink_20 = Color(0xff650033)
val colors_pink_30 = Color(0xff8e004a)
val colors_pink_40 = Color(0xffb90063)
val colors_pink_50 = Color(0xffe3187c)
val colors_pink_60 = Color(0xffff4896)
val colors_pink_70 = Color(0xffff84af)
val colors_pink_80 = Color(0xffffb1c8)
val colors_pink_90 = Color(0xffffd9e2)
val colors_pink_95 = Color(0xffffecf0)
val colors_pink_99 = Color(0xfffffbff)
val colors_grey_0 = Color(0xff000000)
val colors_grey_4 = Color(0xff0c0e11)
val colors_grey_6 = Color(0xff111416)
val colors_grey_8 = Color(0xff181c20)
val colors_grey_10 = Color(0xff1a1c1e)
val colors_grey_12 = Color(0xff1e2022)
val colors_grey_17 = Color(0xff282a2d)
val colors_grey_20 = Color(0xff2e3133)
val colors_grey_21 = Color(0xff2d3135)
val colors_grey_22 = Color(0xff333537)
val colors_grey_23 = Color(0xff38383a)
val colors_grey_24 = Color(0xff37393c)
val colors_grey_30 = Color(0xff454749)
val colors_grey_32 = Color(0xff43474b)
val colors_grey_40 = Color(0xff5d5e61)
val colors_grey_42 = Color(0xff5b5f63)
val colors_grey_44 = Color(0xff696B6D)
val colors_grey_50 = Color(0xff75777a)
val colors_grey_52 = Color(0xff73777c)
val colors_grey_60 = Color(0xff8f9193)
val colors_grey_62 = Color(0xff8d9196)
val colors_grey_70 = Color(0xffaaabae)
val colors_grey_72 = Color(0xffa8abb0)
val colors_grey_80 = Color(0xffc5c6c9)
val colors_grey_82 = Color(0xffc3c7cc)
val colors_grey_87 = Color(0xffd9dadd)
val colors_grey_90 = Color(0xffe2e2e5)
val colors_grey_91 = Color(0xffdfe3e8)
val colors_grey_92 = Color(0xffe7e8eb)
val colors_grey_93 = Color(0xffedeef0)
val colors_grey_95 = Color(0xfff0f0f3)
val colors_grey_96 = Color(0xfff3f3f6)
val colors_grey_97 = Color(0xffeef1f6)
val colors_grey_98 = Color(0xfff9f9fc)
val colors_grey_99 = Color(0xfffcfcff)
val colors_grey_100 = Color(0xffffffff)
val colors_purple_20 = Color(0xff53006f)
val colors_purple_30 = Color(0xff75049a)
val colors_purple_40 = Color(0xff8b4ca1)
val colors_purple_50 = Color(0xffac4bd0)
val colors_purple_60 = Color(0xffc967ec)
val colors_purple_70 = Color(0xffe188ff)
val colors_purple_80 = Color(0xffeeb1ff)
val colors_purple_90 = Color(0xfffad7ff)
val colors_purple_95 = Color(0xffffebff)
val colors_purple_99 = Color(0xfffffbff)
val colors_coral_20 = Color(0xff640d00)
val colors_coral_30 = Color(0xffca4f36)
val colors_coral_40 = Color(0xfff26c50)
val colors_coral_50 = Color(0xfff2826a)
val colors_coral_60 = Color(0xfffc927c)
val colors_coral_70 = Color(0xffff9a85)
val colors_coral_80 = Color(0xffffb4a4)
val colors_coral_90 = Color(0xffffddd6)
val colors_coral_95 = Color(0xffffede9)
val colors_coral_99 = Color(0xfffffbff)
val colors_yellow_20 = Color(0xff372700)
val colors_yellow_30 = Color(0xff8b6b16)
val colors_yellow_40 = Color(0xffcda700)
val colors_yellow_50 = Color(0xfff8c03c)
val colors_yellow_60 = Color(0xffffcf5d)
val colors_yellow_70 = Color(0xffffd36c)
val colors_yellow_80 = Color(0xffffe080)
val colors_yellow_82 = Color(0xffffdea0)
val colors_yellow_90 = Color(0xffffeeb9)
val colors_yellow_95 = Color(0xffffefd5)
val colors_yellow_99 = Color(0xfffffbff)
val colors_green_20 = Color(0xff003822)
val colors_green_30 = Color(0xff006c45)
val colors_green_40 = Color(0xff008857)
val colors_green_50 = Color(0xff53c18a)
val colors_green_60 = Color(0xff6ecb9c)
val colors_green_70 = Color(0xff88d5ad)
val colors_green_80 = Color(0xffa2dfbd)
val colors_green_90 = Color(0xffb1efca)
val colors_green_95 = Color(0xffc0ffd7)
val colors_green_99 = Color(0xfff5fff5)
val colors_blue_20 = Color(0xff0a3049)
val colors_blue_24 = Color(0xff054261)
val colors_blue_30 = Color(0xff005379)
val colors_blue_40 = Color(0xff006397)
val colors_blue_50 = Color(0xff187db9)
val colors_blue_52 = Color(0xff1c86cc)
val colors_blue_60 = Color(0xff4097d5)
val colors_blue_62 = Color(0xff14b5ff)
val colors_blue_64 = Color(0xff00afff)
val colors_blue_70 = Color(0xff60b2f2)
val colors_blue_72 = Color(0xff8dd4eb)
val colors_blue_74 = Color(0xff98d5e5)
val colors_blue_76 = Color(0xffb6dcf5)
val colors_blue_80 = Color(0xffc2e1eb)
val colors_blue_90 = Color(0xffdbeffa)
val colors_blue_95 = Color(0xffe3f4fd)
val colors_blue_99 = Color(0xfffcfcff)
val colors_red_20 = Color(0xff690001)
val colors_red_30 = Color(0xff930002)
val colors_red_40 = Color(0xffc00004)
val colors_red_50 = Color(0xffe11f26)
val colors_red_60 = Color(0xffff5543)
val colors_red_70 = Color(0xffff8a79)
val colors_red_80 = Color(0xffffb4a9)
val colors_red_90 = Color(0xffffcac2)
val colors_red_95 = Color(0xffffedea)
val colors_red_99 = Color(0xfffffbff)

val M3_colors_purple_10 = Color(0xff22005d)
val M3_colors_purple_20 = Color(0xff381e72)
val M3_colors_purple_30 = Color(0xff4f378a)
val M3_colors_purple_40 = Color(0xff6750a4)
val M3_colors_purple_50 = Color(0xff8069bf)
val M3_colors_purple_60 = Color(0xff9a83db)
val M3_colors_purple_70 = Color(0xffb69df8)
val M3_colors_purple_80 = Color(0xffcfbcff)
val M3_colors_purple_90 = Color(0xffe9ddff)
val M3_colors_purple_95 = Color(0xfff6eeff)
val M3_colors_purple_99 = Color(0xfffffbfe)
val M3_colors_slate_10 = Color(0xff1e192b)
val M3_colors_taupe_10 = Color(0xff31111d)
val M3_colors_taupe_20 = Color(0xff492532)
val M3_colors_taupe_30 = Color(0xff633b48)
val M3_colors_taupe_40 = Color(0xff7d5260)
val M3_colors_taupe_50 = Color(0xff986977)
val M3_colors_taupe_60 = Color(0xffb58392)
val M3_colors_taupe_70 = Color(0xffd29dac)
val M3_colors_taupe_80 = Color(0xffefb8c8)
val M3_colors_taupe_90 = Color(0xffffd8e4)
val M3_colors_taupe_95 = Color(0xffffecf1)
val M3_colors_taupe_99 = Color(0xfffffbfa)
val M3_colors_slate_20 = Color(0xff332d41)
val M3_colors_slate_30 = Color(0xff4a4458)
val M3_colors_slate_40 = Color(0xff625b71)
val M3_colors_slate_50 = Color(0xff7b748a)
val M3_colors_slate_60 = Color(0xff958da4)
val M3_colors_slate_70 = Color(0xffb0a7c0)
val M3_colors_slate_80 = Color(0xffcbc2db)
val M3_colors_slate_90 = Color(0xffe8def8)
val M3_colors_slate_95 = Color(0xfff6eeff)
val M3_colors_slate_99 = Color(0xfffffbff)
val M3_colors_red_10 = Color(0xff410002)
val M3_colors_red_20 = Color(0xff690005)
val M3_colors_red_30 = Color(0xff93000a)
val M3_colors_red_40 = Color(0xffba1a1a)
val M3_colors_red_50 = Color(0xffde3730)
val M3_colors_red_60 = Color(0xffff5449)
val M3_colors_red_70 = Color(0xffff897d)
val M3_colors_red_80 = Color(0xffffb4ab)
val M3_colors_red_90 = Color(0xffffdad6)
val M3_colors_red_95 = Color(0xffffedea)
val M3_colors_red_99 = Color(0xfffffbff)
val M3_colors_green_10 = Color(0xff002112)
val M3_colors_green_20 = Color(0xff003822)
val M3_colors_green_30 = Color(0xff006c45)
val M3_colors_green_40 = Color(0xff008857)
val M3_colors_green_50 = Color(0xff53c18a)
val M3_colors_green_60 = Color(0xff6ecb9c)
val M3_colors_green_70 = Color(0xff88d5ad)
val M3_colors_green_80 = Color(0xffa2dfbd)
val M3_colors_green_90 = Color(0xff8bf8bd)
val M3_colors_green_95 = Color(0xffc0ffd7)
val M3_colors_green_99 = Color(0xfff5fff5)
val M3_colors_yellow_10 = Color(0xff221b00)
val M3_colors_yellow_20 = Color(0xff322d18)
val M3_colors_yellow_30 = Color(0xff7c6e36)
val M3_colors_yellow_40 = Color(0xffc6af54)
val M3_colors_yellow_50 = Color(0xfffde16d)
val M3_colors_yellow_60 = Color(0xfffbe27c)
val M3_colors_yellow_70 = Color(0xffffe88a)
val M3_colors_yellow_80 = Color(0xffffec9d)
val M3_colors_yellow_90 = Color(0xfffff1b4)
val M3_colors_yellow_95 = Color(0xfffff1b4)
val M3_colors_yellow_99 = Color(0xfffffbff)
val M3_colors_neutral_core_0 = Color(0xff000000)
val M3_colors_neutral_core_10 = Color(0xff1d1b20)
val M3_colors_neutral_core_20 = Color(0xff322f35)
val M3_colors_neutral_core_30 = Color(0xff48464c)
val M3_colors_neutral_core_40 = Color(0xff605d64)
val M3_colors_neutral_core_50 = Color(0xff79767d)
val M3_colors_neutral_core_60 = Color(0xff938f96)
val M3_colors_neutral_core_70 = Color(0xffaea9b1)
val M3_colors_neutral_core_80 = Color(0xffcac5cd)
val M3_colors_neutral_core_90 = Color(0xffe6e0e9)
val M3_colors_neutral_core_95 = Color(0xfff5eff7)
val M3_colors_neutral_core_99 = Color(0xfffffbff)
val M3_colors_neutral_core_100 = Color(0xffffffff)
val M3_colors_neutral_extended_4 = Color(0xff0f0d13)
val M3_colors_neutral_extended_6 = Color(0xff141218)
val M3_colors_neutral_extended_12 = Color(0xff211f26)
val M3_colors_neutral_extended_17 = Color(0xff2b2930)
val M3_colors_neutral_extended_22 = Color(0xff36343b)
val M3_colors_neutral_extended_24 = Color(0xff3b383e)
val M3_colors_neutral_extended_87 = Color(0xffded8e1)
val M3_colors_neutral_extended_92 = Color(0xffece6f0)
val M3_colors_neutral_extended_93 = Color(0xfff3edf7)
val M3_colors_neutral_extended_94 = Color(0xfff5eefa)
val M3_colors_neutral_extended_96 = Color(0xfff7f2fa)
val M3_colors_neutral_variants_8 = Color(0xff1d1a22)
val M3_colors_neutral_variants_21 = Color(0xff322f37)
val M3_colors_neutral_variants_32 = Color(0xff49454f)
val M3_colors_neutral_variants_42 = Color(0xff605d66)
val M3_colors_neutral_variants_52 = Color(0xff79747e)
val M3_colors_neutral_variants_62 = Color(0xff938f99)
val M3_colors_neutral_variants_72 = Color(0xffaea9b4)
val M3_colors_neutral_variants_82 = Color(0xffcac4d0)
val M3_colors_neutral_variants_91 = Color(0xffe7e0ec)
val M3_colors_neutral_variants_97 = Color(0xfff5eefa)
val M3_colors_neutral_variants_98 = Color(0xfffffbfe)

/**
 * Defines the custom color palette for What3words, extending the MaterialTheme color scheme.
 * This includes both light and dark theme colors and additional semantic colors for specific UI components.
 * These colors can be overridden in specific parts of the app using local composition.
 */

// Primary semantic colors
val colors_primary_core_primary_light_m3: Color = M3_colors_purple_40
val colors_primary_core_primary_dark_m3 = M3_colors_purple_80
val colors_primary_core_primary_light_w3w = colors_blue_50
val colors_primary_core_primary_dark_w3w = colors_blue_72
val colors_primary_core_on_primary_light_m3 = M3_colors_neutral_core_100
val colors_primary_core_on_primary_dark_m3 = M3_colors_purple_20
val colors_primary_core_on_primary_light_w3w = colors_grey_100
val colors_primary_core_on_primary_dark_w3w = colors_blue_20
val colors_primary_core_primary_container_light_m3 = M3_colors_purple_90
val colors_primary_core_primary_container_dark_m3 = M3_colors_purple_30
val colors_primary_core_primary_container_light_w3w = colors_blue_20
val colors_primary_core_primary_container_dark_w3w = colors_blue_30
val colors_primary_core_on_primary_container_light_m3 = M3_colors_purple_10
val colors_primary_core_on_primary_container_dark_m3 = M3_colors_purple_90
val colors_primary_core_on_primary_container_light_w3w = colors_blue_99
val colors_primary_core_on_primary_container_dark_w3w = colors_blue_99
val colors_primary_core_inverse_primary_light_m3 = M3_colors_purple_80
val colors_primary_core_inverse_primary_dark_m3 = M3_colors_purple_40
val colors_primary_core_inverse_primary_light_w3w = colors_blue_80
val colors_primary_core_inverse_primary_dark_w3w = colors_blue_30

// Secondary semantic colors
val colors_secondary_core_secondary_light_m3 = M3_colors_slate_40
val colors_secondary_core_secondary_dark_m3 = M3_colors_slate_80
val colors_secondary_core_secondary_light_w3w = colors_blue_40
val colors_secondary_core_secondary_dark_w3w = colors_blue_50
val colors_secondary_core_on_secondary_light_m3 = M3_colors_neutral_core_100
val colors_secondary_core_on_secondary_dark_m3 = M3_colors_slate_20
val colors_secondary_core_on_secondary_light_w3w = colors_grey_100
val colors_secondary_core_on_secondary_dark_w3w = colors_blue_90
val colors_secondary_core_secondary_container_light_m3 = M3_colors_slate_90
val colors_secondary_core_secondary_container_dark_m3 = M3_colors_slate_30
val colors_secondary_core_secondary_container_light_w3w = colors_blue_90
val colors_secondary_core_secondary_container_dark_w3w = colors_blue_40
val colors_secondary_core_on_secondary_container_light_m3 = M3_colors_slate_10
val colors_secondary_core_on_secondary_container_dark_m3 = M3_colors_slate_90
val colors_secondary_core_on_secondary_container_light_w3w = colors_blue_20
val colors_secondary_core_on_secondary_container_dark_w3w = colors_blue_99

// brand colors
val colors_brand_base_brand_light_m3 = M3_colors_green_50
val colors_brand_base_brand_dark_m3 = M3_colors_green_50
val colors_brand_base_brand_light_w3w = colors_red_50
val colors_brand_base_brand_dark_w3w = colors_red_50
val colors_brand_base_brand_blue_light_m3 = M3_colors_green_50
val colors_brand_base_brand_blue_dark_m3 = M3_colors_green_50
val colors_brand_base_brand_blue_light_w3w = colors_blue_20
val colors_brand_base_brand_blue_dark_w3w = colors_blue_20
val colors_brand_base_on_brand_light_m3 = M3_colors_neutral_core_100
val colors_brand_base_on_brand_dark_m3 = M3_colors_green_20
val colors_brand_base_on_brand_light_w3w = colors_red_99
val colors_brand_base_on_brand_dark_w3w = colors_red_99
val colors_brand_base_brand_container_light_m3 = M3_colors_green_90
val colors_brand_base_brand_container_dark_m3 = M3_colors_green_20
val colors_brand_base_brand_container_light_w3w = colors_red_95
val colors_brand_base_brand_container_dark_w3w = colors_red_30
val colors_brand_base_on_brand_container_light_m3 = M3_colors_green_10
val colors_brand_base_on_brand_container_dark_m3 = M3_colors_green_90
val colors_brand_base_on_brand_container_light_w3w = colors_red_30
val colors_brand_base_on_brand_container_dark_w3w = colors_red_90

// brand custom colors
val colors_brand_custom_yellow_light_m3 = colors_yellow_50
val colors_brand_custom_yellow_dark_m3 = colors_yellow_40
val colors_brand_custom_yellow_light_w3w = colors_yellow_50
val colors_brand_custom_yellow_dark_w3w = colors_yellow_40
val colors_brand_custom_orange_light_m3 = colors_orange_50
val colors_brand_custom_orange_dark_m3 = colors_orange_60
val colors_brand_custom_orange_light_w3w = colors_orange_50
val colors_brand_custom_orange_dark_w3w = colors_orange_60
val colors_brand_custom_coral_light_m3 = colors_coral_50
val colors_brand_custom_coral_dark_m3 = colors_coral_60
val colors_brand_custom_coral_light_w3w = colors_coral_50
val colors_brand_custom_coral_dark_w3w = colors_coral_60
val colors_brand_custom_pink_light_m3 = colors_pink_40
val colors_brand_custom_pink_dark_m3 = colors_pink_50
val colors_brand_custom_pink_light_w3w = colors_pink_40
val colors_brand_custom_pink_dark_w3w = colors_pink_50
val colors_brand_custom_purple_light_m3 = colors_purple_40
val colors_brand_custom_purple_dark_m3 = colors_purple_50
val colors_brand_custom_purple_light_w3w = colors_purple_40
val colors_brand_custom_purple_dark_w3w = colors_purple_50
val colors_brand_custom_green_light_m3 = colors_green_50
val colors_brand_custom_green_dark_m3 = colors_green_60
val colors_brand_custom_green_light_w3w = colors_green_50
val colors_brand_custom_green_dark_w3w = colors_green_60
val colors_brand_custom_powder_blue_light_m3 = colors_blue_76
val colors_brand_custom_powder_blue_dark_m3 = colors_blue_72
val colors_brand_custom_powder_blue_light_w3w = colors_blue_76
val colors_brand_custom_powder_blue_dark_w3w = colors_blue_72
val colors_brand_custom_sky_blue_light_m3 = colors_blue_62
val colors_brand_custom_sky_blue_dark_m3 = colors_blue_64
val colors_brand_custom_sky_blue_light_w3w = colors_blue_62
val colors_brand_custom_sky_blue_dark_w3w = colors_blue_64
val colors_brand_custom_blue_light_m3 = colors_blue_52
val colors_brand_custom_blue_dark_m3 = colors_blue_60
val colors_brand_custom_blue_light_w3w = colors_blue_52
val colors_brand_custom_blue_dark_w3w = colors_blue_60

// error colors
val states_error_error_light_m3 = M3_colors_red_30
val states_error_error_dark_m3 = M3_colors_red_90
val states_error_error_light_w3w = colors_coral_40
val states_error_error_dark_w3w = colors_coral_40
val states_error_on_error_light_m3 = M3_colors_neutral_core_100
val states_error_on_error_dark_m3 = M3_colors_red_10
val states_error_on_error_light_w3w = colors_grey_100
val states_error_on_error_dark_w3w = colors_coral_99
val states_error_error_container_light_m3 = M3_colors_red_95
val states_error_error_container_dark_m3 = M3_colors_red_30
val states_error_error_container_light_w3w = colors_coral_95
val states_error_error_container_dark_w3w = colors_coral_50
val states_error_on_error_container_light_m3 = M3_colors_red_30
val states_error_on_error_container_dark_m3 = M3_colors_red_90
val states_error_on_error_container_light_w3w = colors_coral_20
val states_error_on_error_container_dark_w3w = colors_coral_95

// warning colors
val states_warning_warning_light_m3 = M3_colors_yellow_40
val states_warning_warning_dark_m3 = M3_colors_yellow_80
val states_warning_warning_light_w3w = colors_yellow_60
val states_warning_warning_dark_w3w = colors_yellow_50
val states_warning_on_warning_light_m3 = M3_colors_yellow_95
val states_warning_on_warning_dark_m3 = M3_colors_yellow_20
val states_warning_on_warning_light_w3w = colors_yellow_20
val states_warning_on_warning_dark_w3w = colors_yellow_20
val states_warning_warning_container_light_m3 = M3_colors_yellow_95
val states_warning_warning_container_dark_m3 = M3_colors_yellow_30
val states_warning_warning_container_light_w3w = colors_yellow_90
val states_warning_warning_container_dark_w3w = colors_yellow_30
val states_warning_on_warning_container_light_m3 = M3_colors_yellow_20
val states_warning_on_warning_container_dark_m3 = M3_colors_yellow_90
val states_warning_on_warning_container_light_w3w = colors_yellow_20
val states_warning_on_warning_container_dark_w3w = colors_yellow_90

// success colors
val states_success_success_light_m3 = M3_colors_green_50
val states_success_success_dark_m3 = M3_colors_green_60
val states_success_success_light_w3w = colors_green_50
val states_success_success_dark_w3w = colors_green_60
val states_success_on_success_light_m3 = M3_colors_neutral_core_100
val states_success_on_success_dark_m3 = M3_colors_green_20
val states_success_on_success_light_w3w = colors_grey_100
val states_success_on_success_dark_w3w = colors_green_30
val states_success_success_container_light_m3 = M3_colors_green_99
val states_success_success_container_dark_m3 = M3_colors_green_30
val states_success_success_container_light_w3w = colors_green_99
val states_success_success_container_dark_w3w = colors_green_30
val states_success_on_success_container_light_m3 = M3_colors_green_20
val states_success_on_success_container_dark_m3 = M3_colors_green_80
val states_success_on_success_container_light_w3w = colors_green_20
val states_success_on_success_container_dark_w3w = colors_green_80

// surfaces
val surfaces_surface_dim_light_m3 = M3_colors_neutral_extended_87
val surfaces_surface_dim_dark_m3 = M3_colors_neutral_extended_6
val surfaces_surface_dim_light_w3w = colors_grey_87
val surfaces_surface_dim_dark_w3w = colors_grey_6
val surfaces_surface_light_m3 = M3_colors_neutral_variants_98
val surfaces_surface_dark_m3 = M3_colors_neutral_extended_6
val surfaces_surface_light_w3w = colors_grey_98
val surfaces_surface_dark_w3w = colors_grey_6
val surfaces_surface_bright_light_m3 = M3_colors_neutral_core_99
val surfaces_surface_bright_dark_m3 = M3_colors_neutral_extended_24
val surfaces_surface_bright_light_w3w = colors_grey_99
val surfaces_surface_bright_dark_w3w = colors_grey_24
val surfaces_surface_variant_light_m3 = M3_colors_neutral_variants_91
val surfaces_surface_variant_dark_m3 = M3_colors_neutral_variants_32
val surfaces_surface_variant_light_w3w = colors_grey_91
val surfaces_surface_variant_dark_w3w = colors_grey_32
val surfaces_surface_container_lowest_light_m3 = M3_colors_neutral_core_100
val surfaces_surface_container_lowest_dark_m3 = M3_colors_neutral_extended_4
val surfaces_surface_container_lowest_light_w3w = colors_grey_100
val surfaces_surface_container_lowest_dark_w3w = colors_grey_8
val surfaces_surface_container_low_light_m3 = M3_colors_neutral_extended_96
val surfaces_surface_container_low_dark_m3 = M3_colors_neutral_core_10
val surfaces_surface_container_low_light_w3w = colors_grey_96
val surfaces_surface_container_low_dark_w3w = colors_grey_10
val surfaces_surface_container_light_m3 = M3_colors_neutral_extended_93
val surfaces_surface_container_dark_m3 = M3_colors_neutral_extended_12
val surfaces_surface_container_light_w3w = colors_grey_93
val surfaces_surface_container_dark_w3w = colors_grey_12
val surfaces_surface_container_high_light_m3 = M3_colors_neutral_extended_92
val surfaces_surface_container_high_dark_m3 = M3_colors_neutral_extended_17
val surfaces_surface_container_high_light_w3w = colors_grey_92
val surfaces_surface_container_high_dark_w3w = colors_grey_17
val surfaces_surface_container_highest_light_m3 = M3_colors_neutral_core_90
val surfaces_surface_container_highest_dark_m3 = M3_colors_neutral_extended_22
val surfaces_surface_container_highest_light_w3w = colors_grey_90
val surfaces_surface_container_highest_dark_w3w = colors_grey_22
val surfaces_on_surface_light_m3 = M3_colors_neutral_core_10
val surfaces_on_surface_dark_m3 = M3_colors_neutral_core_90
val surfaces_on_surface_light_w3w = colors_grey_10
val surfaces_on_surface_dark_w3w = colors_grey_100
val surfaces_on_surface_variant_light_m3 = M3_colors_neutral_variants_32
val surfaces_on_surface_variant_dark_m3 = M3_colors_neutral_variants_82
val surfaces_on_surface_variant_light_w3w = colors_grey_32
val surfaces_on_surface_variant_dark_w3w = colors_grey_82
val surfaces_on_surface_white_light_m3 = M3_colors_neutral_variants_98
val surfaces_on_surface_white_dark_m3 = M3_colors_neutral_variants_98
val surfaces_on_surface_white_light_w3w = colors_grey_98
val surfaces_on_surface_white_dark_w3w = colors_grey_98
val surfaces_on_surface_black_light_m3 = M3_colors_neutral_extended_6
val surfaces_on_surface_black_dark_m3 = M3_colors_neutral_extended_6
val surfaces_on_surface_black_light_w3w = colors_grey_6
val surfaces_on_surface_black_dark_w3w = colors_grey_6
val surfaces_inverse_surface_light_m3 = M3_colors_neutral_extended_6
val surfaces_inverse_surface_dark_m3 = M3_colors_neutral_variants_98
val surfaces_inverse_surface_light_w3w = colors_grey_6
val surfaces_inverse_surface_dark_w3w = colors_grey_98
val surfaces_inverse_surface_variant_light_m3 = M3_colors_neutral_variants_32
val surfaces_inverse_surface_variant_dark_m3 = M3_colors_neutral_variants_98
val surfaces_inverse_surface_variant_light_w3w = colors_grey_32
val surfaces_inverse_surface_variant_dark_w3w = colors_grey_98
val surfaces_inverse_on_surface_light_m3 = M3_colors_neutral_core_90
val surfaces_inverse_on_surface_dark_m3 = M3_colors_neutral_core_10
val surfaces_inverse_on_surface_light_w3w = colors_grey_100
val surfaces_inverse_on_surface_dark_w3w = colors_grey_10

// outline colors
val outlines_outline_light_m3 = M3_colors_neutral_variants_52
val outlines_outline_dark_m3 = M3_colors_neutral_variants_62
val outlines_outline_light_w3w = colors_grey_52
val outlines_outline_dark_w3w = colors_grey_62
val outlines_outline_med_light_m3 = M3_colors_neutral_variants_82
val outlines_outline_med_dark_m3 = M3_colors_neutral_variants_62
val outlines_outline_med_light_w3w = colors_grey_70
val outlines_outline_med_dark_w3w = colors_grey_60
val outlines_outline_low_light_m3 =  M3_colors_neutral_variants_82
val outlines_outline_low_dark_m3 =  M3_colors_neutral_variants_52
val outlines_outline_low_light_w3w = colors_grey_80
val outlines_outline_low_dark_w3w = colors_grey_50
val outlines_outline_variant_light_m3 = M3_colors_neutral_variants_82
val outlines_outline_variant_dark_m3 = M3_colors_neutral_variants_32
val outlines_outline_variant_light_w3w = colors_grey_82
val outlines_outline_variant_dark_w3w = colors_grey_32

// backgrounds
val backgrounds_background_light_m3 = M3_colors_purple_99
val backgrounds_background_dark_m3 = M3_colors_neutral_core_10
val backgrounds_background_light_w3w = colors_grey_99
val backgrounds_background_dark_w3w = colors_grey_0
val backgrounds_on_background_light_m3 = M3_colors_neutral_core_10
val backgrounds_on_background_dark_m3 = M3_colors_neutral_core_90
val backgrounds_on_background_light_w3w = colors_grey_10
val backgrounds_on_background_dark_w3w = colors_grey_90

// scrim
val scrim_scrim_light_m3 = M3_colors_neutral_core_0
val scrim_scrim_dark_m3 = M3_colors_neutral_core_0
val scrim_scrim_light_w3w = colors_grey_0
val scrim_scrim_dark_w3w = colors_grey_0

// shadow
val shadow_shadow_light_m3 = M3_colors_neutral_core_0
val shadow_shadow_dark_m3 = M3_colors_neutral_core_0
val shadow_shadow_light_w3w = colors_grey_0
val shadow_shadow_dark_w3w = colors_grey_0

// grid, on figma they don't have a primitive and Hex is attributed directly so is alpha, waiting for design team to
val grid_satellite_light_m3 = Color(0x29ffffff)
val grid_satellite_dark_m3 = Color(0x3dffffff)
val grid_satellite_light_w3w = Color(0x29ffffff)
val grid_satellite_dark_w3w = Color(0x3dffffff)
val grid_cartography_light_m3 = Color(0x3d000000)
val grid_cartography_dark_m3 = Color(0x3d000000)
val grid_cartography_light_w3w = Color(0x29697f8d)
val grid_cartography_dark_w3w = Color(0x29ffffff)

/**
 * Defines a custom color scheme for What3words using the defined colors for light themes.
 */
internal val w3wLightColors = lightColorScheme(
    primary = colors_primary_core_primary_light_w3w,
    onPrimary = colors_primary_core_on_primary_light_w3w,
    primaryContainer = colors_primary_core_primary_container_light_w3w,
    onPrimaryContainer = colors_primary_core_on_primary_container_light_w3w,
    secondary = colors_secondary_core_secondary_light_w3w,
    onSecondary = colors_secondary_core_on_secondary_light_w3w,
    secondaryContainer = colors_secondary_core_secondary_container_light_w3w,
    onSecondaryContainer = colors_secondary_core_on_secondary_container_light_w3w,
    error = states_error_error_light_w3w,
    errorContainer = states_error_error_container_light_w3w,
    onError = states_error_on_error_light_w3w,
    onErrorContainer = states_error_on_error_container_light_w3w,
    background = backgrounds_background_light_w3w,
    onBackground = backgrounds_on_background_light_w3w,
    surface = surfaces_surface_light_w3w,
    onSurface = surfaces_on_surface_light_w3w,
    surfaceVariant = surfaces_surface_variant_light_w3w,
    onSurfaceVariant = surfaces_on_surface_variant_light_w3w,
    outline = outlines_outline_light_w3w,
    inverseOnSurface = surfaces_inverse_on_surface_light_w3w,
    inverseSurface = surfaces_inverse_surface_light_w3w,
    inversePrimary = colors_primary_core_inverse_primary_light_w3w,
    outlineVariant = outlines_outline_variant_light_w3w,
    scrim = scrim_scrim_light_w3w,
    surfaceBright = surfaces_surface_bright_light_w3w,
    surfaceDim = surfaces_surface_dim_light_w3w,
    surfaceContainer = surfaces_surface_container_light_w3w,
    surfaceContainerHigh = surfaces_surface_container_high_light_w3w,
    surfaceContainerLow = surfaces_surface_container_low_light_w3w,
    surfaceContainerHighest = surfaces_surface_container_highest_light_w3w,
    surfaceContainerLowest = surfaces_surface_container_lowest_light_w3w
)

/**
 * Defines a custom color scheme for What3words using the defined colors for dark themes.
 */
internal val w3wDarkColors = darkColorScheme(
    primary = colors_primary_core_primary_dark_w3w,
    onPrimary = colors_primary_core_on_primary_dark_w3w,
    primaryContainer = colors_primary_core_primary_container_dark_w3w,
    onPrimaryContainer = colors_primary_core_on_primary_container_dark_w3w,
    secondary = colors_secondary_core_secondary_dark_w3w,
    onSecondary = colors_secondary_core_on_secondary_dark_w3w,
    secondaryContainer = colors_secondary_core_secondary_container_dark_w3w,
    onSecondaryContainer = colors_secondary_core_on_secondary_container_dark_w3w,
    error = states_error_error_dark_w3w,
    errorContainer = states_error_error_container_dark_w3w,
    onError = states_error_on_error_dark_w3w,
    onErrorContainer = states_error_on_error_container_dark_w3w,
    background = backgrounds_background_dark_w3w,
    onBackground = backgrounds_on_background_dark_w3w,
    surface = surfaces_surface_dark_w3w,
    onSurface = surfaces_on_surface_dark_w3w,
    surfaceVariant = surfaces_surface_variant_dark_w3w,
    onSurfaceVariant = surfaces_on_surface_variant_dark_w3w,
    outline = outlines_outline_dark_w3w,
    inverseOnSurface = surfaces_inverse_on_surface_dark_w3w,
    inverseSurface = surfaces_inverse_surface_dark_w3w,
    inversePrimary = colors_primary_core_inverse_primary_dark_w3w,
    outlineVariant = outlines_outline_variant_dark_w3w,
    scrim = scrim_scrim_dark_w3w,
    surfaceBright = surfaces_surface_bright_dark_w3w,
    surfaceDim = surfaces_surface_dim_dark_w3w,
    surfaceContainer = surfaces_surface_container_dark_w3w,
    surfaceContainerHigh = surfaces_surface_container_high_dark_w3w,
    surfaceContainerLow = surfaces_surface_container_low_dark_w3w,
    surfaceContainerHighest = surfaces_surface_container_highest_dark_w3w,
    surfaceContainerLowest = surfaces_surface_container_lowest_dark_w3w
)

/**
 * Data class representing custom w3w colors, allowing for additional color customization.
 */
@Immutable
data class W3WColorScheme(
    val warning: Color = Color.Unspecified,
    val onWarning: Color = Color.Unspecified,
    val warningContainer: Color = Color.Unspecified,
    val onWarningContainer: Color = Color.Unspecified,
    val success: Color = Color.Unspecified,
    val onSuccess: Color = Color.Unspecified,
    val successContainer: Color = Color.Unspecified,
    val onSuccessContainer: Color = Color.Unspecified,
    val brand: Color = Color.Unspecified,
    val brandBlue: Color = Color.Unspecified,
    val onBrand: Color = Color.Unspecified,
    val brandContainer: Color = Color.Unspecified,
    val onBrandContainer: Color = Color.Unspecified,
    val outlineMedium: Color = Color.Unspecified,
    val outlineLow: Color = Color.Unspecified,
    //extra surfaces
    val onSurfaceWhite: Color = Color.Unspecified,
    val onSurfaceBlack: Color = Color.Unspecified,
    val inverseSurfaceVariant: Color = Color.Unspecified,
    //brand custom
    val brandCustomYellow: Color = Color.Unspecified,
    val brandCustomOrange: Color = Color.Unspecified,
    val brandCustomCoral: Color = Color.Unspecified,
    val brandCustomPink: Color = Color.Unspecified,
    val brandCustomPurple: Color = Color.Unspecified,
    val brandCustomGreen: Color = Color.Unspecified,
    val brandCustomPowderBlue: Color = Color.Unspecified,
    val brandCustomSkyBlue: Color = Color.Unspecified,
    val brandCustomBlue: Color = Color.Unspecified
)

// W3W proprietary color assignments for light and dark themes.
val w3wLightW3WSchemeColors = W3WColorScheme(
    warning = states_warning_warning_light_w3w,
    onWarning = states_warning_on_warning_light_w3w,
    warningContainer = states_warning_warning_container_light_w3w,
    onWarningContainer = states_warning_on_warning_container_light_w3w,
    success = states_success_success_light_w3w,
    onSuccess = states_success_on_success_light_w3w,
    successContainer = states_success_success_container_light_w3w,
    onSuccessContainer = states_success_on_success_container_light_w3w,
    brand = colors_brand_base_brand_light_w3w,
    brandBlue = colors_brand_base_brand_blue_light_w3w,
    onBrand = colors_brand_base_on_brand_light_w3w,
    brandContainer = colors_brand_base_brand_container_light_w3w,
    onBrandContainer = colors_brand_base_on_brand_container_light_w3w,
    outlineMedium = outlines_outline_med_light_w3w,
    outlineLow = outlines_outline_low_light_w3w,
    onSurfaceWhite = surfaces_on_surface_white_light_w3w,
    onSurfaceBlack = surfaces_on_surface_black_light_w3w,
    inverseSurfaceVariant = surfaces_inverse_surface_variant_light_w3w,
    brandCustomYellow = colors_brand_custom_yellow_light_w3w,
    brandCustomOrange = colors_brand_custom_orange_light_w3w,
    brandCustomCoral = colors_brand_custom_coral_light_w3w,
    brandCustomPink = colors_brand_custom_pink_light_w3w,
    brandCustomPurple = colors_brand_custom_purple_light_w3w,
    brandCustomGreen = colors_brand_custom_green_light_w3w,
    brandCustomPowderBlue = colors_brand_custom_powder_blue_light_w3w,
    brandCustomSkyBlue = colors_brand_custom_sky_blue_light_w3w,
    brandCustomBlue = colors_brand_custom_blue_light_w3w
)

val w3wDarkW3WSchemeColors = W3WColorScheme(
    warning = states_warning_warning_dark_w3w,
    onWarning = states_warning_on_warning_dark_w3w,
    warningContainer = states_warning_warning_container_dark_w3w,
    onWarningContainer = states_warning_on_warning_container_dark_w3w,
    success = states_success_success_dark_w3w,
    onSuccess = states_success_on_success_dark_w3w,
    successContainer = states_success_success_container_dark_w3w,
    onSuccessContainer = states_success_on_success_container_dark_w3w,
    brand = colors_brand_base_brand_dark_w3w,
    brandBlue = colors_brand_base_brand_blue_dark_w3w,
    onBrand = colors_brand_base_on_brand_dark_w3w,
    brandContainer = colors_brand_base_brand_container_dark_w3w,
    onBrandContainer = colors_brand_base_on_brand_container_dark_w3w,
    outlineMedium = outlines_outline_med_dark_w3w,
    outlineLow = outlines_outline_low_dark_w3w,
    onSurfaceWhite = surfaces_on_surface_white_dark_w3w,
    onSurfaceBlack = surfaces_on_surface_black_dark_w3w,
    inverseSurfaceVariant = surfaces_inverse_surface_variant_dark_w3w,
    brandCustomYellow = colors_brand_custom_yellow_dark_w3w,
    brandCustomOrange = colors_brand_custom_orange_dark_w3w,
    brandCustomCoral = colors_brand_custom_coral_dark_w3w,
    brandCustomPink = colors_brand_custom_pink_dark_w3w,
    brandCustomPurple = colors_brand_custom_purple_dark_w3w,
    brandCustomGreen = colors_brand_custom_green_dark_w3w,
    brandCustomPowderBlue = colors_brand_custom_powder_blue_dark_w3w,
    brandCustomSkyBlue = colors_brand_custom_sky_blue_dark_w3w,
    brandCustomBlue = colors_brand_custom_blue_dark_w3w
)

val m3LightW3WSchemeColors = W3WColorScheme(
    warning = states_warning_warning_light_m3,
    onWarning = states_warning_on_warning_light_m3,
    warningContainer = states_warning_warning_container_light_m3,
    onWarningContainer = states_warning_on_warning_container_light_m3,
    success = states_success_success_light_m3,
    onSuccess = states_success_on_success_light_m3,
    successContainer = states_success_success_container_light_m3,
    onSuccessContainer = states_success_on_success_container_light_m3,
    brand = colors_brand_base_brand_light_m3,
    brandBlue = colors_brand_base_brand_blue_light_m3,
    onBrand = colors_brand_base_on_brand_light_m3,
    brandContainer = colors_brand_base_brand_container_light_m3,
    onBrandContainer = colors_brand_base_on_brand_container_light_m3,
    outlineMedium = outlines_outline_med_light_m3,
    outlineLow = outlines_outline_low_light_m3,
    onSurfaceWhite = surfaces_on_surface_white_light_m3,
    onSurfaceBlack = surfaces_on_surface_black_light_m3,
    inverseSurfaceVariant = surfaces_inverse_surface_variant_light_m3,
    brandCustomYellow = colors_brand_custom_yellow_light_m3,
    brandCustomOrange = colors_brand_custom_orange_light_m3,
    brandCustomCoral = colors_brand_custom_coral_light_m3,
    brandCustomPink = colors_brand_custom_pink_light_m3,
    brandCustomPurple = colors_brand_custom_purple_light_m3,
    brandCustomGreen = colors_brand_custom_green_light_m3,
    brandCustomPowderBlue = colors_brand_custom_powder_blue_light_m3,
    brandCustomSkyBlue = colors_brand_custom_sky_blue_light_m3,
    brandCustomBlue = colors_brand_custom_blue_light_m3
)

val m3DarkW3WSchemeColors = W3WColorScheme(
    warning = states_warning_warning_dark_m3,
    onWarning = states_warning_on_warning_dark_m3,
    warningContainer = states_warning_warning_container_dark_m3,
    onWarningContainer = states_warning_on_warning_container_dark_m3,
    success = states_success_success_dark_m3,
    onSuccess = states_success_on_success_dark_m3,
    successContainer = states_success_success_container_dark_m3,
    onSuccessContainer = states_success_on_success_container_dark_m3,
    brand = colors_brand_base_brand_dark_m3,
    brandBlue = colors_brand_base_brand_blue_dark_m3,
    onBrand = colors_brand_base_on_brand_dark_m3,
    brandContainer = colors_brand_base_brand_container_dark_m3,
    onBrandContainer = colors_brand_base_on_brand_container_dark_m3,
    outlineLow = outlines_outline_low_dark_m3,
    outlineMedium = outlines_outline_med_dark_m3,
    onSurfaceWhite = surfaces_on_surface_white_dark_m3,
    onSurfaceBlack = surfaces_on_surface_black_dark_m3,
    inverseSurfaceVariant = surfaces_inverse_surface_variant_dark_m3,
    brandCustomYellow = colors_brand_custom_yellow_dark_m3,
    brandCustomOrange = colors_brand_custom_orange_dark_m3,
    brandCustomCoral = colors_brand_custom_coral_dark_m3,
    brandCustomPink = colors_brand_custom_pink_dark_m3,
    brandCustomPurple = colors_brand_custom_purple_dark_m3,
    brandCustomGreen = colors_brand_custom_green_dark_m3,
    brandCustomPowderBlue = colors_brand_custom_powder_blue_dark_m3,
    brandCustomSkyBlue = colors_brand_custom_sky_blue_dark_m3,
    brandCustomBlue = colors_brand_custom_blue_dark_m3,
)


/**
 * Composition locals for custom success and warning colors.
 */
val LocalW3WColorScheme = staticCompositionLocalOf<W3WColorScheme?> { null }

/**
 * Extension properties on [MaterialTheme] to provide easy access to custom warning and success colors.
 * The theme automatically switches between light and dark color sets based on the system theme.
 */
val MaterialTheme.w3wColorScheme: W3WColorScheme
    @Composable
    @ReadOnlyComposable
    get() = LocalW3WColorScheme.current
        ?: (if (isSystemInDarkTheme()) m3DarkW3WSchemeColors else m3LightW3WSchemeColors)