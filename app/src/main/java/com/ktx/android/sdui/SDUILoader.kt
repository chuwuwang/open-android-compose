package com.ktx.android.sdui

import com.bot.nova.component.button.NovaButton
import com.bot.nova.component.button.NovaButtonComponent
import com.bot.nova.component.button.NovaButtonComponentStyle
import com.bot.nova.component.row.NovaHStack
import com.bot.nova.component.row.NovaHStackComponent
import com.bot.nova.component.row.NovaHStackComponentStyle
import com.bot.nova.component.text.NovaText
import com.bot.nova.component.text.NovaTextComponent
import com.bot.nova.component.text.NovaTextComponentStyle
import com.bot.nova.mode.NovaComponent

object SDUILoader {

    fun buildNovaComponent(component: SDUIComponent): NovaComponent {
        val type = component.type
        if (type == "text") {
            return buildNovaTextComponent(component)
        } else if (type == "button") {
            return buildNovaButtonComponent(component)
        }
        else if (type == "hStack") {
            return buildNovaHStackComponent(component)
        }
        throw IllegalArgumentException("Unsupported component type: $type")
    }

    private fun buildNovaTextComponent(component: SDUIComponent): NovaTextComponent {
        val style = component.style
        val textStyle = if (style != null) {
            NovaTextComponentStyle(
                width = style.width,
                height = style.height,
                padding = SDUIUtil.buildNovaPadding(style.padding),
                borderRadius = style.borderRadius ?: 0,
                backgroundColor = style.backgroundColor ?: NovaText.DEFAULT_BACKGROUND_COLOR,
                font = style.font ?: NovaText.DEFAULT_FONT,
                color = style.color ?: NovaText.DEFAULT_FONT_COLOR,
                textAlign = style.textAlign ?: NovaText.DEFAULT_TEXT_ALIGN,
                lineLimit = component.style.lineLimit ?: Int.MAX_VALUE,
            )
        } else {
            NovaTextComponentStyle()
        }
        val actions = SDUIUtil.buildNovaAction(component.actions)
        return NovaTextComponent(
            id = component.id,
            type = component.type,
            style = textStyle,
            actions = actions,
            text = component.text ?: ""
        )
    }

    private fun buildNovaButtonComponent(component: SDUIComponent): NovaButtonComponent {
        val style = component.style
        val buttonStyle = if (style != null) {
            NovaButtonComponentStyle(
                width = style.width,
                height = style.height,
                padding = SDUIUtil.buildNovaPadding(style.padding),
                borderRadius = style.borderRadius ?: 0,
                backgroundColor = style.backgroundColor ?: NovaButton.DEFAULT_BACKGROUND_COLOR,
                font = style.font ?: NovaButton.DEFAULT_FONT,
                color = style.color ?: NovaButton.DEFAULT_FONT_COLOR,
                textAlign = style.textAlign ?: NovaButton.DEFAULT_TEXT_ALIGN,
                lineLimit = component.style.lineLimit ?: Int.MAX_VALUE,
            )
        } else {
            NovaButtonComponentStyle()
        }
        val actions = SDUIUtil.buildNovaAction(component.actions)
        return NovaButtonComponent(
            id = component.id,
            type = component.type,
            style = buttonStyle,
            actions = actions,
            text = component.text ?: ""
        )
    }

    private fun buildNovaHStackComponent(component: SDUIComponent): NovaHStackComponent {
        val style = component.style
        val hStackStyle = if (style != null) {
            NovaHStackComponentStyle(
                width = style.width,
                height = style.height,
                padding = SDUIUtil.buildNovaPadding(style.padding),
                borderRadius = style.borderRadius ?: 0,
                backgroundColor = style.backgroundColor ?: NovaHStack.DEFAULT_BACKGROUND_COLOR,
            )
        } else {
            NovaHStackComponentStyle()
        }
        val actions = SDUIUtil.buildNovaAction(component.actions)
        val alignment = component.alignment ?: NovaHStack.DEFAULT_ALIGNMENT
        val children = if (component.children != null) {
            component.children.map { buildNovaComponent(it) }
        } else {
            emptyList()
        }
        return NovaHStackComponent(
            id = component.id,
            type = component.type,
            actions = actions,
            style = hStackStyle,
            alignment = alignment,
            children = children
        )
    }

}
