package com.ktx.android.sdui.mode

import com.ktx.android.sdui.Padding

data class TextComponent(
    override val id: String,
    override val type: String,

    val text: String,
    val style: TextComponentStyle,
    val actions: List<SDUIAction> ? = null,
) : SDUIComponent

data class TextComponentStyle(
    override val with: Int,
    override val height: Int,
    override val minWidth: Int ? = null,
    override val maxWidth: Int ? = null,
    override val minHeight: Int ? = null,
    override val maxHeight: Int ? = null,
    override val padding: Padding,
    override val borderRadius: Int,
    override val backgroundColor: String,

    val font: String,
    val color: String,
    val textAlign: String,
    val lineLimit: Int ? = null,
) : SDUIComponentStyle