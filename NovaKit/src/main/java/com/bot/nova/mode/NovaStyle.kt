package com.bot.nova.mode

interface NovaStyle {

  val width: Int
  val height: Int
  val minWidth: Int ?
  val maxWidth: Int ?
  val minHeight: Int ?
  val maxHeight: Int ?

  val margin: NovaMargin
  val padding: NovaPadding
  val borderRadius: Int
  val backgroundColor: String

}