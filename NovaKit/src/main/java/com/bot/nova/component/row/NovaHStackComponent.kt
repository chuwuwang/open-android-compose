package com.bot.nova.component.row

import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.ComponentType
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaComponentStyle
import com.bot.nova.mode.NovaMargin
import com.bot.nova.mode.NovaPadding
import java.util.UUID

data class NovaHStackComponent(
    override val id: String = UUID.randomUUID().toString(),
    override val type: String = ComponentType.ROW.value,
    override val event: NovaEvent = NovaEvent(),

    val alignment: String = NovaHStack.DEFAULT_ALIGNMENT,
    val style: NovaHStackComponentStyle = NovaHStackComponentStyle(),
    val children: List<NovaComponent> = emptyList(),
) : NovaComponent

data class NovaHStackComponentStyle(
    override val width: Int = -1,
    override val height: Int = -1,
    override val minWidth: Int ? = null,
    override val maxWidth: Int ? = null,
    override val minHeight: Int ? = null,
    override val maxHeight: Int ? = null,
    override val margin: NovaMargin = NovaMargin(),
    override val padding: NovaPadding = NovaPadding(),
    override val borderRadius: Int = 0,
    override val backgroundColor: String = NovaHStack.DEFAULT_BACKGROUND_COLOR,
) : NovaComponentStyle