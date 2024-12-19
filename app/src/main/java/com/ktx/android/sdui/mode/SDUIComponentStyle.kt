package com.ktx.android.sdui.mode

import com.ktx.android.sdui.Padding

interface SDUIComponentStyle {

    val width: Int
    val height: Int
    val minWidth: Int ?
    val maxWidth: Int ?
    val minHeight: Int ?
    val maxHeight: Int ?

    val padding: Padding
    val borderRadius: Int
    val backgroundColor: String

}