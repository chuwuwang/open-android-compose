package com.ktx.android.utils

import androidx.compose.ui.graphics.Color

object ColorUtil {

    fun parseColor(color: String): Color {
        val colorX = android.graphics.Color.parseColor(color)
        return Color(colorX)
    }

}