package com.bot.nova.action

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput

typealias Click = () -> Unit

typealias ComposeClick = (Offset) -> Unit

data class NovaEvent(
    var onClick: List<Click> = emptyList(),
    var onDoubleClick: List<Click> = emptyList(),
    var onLongPressClick: List<Click> = emptyList(),
)

fun Modifier.event(event: NovaEvent): Modifier {
    val check = event.onClick.isEmpty() && event.onDoubleClick.isEmpty() && event.onLongPressClick.isEmpty()
    if (check) {
        return this
    }
    return this then pointerInput(Unit) {
        detectTapGestures(
            onTap = { event.onClick.forEach { it.invoke() } },
            onDoubleTap = { event.onDoubleClick.forEach { it.invoke() } },
            onLongPress = { event.onLongPressClick.forEach { it.invoke() } }
        )
    }
}