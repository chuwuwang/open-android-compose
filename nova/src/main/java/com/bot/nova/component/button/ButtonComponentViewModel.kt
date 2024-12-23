package com.bot.nova.component.button

import androidx.compose.runtime.Composable
import com.bot.nova.BaseComponentViewModel
import com.bot.nova.utils.info

class ButtonComponentViewModel(private var component: ButtonComponent) :
    BaseComponentViewModel(component) {

    @Composable
    override fun Render() {
        ButtonRender(component, component.text) {
            info("Button clicked")
        }
    }

}