package com.bot.nova.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bot.nova.action.Click
import com.bot.nova.action.actions
import com.bot.nova.component.getModifier
import com.bot.nova.component.getTextAlign
import com.bot.nova.component.getTextFont
import com.bot.nova.utils.ColorUtil

@Composable
fun NovaTextRender(component: TextComponent, text: String, onClick: Click ? = null, onLongPressClick: Click ? = null) {
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
    Text(text = text, modifier = modifier, color = color, fontSize = textFont.first, fontFamily = textFont.second, textAlign = textAlign, maxLines = maxLines)
}