package com.bot.nova.action

data class NovaAction(
    val event: String,
    val target: String ? = null,
    val track: String ? = null,
)