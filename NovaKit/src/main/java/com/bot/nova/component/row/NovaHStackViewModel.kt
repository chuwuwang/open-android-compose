package com.bot.nova.component.row

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.bot.nova.NovaViewModel
import com.bot.nova.action.NovaEvent

class NovaHStackViewModel(private val nova: NovaHStackComponent, private val content: @Composable RowScope.() -> Unit) : NovaViewModel<NovaHStackComponent>() {

    @Composable
    override fun createComponent(): MutableState<NovaHStackComponent> {
        return remember { mutableStateOf(nova) }
    }

    @Composable
    override fun Draw(component: NovaHStackComponent) {
        NovaHStack(component, content)
    }

    override fun setEvent(event: NovaEvent) {
        component.value = component.value.copy(event = event)
    }

}
