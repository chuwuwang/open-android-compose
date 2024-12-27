package com.bot.nova.mode

enum class ComponentType(val value: String) {

    TEXT("text"),
    INPUT("input"),
    IMAGE("image"),
    BUTTON("button"),
    SPACER("spacer"),

    ROW("hStack"),
    BOX("zStack"),
    Column("vStack"),
    SCROLLVIEW("scrollView"),

}