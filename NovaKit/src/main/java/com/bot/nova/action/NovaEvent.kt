package com.bot.nova.action

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import com.bot.nova.utils.info

typealias Click = () -> Unit

typealias ComposeClick = (Offset) -> Unit

data class NovaEvent(
    var onClick: Click ? = null,
    var onDoubleClick: Click ? = null,
    var onLongPress: Click ? = null,
    var onChange: Click ? = null,
    var onAppear: Click ? = null,
    var onDisappear: Click ? = null,
)

fun Modifier.event(event: NovaEvent): Modifier {
    val onClick = event.onClick
    val onDoubleClick = event.onDoubleClick
    val onLongPressClick = event.onLongPress
    if (onClick == null && onDoubleClick == null && onLongPressClick == null) {
        return this
    }
    var onTap: ComposeClick ? = null
    if (onClick != null) {
        onTap = {
            onClick.invoke()
            info("Server onClick() trigger")
        }
    }
    var onDoubleTap: ComposeClick ? = null
    if (onDoubleClick != null) {
        onDoubleTap = { onDoubleClick.invoke() }
    }
    var onLongPress: ComposeClick ? = null
    if (onLongPressClick != null) {
        onLongPress = {
            onLongPressClick.invoke()
            info("Server onLongPress() trigger")
        }
    }
    return this then pointerInput(Unit) {
        detectTapGestures(onTap = onTap, onDoubleTap = onDoubleTap, onLongPress = onLongPress)
    }
}