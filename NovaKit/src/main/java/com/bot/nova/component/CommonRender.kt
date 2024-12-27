package com.bot.nova.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bot.nova.mode.NovaComponentStyle
import com.bot.nova.mode.TextAlignment
import com.bot.nova.utils.ColorUtil

private const val FULL_WIDTH = -1
private const val FULL_HEIGHT = -1

@Composable
fun getModifier(style: NovaComponentStyle): Modifier {
    val shape = RoundedCornerShape(style.borderRadius.dp)
    val backgroundColor = ColorUtil.parseColor(style.backgroundColor)
    val modifier = Modifier
        .padding(
            top = style.padding.top.dp,
            start = style.padding.start.dp,
            end = style.padding.end.dp,
            bottom = style.padding.bottom.dp
        )
        .background(color = backgroundColor, shape = shape)
    if (style.width > 0) {
        modifier.width(style.width.dp)
    }
    if (style.height > 0) {
        modifier.height(style.height.dp)
    }
    val maxWidth = style.maxWidth
    val maxHeight = style.maxHeight
    if (maxWidth != null) {
        if (maxWidth == FULL_WIDTH) {
            modifier.fillMaxWidth()
        } else if (maxWidth > 0) {
            val width = maxWidth.toFloat()
            modifier.fillMaxWidth(width)
        }
    }
    if (maxHeight != null) {
        if (maxHeight == FULL_HEIGHT) {
            modifier.fillMaxHeight()
        } else if (maxHeight > 0) {
            val height = maxHeight.toFloat()
            modifier.fillMaxWidth(height)
        }
    }
    var mWidth = Dp.Unspecified
    var mHeight = Dp.Unspecified
    val minWidth = style.minWidth
    val minHeight = style.minHeight
    if (minWidth != null && minWidth > 0) {
        mWidth = minWidth.dp
    }
    if (minHeight != null && minHeight > 0) {
        mHeight = minHeight.dp
    }
    modifier.defaultMinSize(minWidth = mWidth, minHeight = mHeight)
    return modifier
}

fun getHorizontalAlignment(alignment: String): Arrangement.Horizontal {
    if ("center" == alignment) {
        return Arrangement.Center
    } else if ("trailing" == alignment) {
        return Arrangement.End
    }
    return Arrangement.Start
}



