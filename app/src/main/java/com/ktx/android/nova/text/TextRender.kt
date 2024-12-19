package com.ktx.android.nova.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ktx.android.sdui.view.Click
import com.ktx.android.sdui.view.actions
import com.ktx.android.sdui.view.getModifier
import com.ktx.android.sdui.view.getTextAlign
import com.ktx.android.sdui.view.getTextFont
import com.bot.nova.utils.ColorUtil

@Composable
internal fun TextRender(component: com.bot.nova.text.TextComponent, text: String) {
    TextRender(component = component, text = text, null, null)
}

@Composable
internal fun TextRender(component: com.bot.nova.text.TextComponent, text: String, onClick: () -> Unit) {
    TextRender(component = component, text = text, onClick, null)
}

@Composable
internal fun TextRender(component: com.bot.nova.text.TextComponent, text: String, onClick: Click? = null, onLongClick: Click? = null) {
    val style = component.style
    val modifier = getModifier(style).actions(
        onClick = onClick,
        onLongClick = onLongClick,
        actions = component.actions
    )
    val textFont = getTextFont(style.font)
    val textAlign = getTextAlign(style.textAlign)
    val color = com.bot.nova.utils.ColorUtil.parseColor(style.color)
    var maxLines = Int.MAX_VALUE
    if (style.lineLimit != null && style.lineLimit != 0) {
        maxLines = style.lineLimit
    }
    Text(text = text, modifier = modifier, color = Color(0xFF000000), fontSize = textFont.first, fontFamily = textFont.second, textAlign = textAlign, maxLines = maxLines)
}