package com.bot.nova.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bot.nova.action.event
import com.bot.nova.component.getModifier
import com.bot.nova.component.getTextAlign
import com.bot.nova.component.getTextFont
import com.bot.nova.utils.ColorUtil

object NovaText {

    const val DEFAULT_FONT = "medium"

    const val DEFAULT_FONT_COLOR = "#222222"

    const val DEFAULT_BACKGROUND_COLOR = "#FFFFFF"

    const val DEFAULT_TEXT_ALIGN = "leading"

}

@Composable
fun NovaText(component: NovaTextComponent) {
    val style = component.style
    val modifier = getModifier(style).event(component.event)
    val maxLines = style.lineLimit
    val textFont = getTextFont(style.font)
    val textAlign = getTextAlign(style.textAlign)
    val color = ColorUtil.parseColor(style.color)
    Text(text = component.text, modifier = modifier, color = color, fontSize = textFont.first, fontFamily = textFont.second, textAlign = textAlign, maxLines = maxLines)
}