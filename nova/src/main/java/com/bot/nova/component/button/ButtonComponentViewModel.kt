package com.bot.nova.component.button

import androidx.compose.runtime.Composable
import com.bot.nova.BaseComponentViewModel
import com.bot.nova.action.NovaEvent

class ButtonComponentViewModel(private var component: NovaButtonComponent) : BaseComponentViewModel(component) {

    @Composable
    override fun SetEvent(event: NovaEvent) {

    }

}