package com.bot.nova.component.row

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import com.bot.nova.action.event
import com.bot.nova.component.getModifier
import com.bot.nova.utils.NovaUtil

object NovaHStack {

    const val DEFAULT_BACKGROUND_COLOR = "#FFFFFF"

    const val DEFAULT_ALIGNMENT = "top"

}

@Composable
fun NovaHStack(content: @Composable RowScope.() -> Unit) {
    val component = NovaHStackComponent()
    NovaHStack(component, content)
}

@Composable
fun NovaHStack(component: NovaHStackComponent, content: @Composable RowScope.() -> Unit) {
    val style = component.style
    val modifier = getModifier(style).event(component.event)
    val alignment = NovaUtil.getVerticalAlignment(component.alignment)
    Row(modifier, verticalAlignment = alignment, content = content)
}
