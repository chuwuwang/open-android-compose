package com.bot.nova.component.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bot.nova.NovaViewModel
import com.bot.nova.mode.NovaStyle

class NovaButtonViewModel(private val nova: NovaButtonComponent) : NovaViewModel<NovaButtonComponent, NovaStyle>() {

    @Composable
    override fun createComponent(): MutableState<NovaButtonComponent> {
        return remember { mutableStateOf(nova) }
    }

    @Composable
    override fun Draw(component: NovaButtonComponent) {
        NovaButton(component)
    }

    fun setText(text: String) {
        component.value = component.value.copy(text = text)
    }

    fun getText(): String {
        return component.value.text
    }

}
