package com.bot.nova.component.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bot.nova.NovaViewModel
import com.bot.nova.action.NovaEvent

class NovaButtonViewModel(private var nova: NovaButtonComponent) : NovaViewModel<NovaButtonComponent>() {

    @Composable
    override fun createComponent(): MutableState<NovaButtonComponent> {
        return remember { mutableStateOf(nova) }
    }

    @Composable
    override fun Draw(component: NovaButtonComponent) {
        NovaButton(component)
    }

    override fun setEvent(event: NovaEvent) {
        component.value = component.value.copy(event = event)
    }

    fun setText(text: String) {
        component.value = component.value.copy(text = text)
    }

}
