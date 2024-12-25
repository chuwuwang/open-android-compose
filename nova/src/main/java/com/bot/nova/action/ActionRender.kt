package com.bot.nova.action

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput

fun Modifier.actions(onClick: Click ? = null, onLongPressClick: Click ? = null, actions: List<NovaAction> ? = null): Modifier {
    var preBuiltClick: Click ? = null
    var preBuiltLongPressClick: Click ? = null
    if (actions != null) {
        val click = actions.find { it.event == "onClick" }
        val longPress = actions.find { it.event == "onLongPress" }
        if (click != null) preBuiltClick = {
            error("Server onClick() trigger")
        }
        if (longPress != null) preBuiltLongPressClick = {
            error("Server onLongPress() trigger")
        }
    }
    if (onClick == null && onLongPressClick == null && preBuiltClick == null && preBuiltLongPressClick == null) {
        return this
    }
    return this then pointerInput(Unit) {
        detectTapGestures(
            onTap = {
                if (onClickUi != null) onClickUi()
                if (onClick != null) onClick()
            },
            onLongPress = {
                if (onLongPressClickUi != null) onLongPressClickUi()
                if (onLongPressClick != null) onLongPressClick()
            }
        )
    }
}
