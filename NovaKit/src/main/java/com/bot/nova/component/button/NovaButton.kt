package com.bot.nova.component.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bot.nova.action.NovaEvent
import com.bot.nova.action.event
import com.bot.nova.component.getModifier
import com.bot.nova.utils.ColorUtil
import com.bot.nova.utils.FontUtil
import com.bot.nova.utils.NovaUtil

object NovaButton {

    const val DEFAULT_FONT = "medium"

    const val DEFAULT_FONT_COLOR = "#222222"

    const val DEFAULT_BACKGROUND_COLOR = "#FFFFFF"

    const val DEFAULT_TEXT_ALIGN = "leading"

}

@Composable
fun NovaButton(text: String, onClick: () -> Unit) {
    val event = NovaEvent().apply { this.onClick = onClick }
    val component = NovaButtonComponent(text = text, event = event)
    NovaButton(component)
}

@Composable
fun NovaButton(component: NovaButtonComponent) {
    val onClick = component.event.onClick ?: { }
    component.event.onClick = null
    val style = component.style
    val modifier = getModifier(style).event(component.event)
    val maxLines = style.lineLimit
    val color = ColorUtil.parseColor(style.color)
    val textFont = FontUtil.getTextFont(style.font)
    val textAlign = NovaUtil.getTextAlign(style.textAlign)
    Button(onClick = { onClick.invoke() }, modifier = modifier) {
        Text(text = component.text, color = color, fontSize = textFont.first, fontFamily = textFont.second, textAlign = textAlign, maxLines = maxLines)
    }
}
