package com.ktx.android.sdui

import com.bot.nova.action.NovaAction
import com.bot.nova.mode.NovaPadding

object SDUIUtil {

    const val DEFAULT_FONT = "medium"
    const val DEFAULT_FONT_COLOR = "#FFFFFF"
    const val DEFAULT_BACKGROUND_COLOR = "#FFFFFF"

    fun buildNovaAction(actions: List<SDUIAction> ? ): List<NovaAction> {
        if (actions == null) {
            return mutableListOf()
        }
        return actions.map { NovaAction(event = it.event, target = it.target ?: "") }
    }

    fun buildNovaPadding(padding: SDUIPadding ? ): NovaPadding {
        if (padding == null) {
            return NovaPadding()
        }
        return NovaPadding(top = padding.top, bottom = padding.bottom, start = padding.left, end = padding.right)
    }

}
