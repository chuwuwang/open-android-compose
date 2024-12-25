package com.bot.nova.component.row

import com.bot.nova.action.NovaAction
import com.bot.nova.component.button.NovaButtonComponentStyle
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaComponentStyle
import com.bot.nova.mode.NovaPadding

data class HStackComponent(
    override val id: String,
    override val type: String,

    var alignment: String,
    val style: NovaButtonComponentStyle,
    val actions: List<NovaAction> ? = null,
    val children: List<NovaComponent> = emptyList(),
) : NovaComponent

data class HStackComponentStyle(
    override val width: Int,
    override val height: Int,
    override val minWidth: Int ? = null,
    override val maxWidth: Int ? = null,
    override val minHeight: Int ? = null,
    override val maxHeight: Int ? = null,
    override val padding: NovaPadding,
    override val borderRadius: Int,
    override val backgroundColor: String,
) : NovaComponentStyle