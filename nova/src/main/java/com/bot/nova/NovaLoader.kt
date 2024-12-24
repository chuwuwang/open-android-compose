package com.bot.nova

import androidx.compose.runtime.Composable
import com.bot.nova.component.button.ButtonComponent
import com.bot.nova.component.button.NovaButton
import com.bot.nova.component.row.HStackComponent
import com.bot.nova.component.row.NovaHStack
import com.bot.nova.component.text.NovaText
import com.bot.nova.component.text.NovaTextComponent
import com.bot.nova.component.text.TextComponentViewModel
import com.bot.nova.mode.ComponentType
import com.bot.nova.mode.NovaComponent

class NovaLoader {

    private val viewModels = HashMap<String, BaseComponentViewModel>()

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
            NovaText(textComponent, textComponent.text)
            viewModels[textComponent.id] = TextComponentViewModel(textComponent)
        } else if (type == ComponentType.BUTTON.value) {
            val cmp = component as ButtonComponent
            NovaButton(cmp, cmp.text) { }
        }
        // container
        else if (type == ComponentType.HORIZONTAL.value) {
            val cmp = component as HStackComponent
            NovaHStack(cmp) { Render(cmp.children) }
        }

    }

    fun xxx(component: NovaComponent, action: OnErrorAction) {
        val viewModel = viewModels["id"]
    }

}
