package com.bot.nova.component.button

import com.bot.nova.action.NovaAction
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaComponentStyle
import com.bot.nova.mode.NovaPadding

data class ButtonComponent(
    override val id: String,
    override val type: String,

    var text: String,
    val style: ButtonComponentStyle,
    val actions: List<NovaAction> ? = null,
) : NovaComponent

data class ButtonComponentStyle(
    override val width: Int,
    override val height: Int,
    override val minWidth: Int ? = null,
    override val maxWidth: Int ? = null,
    override val minHeight: Int ? = null,
    override val maxHeight: Int ? = null,
    override val padding: NovaPadding,
    override val borderRadius: Int,
    override val backgroundColor: String,

    val font: String,
    val color: String,
    val textAlign: String,
    val lineLimit: Int ? = null,
) : NovaComponentStyle