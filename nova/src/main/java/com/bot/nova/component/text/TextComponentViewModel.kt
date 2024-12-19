package com.bot.nova.component.text

import androidx.compose.runtime.Composable
import com.bot.nova.BaseComponentViewModel
import com.bot.nova.action.NovaEvent

class TextComponentViewModel(private var component: TextComponent) : BaseComponentViewModel(component) {

    @Composable
    override fun Render() {
        TextRender(component, component.text)
    }

    @Composable
    override fun SetEvent(component: TextComponent, event: NovaEvent) {
        this.component = component
        TextRender(component, component.text, event.onClick, event.onLongPressClick)
    }

}