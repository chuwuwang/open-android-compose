package com.bot.nova.component.text

import androidx.compose.runtime.Composable
import com.bot.nova.NovaViewModel
import com.bot.nova.action.NovaEvent

class NovaTextViewModel(private var component: NovaTextComponent) : NovaViewModel(component) {

    @Composable
    override fun SetEvent(event: NovaEvent) {
        NovaText(component, component.text, event.onClick, event.onLongPressClick)
    }

}