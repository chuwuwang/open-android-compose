package com.bot.nova.component.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bot.nova.NovaViewModel

class NovaButtonViewModel(private var nova: NovaButtonComponent) : NovaViewModel<NovaButtonComponent>() {

    @Composable
    override fun createComponent(): MutableState<NovaButtonComponent> {
        return remember { mutableStateOf(nova) }
    }

    @Composable
    override fun Rraw(component: NovaButtonComponent) {
        NovaButton(component)
    }

    fun setText(text: String) {
        component.value = component.value.copy(text = text)
    }

}
