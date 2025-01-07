package com.bot.nova

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaStyle

abstract class NovaViewModel<T : NovaComponent, S : NovaStyle> {

    lateinit var component: MutableState<T>

    val style: S
        get() = component.value.style as S

    @Composable
    abstract fun createComponent(): MutableState<T>

    @Composable
    abstract fun Draw(component: T)

    @Composable
    fun Render() {
        component = createComponent()

        Draw(component.value)
    }

    fun updateStyle(style: S) {
        component.value = component.value.copyX(style = style) as T
    }

    fun setEvent(event: NovaEvent) {
        component.value = component.value.copyX(event = event) as T
    }


}
