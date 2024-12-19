package com.bot.nova.action

data class NovaEvent(
    var onClick: Click ? = null,
    var onDoubleClick: Click ? = null,
    var onLongPressClick: Click ? = null,
)