package com.bot.nova.mode

interface NovaComponentStyle {

    val width: Int
    val height: Int
    val minWidth: Int ?
    val maxWidth: Int ?
    val minHeight: Int ?
    val maxHeight: Int ?

    val padding: NovaPadding
    val borderRadius: Int
    val backgroundColor: String

}