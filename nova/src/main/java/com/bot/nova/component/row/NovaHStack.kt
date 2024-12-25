package com.bot.nova.component.row

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import com.bot.nova.action.Click
import com.bot.nova.action.actions
import com.bot.nova.component.getHorizontalAlignment
import com.bot.nova.component.getModifier

object NovaHStack  {

    const val DEFAULT_BACKGROUND_COLOR = "#FFFFFF"

    const val DEFAULT_ALIGNMENT = "leading"

}

@Composable
fun NovaHStack(component: NovaHStackComponent, onClick: Click ? = null, content: @Composable RowScope.() -> Unit) {
    NovaHStack(component, onClick, null, content)
}

@Composable
fun NovaHStack(component: NovaHStackComponent, onClick: Click ? = null, onLongPressClick: Click ? = null, content: @Composable RowScope.() -> Unit) {
    val style = component.style
    val modifier = getModifier(style).actions(
        onClick = onClick,
        onLongPressClick = onLongPressClick,
        actions = component.actions
    )
    val alignment = getHorizontalAlignment(component.alignment)
    Row(modifier, horizontalArrangement = alignment, content = content)
}