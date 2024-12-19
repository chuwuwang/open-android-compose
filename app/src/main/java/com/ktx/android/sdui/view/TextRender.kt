package com.ktx.android.sdui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ktx.android.sdui.mode.TextComponent
import com.ktx.android.utils.ColorUtil

@Composable
internal fun TextRender(component: TextComponent, text: String) {
    TextRender(component = component, text = text, null, null)
}

@Composable
internal fun TextRender(component: TextComponent, text: String, onClick: () -> Unit) {
    TextRender(component = component, text = text, onClick, null)
}

@Composable
internal fun TextRender(component: TextComponent, text: String, onClick: Click ? = null, onLongClick: Click ? = null) {
    val style = component.style
    val modifier = getModifier(style).actions(
        onClick = onClick,
        onLongClick = onLongClick,
        actions = component.actions
    )
    val textFont = getTextFont(style.font)
    val textAlign = getTextAlign(style.textAlign)
    val color = ColorUtil.parseColor(style.color)
    var maxLines = Int.MAX_VALUE
    if (style.lineLimit != null && style.lineLimit != 0) {
        maxLines = style.lineLimit
    }
    Text(text = text, modifier = modifier, color = Color(0xFF000000), fontSize = textFont.first, fontFamily = textFont.second, textAlign = textAlign, maxLines = maxLines)
}