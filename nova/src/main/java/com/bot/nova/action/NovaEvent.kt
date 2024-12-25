package com.bot.nova.action

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import com.bot.nova.utils.info

typealias Click = () -> Unit

typealias ComposeClick = (Offset) -> Unit

data class NovaEvent(
//    var onClick: List<Click> = emptyList(),
//    var onDoubleClick: List<Click> = emptyList(),
//    var onLongPressClick: List<Click> = emptyList(),
    var onClick: Click ? = null,
    var onDoubleClick: Click ? = null,
    var onLongPressClick: Click ? = null,
)

fun Modifier.event(event: NovaEvent): Modifier {
//    val check = event.onClick.isEmpty() && event.onDoubleClick.isEmpty() && event.onLongPressClick.isEmpty()
//    if (check) {
//        return this
//    }
//    return this then pointerInput(Unit) {
//        detectTapGestures(
//            onTap = { event.onClick.forEach { it.invoke() } },
//            onDoubleTap = { event.onDoubleClick.forEach { it.invoke() } },
//            onLongPress = { event.onLongPressClick.forEach { it.invoke() } }
//        )
//    }
    val onClick = event.onClick
    val onDoubleClick = event.onDoubleClick
    val onLongPressClick = event.onLongPressClick
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