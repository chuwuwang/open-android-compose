package com.bot.nova

import androidx.compose.runtime.Composable
import com.bot.nova.action.NovaEvent
import com.bot.nova.component.button.NovaButtonComponent
import com.bot.nova.component.button.NovaButtonViewModel
import com.bot.nova.component.row.NovaHStackComponent
import com.bot.nova.component.row.NovaHStackViewModel
import com.bot.nova.component.text.NovaTextComponent
import com.bot.nova.component.text.NovaTextViewModel
import com.bot.nova.mode.ComponentType
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaStyle

class NovaLoader {

    private val viewModels = HashMap<String, NovaViewModel<*, NovaStyle>>()

    @Composable
    fun Render(components: List<NovaComponent>) {
        for (component in components) {
            Render(component)
        }
    }

    @Composable
    fun Render(component: NovaComponent) {
        val type = component.type
        if (type == ComponentType.TEXT.value) {
            val textComponent = component as NovaTextComponent
            viewModels[textComponent.id] = NovaTextViewModel(textComponent).apply { Render() }
        } else if (type == ComponentType.BUTTON.value) {
            val buttonComponent = component as NovaButtonComponent
            viewModels[buttonComponent.id] = NovaButtonViewModel(buttonComponent).apply { Render() }
        }
        // container
        else if (type == ComponentType.ROW.value) {
            val hStackComponent = component as NovaHStackComponent
            val viewModel = NovaHStackViewModel(hStackComponent) { Render(hStackComponent.children) }.apply { Render() }
            viewModels[hStackComponent.id] = viewModel
        }
    }

    fun setEvent(id: String, onClick: () -> Unit) {
        val viewModel = viewModels[id]
        if (viewModel != null) {
            val event = NovaEvent(onClick)
            viewModel.setEvent(event)
        }
    }

    fun updateStyle(id: String, style: NovaStyle) {
        val viewModel = viewModels[id]
        if (viewModel != null) {
            viewModel.updateStyle(style)
        }
    }

    fun getStyle(id: String): NovaStyle ? {
        val viewModel = viewModels[id]
        if (viewModel != null) {
            return viewModel.component.value.style
        }
        return null
    }

    fun setText(id: String, text: String) {
        val viewModel = viewModels[id]
        if (viewModel != null && viewModel is NovaTextViewModel) {
            viewModel.setText(text)
        } else if (viewModel != null && viewModel is NovaButtonViewModel) {
            viewModel.setText(text)
        }
    }

}
