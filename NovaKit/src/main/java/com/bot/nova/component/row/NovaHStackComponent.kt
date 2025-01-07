package com.bot.nova.component.row

import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.ComponentType
import com.bot.nova.mode.NovaComponent
import com.bot.nova.mode.NovaMargin
import com.bot.nova.mode.NovaPadding
import com.bot.nova.mode.NovaStyle
import java.util.UUID

data class NovaHStackComponent(
    override val id: String = UUID.randomUUID().toString(),
    override val type: String = ComponentType.ROW.value,
    override val event: NovaEvent = NovaEvent(),
    override val style: NovaHStackStyle = NovaHStackStyle(),

    val alignment: String = NovaHStack.DEFAULT_ALIGNMENT,
    val children: List<NovaComponent> = emptyList(),
) : NovaComponent {

    override fun copyX(event: NovaEvent): NovaComponent {
        return this.copy(event = event)
    }

    override fun copyX(style: NovaStyle): NovaComponent {
        return this.copy(style = style as NovaHStackStyle)
    }

}

data class NovaHStackStyle(
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
) : NovaStyle