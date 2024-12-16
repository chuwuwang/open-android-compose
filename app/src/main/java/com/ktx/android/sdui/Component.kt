package com.ktx.android.sdui

import androidx.compose.ui.geometry.CornerRadius

data class Component(
    val view: String,
    val id: String ? = null,
    val width: Float ? = null,
    val height: Float ? = null,
    val color: String ? = null,
    val padding: Padding ? = null,
    val alignment: String ? = null,
    val background: String ? = null,

    val widget: Int ? = null,
    val radius: Float ? = null,
    val alpha: Float ? = null,

    val fontSize: Float ? = null,
    val fontStyle: String ? = null,
    val fontFamily: String ? = null,
    val textEllipsize: String ? = null,

    val text: String ? = null,

    val imageType: String ? = null,

    val hintText: String ? = null,
    val hintTextColor: String ? = null,
    val inputType: String ? = null,
    val maxLines: String ? = null,
    val maxLength: String ? = null,

    val action: String ? = null,

    val enable: Boolean = true,

    val props: Map<String, Any>,
    val children: List<Component>
)

// version platform

data class Padding(
    val left: Int = 0,
    val top: Int = 0,
    val right: Int = 0,
    val bottom: Int = 0
)

// alignment -  start, center, end, horizontal center, vertical center