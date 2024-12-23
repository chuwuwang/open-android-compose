package com.bot.nova.component.text

import androidx.compose.runtime.Composable
import com.bot.nova.BaseComponentViewModel
import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.NovaComponent

class TextComponentViewModel(private var component: TextComponent) : BaseComponentViewModel(component) {

    @Composable
    override fun Render() {
        TextRender(component, component.text)
    }

    @Composable
    override fun SetEvent(component: NovaComponent, event: NovaEvent) {
        //  TextRender(component, component.text, event.onClick, event.onLongPressClick)
    }

    @Composable
    fun Update(component: TextComponent, text: String) {
        // TextRender(component, text)
    }

}