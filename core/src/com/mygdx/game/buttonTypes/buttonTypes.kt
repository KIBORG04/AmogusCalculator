package com.mygdx.game.buttonTypes

object ButtonTypes {
    val digitButtons = DigitButtonVariants()
    val markButtons = MarkButtonVariants()

    val emptyButtonStyle = EmptyButtonStyle()

    class EmptyButtonStyle : ButtonVariant {
        override val name: String = ""
        override val category: Categories = Categories.ABSTRACT
    }

}