package com.bot.nova

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.NovaComponent

abstract class NovaViewModel<T : NovaComponent> {

    lateinit var component: MutableState<T>

    @Composable
    abstract fun createComponent(): MutableState<T>

    @Composable
    abstract fun Rraw(component: T)

    @Composable
    fun Render() {
        component = createComponent()
        Rraw(component.value)
    }

    fun setEvent(event: NovaEvent) {
        component.value.event = event
    }

}