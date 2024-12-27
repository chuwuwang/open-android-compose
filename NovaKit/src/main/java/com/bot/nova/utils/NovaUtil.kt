package com.bot.nova.utils

import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign

internal object NovaUtil {

    fun getTextAlign(align: String): TextAlign {
        if (align == "trailing") {
            return TextAlign.End
        } else if (align == "center") {
            return TextAlign.Center
        }
        return TextAlign.Start
    }

    fun getVerticalAlignment(alignment: String): Alignment.Vertical {
        if ("bottom" == alignment) {
            return Alignment.Bottom
        } else if ("center" == alignment) {
            return Alignment.CenterVertically
        }
        return Alignment.Top
    }

}
