package com.bot.nova.mode

enum class ComponentType(val type: String) {

    TEXT("text"),
    INPUT("input"),
    IMAGE("image"),
    BUTTON("button"),

    STACK("zStack"),
    Vertical("vStack"),
    HORIZONTAL("hStack"),
    SCROLLVIEW("scrollView"),

}