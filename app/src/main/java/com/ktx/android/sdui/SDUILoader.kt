package com.ktx.android.sdui

import com.bot.nova.component.text.NovaTextComponent
import com.bot.nova.component.text.NovaTextComponentStyle

object SDUILoader {

    fun buildNovaComponent(component: SDUIComponent) {
        val type = component.type
        if (type == "text") {
            buildNovaTextComponent(component)
        } else if (type == "button") {

        }
    }

    private fun buildNovaTextComponent(component: SDUIComponent) {
        val style = component.style
        val textComponentStyle = if (style != null) {
            NovaTextComponentStyle(
                width = style.width,
                height = style.height,
                padding = SDUIUtil.buildNovaPadding(style.padding),
                borderRadius = style.borderRadius ?: 0,
                backgroundColor = style.backgroundColor ?: "#FFFFFF",
                font = style.font ?: "medium",
                color = style.color ?: "#222222",
                textAlign = style.textAlign ?: "",
                lineLimit = component.style.lineLimit ?: Int.MAX_VALUE,
            )
        } else {
            NovaTextComponentStyle()
        }
        NovaTextComponent(id = component.id, type = component.type, text = component.text ?: "", actions = SDUIUtil.buildNovaAction(component.actions), style = textComponentStyle)
    }

}
