package com.bot.nova.component.button

import com.bot.nova.action.NovaAction
import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaComponentStyle
import com.bot.nova.mode.NovaPadding

data class NovaButtonComponent(
    override val id: String,
    override val type: String,

    val text: String,
    val event: NovaEvent = NovaEvent(),
    val style: NovaButtonComponentStyle,
    val actions: List<NovaAction> = emptyList(),
) : NovaComponent

data class NovaButtonComponentStyle(
    override val width: Int = -1,
    override val height: Int = -1,
    override val minWidth: Int ? = null,
    override val maxWidth: Int ? = null,
    override val minHeight: Int ? = null,
    override val maxHeight: Int ? = null,
    override val padding: NovaPadding = NovaPadding(),
    override val borderRadius: Int = 0,
    override val backgroundColor: String = NovaButton.DEFAULT_BACKGROUND_COLOR,

    val font: String = NovaButton.DEFAULT_FONT,
    val color: String = NovaButton.DEFAULT_FONT_COLOR,
    val textAlign: String = NovaButton.DEFAULT_TEXT_ALIGN,
    val lineLimit: Int = Int.MAX_VALUE,
) : NovaComponentStyle