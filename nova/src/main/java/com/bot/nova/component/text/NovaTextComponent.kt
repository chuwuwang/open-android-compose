package com.bot.nova.component.text

import com.bot.nova.action.NovaAction
import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaComponentStyle
import com.bot.nova.mode.NovaPadding

data class NovaTextComponent(
    override val id: String,
    override val type: String,
    override var event: NovaEvent = NovaEvent(),

    val text: String,
    val actions: List<NovaAction> = emptyList(),
    val style: NovaTextComponentStyle = NovaTextComponentStyle(),
) : NovaComponent

data class NovaTextComponentStyle(
    override val width: Int = -1,
    override val height: Int = -1,
    override val minWidth: Int ? = null,
    override val maxWidth: Int ? = null,
    override val minHeight: Int ? = null,
    override val maxHeight: Int ? = null,
    override val padding: NovaPadding = NovaPadding(),
    override val borderRadius: Int = 0,
    override val backgroundColor: String = NovaText.DEFAULT_BACKGROUND_COLOR,

    val font: String = NovaText.DEFAULT_FONT,
    val color: String = NovaText.DEFAULT_FONT_COLOR,
    val textAlign: String = NovaText.DEFAULT_TEXT_ALIGN,
    val lineLimit: Int = Int.MAX_VALUE,
) : NovaComponentStyle