package com.bot.nova.action

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import com.bot.nova.utils.info

fun Modifier.actions(
    onClick: Click ? ,
    onLongPressClick: Click ? ,
    actions: List<NovaAction> ? ,
): Modifier {
    var onClickUi: Click ? = null
    var onLongPressClickUi: Click ? = null
    if (actions != null) {
        val onClickX = actions.find { it.event == "onClick" }
        val onLongPressX = actions.find { it.event == "onLongPress" }
        if (onClickX != null) onClickUi = {
            info("onClickUi")
        }
        if (onLongPressX != null) onLongPressClickUi = {
            info("onLongPressClickUi")
        }
    }
    if (onClick == null && onLongPressClick == null && onClickUi == null && onLongPressClickUi == null) {
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
