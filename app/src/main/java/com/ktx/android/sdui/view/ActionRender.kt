package com.ktx.android.sdui.view

import android.util.Log
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import com.ktx.android.sdui.mode.SDUIAction

internal typealias Click = () -> Unit

fun Modifier.actions(
    onClick: Click ? ,
    onLongClick: Click ? ,
    actions: List<SDUIAction> ? ,
): Modifier {
    var onClickUi: Click ? = null
    var onLongClickUi: Click ? = null
    if (actions != null) {
        val onClickX = actions.find { it.event == "onClick" }
        val onLongPressX = actions.find { it.event == "onLongPress" }
        if (onClickX != null) onClickUi = {
            Log.e("Action", "onClickUi")
        }
        if (onLongPressX != null) onLongClickUi = {
            Log.e("Action", "onLongClickUi")
        }
    }
    if (onClick == null && onLongClick == null && onClickUi == null && onLongClickUi == null) {
        return this
    }
    return this then pointerInput(Unit) {
        detectTapGestures(
            onTap = {
                if (onClickUi != null) onClickUi()
                if (onClick != null) onClick()
            },
            onLongPress = {
                if (onLongClickUi != null) onLongClickUi()
                if (onLongClick != null) onLongClick()
            }
        )
    }
}