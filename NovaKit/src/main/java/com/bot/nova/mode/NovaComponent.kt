package com.bot.nova.mode

interface NovaComponent {

    val id: String
    val type: String

    val callback: Callback?

}

data class Callback(
    val xxx: ()->Unit,
)