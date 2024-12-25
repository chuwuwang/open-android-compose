package com.bot.nova.component.row

import com.bot.nova.action.NovaAction
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaComponentStyle
import com.bot.nova.mode.NovaPadding

data class NovaHStackComponent(
    override val id: String,
    override val type: String,

    var alignment: String = NovaHStack.DEFAULT_ALIGNMENT,
    val style: NovaHStackComponentStyle = NovaHStackComponentStyle(),
    val actions: List<NovaAction> = emptyList(),
    val children: List<NovaComponent> = emptyList(),
) : NovaComponent

data class NovaHStackComponentStyle(
    override val width: Int = -1,
    override val height: Int = -1,
    override val minWidth: Int ? = null,
    override val maxWidth: Int ? = null,
    override val minHeight: Int ? = null,
    override val maxHeight: Int ? = null,
    override val padding: NovaPadding = NovaPadding(),
    override val borderRadius: Int = 0,
    override val backgroundColor: String = NovaHStack.DEFAULT_BACKGROUND_COLOR,
) : NovaComponentStyle