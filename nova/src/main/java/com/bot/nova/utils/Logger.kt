package com.bot.nova.utils

import android.util.Log

fun info(message: String) {
    Log.e("nova", "INFO : $message")
}

fun error(message: String) {
    Log.e("nova", "ERROR : $message")
}