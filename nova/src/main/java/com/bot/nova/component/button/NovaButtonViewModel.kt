package com.bot.nova.component.button

import androidx.compose.runtime.Composable
import com.bot.nova.NovaViewModel
import com.bot.nova.action.NovaEvent

class NovaButtonViewModel(private var component: NovaButtonComponent) : NovaViewModel(component) {

    @Composable
    override fun SetEvent(event: NovaEvent) {

    }

}