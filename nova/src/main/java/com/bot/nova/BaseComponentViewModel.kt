package com.bot.nova

import androidx.compose.runtime.Composable
import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.NovaComponent

abstract class BaseComponentViewModel(private var component: NovaComponent) {

    @Composable
    open fun SetEvent(event: NovaEvent) {

    }

}