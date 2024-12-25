package com.bot.nova.component.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bot.nova.action.event
import com.bot.nova.component.getModifier
import com.bot.nova.component.getTextAlign
import com.bot.nova.component.getTextFont
import com.bot.nova.utils.ColorUtil

object NovaButton {

    const val DEFAULT_FONT = "medium"

    const val DEFAULT_FONT_COLOR = "#222222"

    const val DEFAULT_BACKGROUND_COLOR = "#FFFFFF"

    const val DEFAULT_TEXT_ALIGN = "leading"

}

@Composable
fun NovaButton(component: NovaButtonComponent) {
    val clickList = component.event.onClick
    component.event.onClick = emptyList()
    val style = component.style
    val modifier = getModifier(style).event(component.event)
    val textFont = getTextFont(style.font)
    val textAlign = getTextAlign(style.textAlign)
    val color = ColorUtil.parseColor(style.color)
    var maxLines = Int.MAX_VALUE
    if (style.lineLimit != null && style.lineLimit > 0) {
        maxLines = style.lineLimit
    }
    Button(onClick = { clickList.forEach { it.invoke() } }, modifier = modifier) {
        Text(text = component.text, color = color, fontSize = textFont.first, fontFamily = textFont.second, textAlign = textAlign, maxLines = maxLines)
    }
}