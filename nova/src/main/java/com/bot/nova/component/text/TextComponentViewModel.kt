package com.bot.nova.component.text

import androidx.compose.runtime.Composable
import com.bot.nova.BaseComponentViewModel
import com.bot.nova.action.NovaEvent

class TextComponentViewModel(private var component: TextComponent) : BaseComponentViewModel(component) {

    @Composable
    override fun SetEvent(event: NovaEvent) {
        NovaTextRender(component, component.text, event.onClick, event.onLongPressClick)
    }

}