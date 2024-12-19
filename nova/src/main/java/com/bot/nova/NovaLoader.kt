package com.bot.nova

import androidx.compose.runtime.Composable
import com.bot.nova.mode.NovaComponent

object NovaLoader {



    @Composable
    fun Render(components: List<NovaComponent>) {
        for (component in components) {
            val type = component.type
            if (type == "text") {
                val textComponent = component as com.bot.nova.text.TextComponent
                com.bot.nova.component.text.TextRender(textComponent, textComponent.text)
            }
        }
    }

}