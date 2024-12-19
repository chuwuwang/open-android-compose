package com.bot.nova.action

data class NovaAction(
    val event: String,
    val target: String,
)

internal typealias Click = () -> Unit