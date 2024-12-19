package com.bot.nova.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bot.nova.mode.NovaComponentStyle
import com.bot.nova.mode.TextAlignment

fun getModifier(style: NovaComponentStyle): Modifier {
    val shape = RoundedCornerShape(style.borderRadius.dp)
    val backgroundColor = com.bot.nova.utils.ColorUtil.parseColor(style.backgroundColor)
    val modifier = Modifier.width(style.width.dp).height(style.height.dp).padding(
        top = style.padding.top.dp,
        start = style.padding.left.dp,
        end = style.padding.right.dp,
        bottom = style.padding.bottom.dp
    ).background(color = backgroundColor, shape = shape)
    val maxWidth = style.maxWidth
    val maxHeight = style.maxHeight
    if (maxWidth != null) {
        val width = maxWidth.toFloat()
        modifier.fillMaxWidth(width)
    }
    if (maxHeight != null) {
        val height = maxHeight.toFloat()
        modifier.fillMaxWidth(height)
    }
    var mWidth = Dp.Unspecified
    var mHeight = Dp.Unspecified
    val minWidth = style.minWidth
    val minHeight = style.minHeight
    if (minWidth != null) {
        mWidth = minWidth.dp
    }
    if (minHeight != null) {
        mHeight = minHeight.dp
    }
    modifier.defaultMinSize(minWidth = mWidth, minHeight = mHeight)
    return modifier
}

fun getTextAlign(align: String): TextAlign {
    if (align == TextAlignment.CENTER.alignment) {
        return TextAlign.Center
    } else if (align == TextAlignment.END.alignment) {
        return TextAlign.End
    }
    return TextAlign.Start
}

fun getTextFont(font: String): Pair<TextUnit, FontFamily> {
    return Pair(16.sp, FontFamily.Default)
}