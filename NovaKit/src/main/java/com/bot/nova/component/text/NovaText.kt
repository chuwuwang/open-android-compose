package com.bot.nova.component.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.bot.nova.action.event
import com.bot.nova.component.getModifier
import com.bot.nova.utils.ColorUtil
import com.bot.nova.utils.FontUtil
import com.bot.nova.utils.NovaUtil
import com.bot.nova.utils.info

object NovaText {

    const val DEFAULT_FONT = "medium"

    const val DEFAULT_FONT_COLOR = "#222222"

    const val DEFAULT_BACKGROUND_COLOR = "#FFFFFF"

    const val DEFAULT_TEXT_ALIGN = "leading"

}

@Composable
fun NovaText(text: String) {
    val component = NovaTextComponent(text = text)
    NovaText(component)
}

@Composable
fun NovaText(component: NovaTextComponent) {
    val style = component.style
    val modifier = getModifier(style).event(component.event)
    val maxLines = style.lineLimit
    val color = ColorUtil.parseColor(style.color)
    val textFont = FontUtil.getTextFont(style.font)
    val textAlign = NovaUtil.getTextAlign(style.textAlign)


    DisposableEffect(Unit) {

        info("DisposableEffect")

        onDispose {

            info("onDispose")

        }

    }

    Text(text = component.text, modifier = modifier, color = color, fontSize = textFont.first, fontFamily = textFont.second, textAlign = textAlign, maxLines = maxLines)
}
