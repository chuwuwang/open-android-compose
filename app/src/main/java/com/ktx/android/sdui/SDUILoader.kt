package com.ktx.android.sdui

import androidx.compose.runtime.Composable
import com.bot.nova.mode.NovaComponent
import com.bot.nova.text.TextComponent
import com.bot.nova.component.text.TextRender

object SDUILoader {

    fun parse(json: String): List<com.bot.nova.mode.NovaComponent> {

    }


}


@Composable
fun Render(components: List<com.bot.nova.mode.NovaComponent>) {
    for (component in components) {
        val type = component.type
        if (type == "text") {
            val textComponent = component as com.bot.nova.text.TextComponent
            com.bot.nova.component.text.TextRender(textComponent, textComponent.text)
        }
    }
}