package com.bot.nova.component.text

import androidx.compose.runtime.Composable
import com.bot.nova.BaseComponentViewModel

class TextComponentViewModel(private var component: TextComponent) : BaseComponentViewModel(component) {

    @Composable
    override fun Render() {
        TextRender(component, component.text)
    }

}