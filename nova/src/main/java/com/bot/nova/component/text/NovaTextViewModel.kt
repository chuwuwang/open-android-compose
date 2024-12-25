package com.bot.nova.component.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bot.nova.NovaViewModel

class NovaTextViewModel(private val nova: NovaTextComponent) : NovaViewModel<NovaTextComponent>() {

    @Composable
    override fun createComponent(): MutableState<NovaTextComponent> {
        return remember { mutableStateOf(nova) }
    }

    @Composable
    override fun Rraw(component: NovaTextComponent) {
        NovaText(component)
    }

    fun setText(text: String) {
        component.value = component.value.copy(text = text)
    }

}
