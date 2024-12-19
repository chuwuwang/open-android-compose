package com.bot.nova

import androidx.compose.runtime.Composable
import com.bot.nova.component.text.TextComponent
import com.bot.nova.component.text.TextComponentViewModel
import com.bot.nova.mode.ComponentType
import com.bot.nova.mode.NovaComponent

class NovaLoader {

    private val mapsViewModel = HashMap<String, BaseComponentViewModel>()

    @Composable
    fun Render(components: List<NovaComponent>) {
        for (component in components) {
            Render(component)
        }
    }

    @Composable
    fun Render(component: NovaComponent) {
        val type = ComponentType.valueOf(component.type)
        if (type == ComponentType.TEXT) {
            val textComponent = component as TextComponent
            val viewModel = TextComponentViewModel(textComponent)
            viewModel.Render()
            mapsViewModel[textComponent.id] = viewModel
        } else if (type == ComponentType.BUTTON) {

        }
    }

    fun xxx(component: NovaComponent, action: OnErrorAction) {
        val viewModel = mapsViewModel["id"]
    }

}
