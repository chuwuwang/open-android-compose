package com.bot.nova.component.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bot.nova.NovaViewModel
import com.bot.nova.action.NovaEvent

class NovaTextViewModel(private val nova: NovaTextComponent) : NovaViewModel<NovaTextComponent>() {

    @Composable
    override fun createComponent(): MutableState<NovaTextComponent> {
        return remember { mutableStateOf(nova) }
    }

    @Composable
    override fun Draw(component: NovaTextComponent) {
        NovaText(component)
    }

    override fun setEvent(event: NovaEvent) {
        component.value = component.value.copy(event = event)
    }

    fun setText(text: String) {
        component.value = component.value.copy(text = text)
    }

}
