package com.bot.nova

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.NovaComponent

abstract class NovaViewModel<T : NovaComponent> {

    lateinit var component: MutableState<T>

    val event: NovaEvent
        get() = component.value.event

    @Composable
    abstract fun createComponent(): MutableState<T>

    @Composable
    abstract fun Draw(component: T)

    @Composable
    fun Render() {
        component = createComponent()
        Draw(component.value)
    }

    open fun setEvent(event: NovaEvent) {

    }

}
