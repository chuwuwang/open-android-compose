package com.bot.nova.mode

import com.bot.nova.action.NovaEvent

interface NovaComponent {

    val id: String

    val type: String

    val event: NovaEvent

}