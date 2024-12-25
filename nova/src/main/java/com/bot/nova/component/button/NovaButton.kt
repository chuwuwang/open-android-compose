package com.bot.nova.component.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bot.nova.action.Click
import com.bot.nova.action.actions
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
fun NovaButton(component: NovaButtonComponent, text: String, onClick: Click) {
    NovaButton(component, text, onClick, null)
}

@Composable
fun NovaButton(component: NovaButtonComponent, text: String, onClick: Click, onLongPressClick: Click ? = null) {
    val style = component.style
    val modifier = getModifier(style).actions(
        onClick = onClick,
        onLongPressClick = onLongPressClick,
        actions = component.actions
    )
    val textFont = getTextFont(style.font)
    val textAlign = getTextAlign(style.textAlign)
    val color = ColorUtil.parseColor(style.color)
    var maxLines = Int.MAX_VALUE
    if (style.lineLimit != null && style.lineLimit > 0) {
        maxLines = style.lineLimit
    }
    Button(onClick = onClick, modifier = modifier) {
        Text(text = text, color = color, fontSize = textFont.first, fontFamily = textFont.second, textAlign = textAlign, maxLines = maxLines)
    }
}