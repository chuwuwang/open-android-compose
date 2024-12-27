package com.bot.nova.utils

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

internal object FontUtil {

    fun getTextFont(font: String): Pair<TextUnit, FontFamily> {
        return Pair(16.sp, FontFamily.Default)
    }

}