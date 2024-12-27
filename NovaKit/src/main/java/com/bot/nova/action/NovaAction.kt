package com.bot.nova.action

import android.content.Context
import android.widget.Toast

object NovaAction {

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}