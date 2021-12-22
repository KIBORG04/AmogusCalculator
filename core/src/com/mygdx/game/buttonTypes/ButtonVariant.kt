package com.mygdx.game.buttonTypes

interface ButtonVariant {
    val name: String
    val category: Categories
}

interface DigitButtonVariant : ButtonVariant {
    override val category: Categories
        get() = Categories.DIGIT
}

interface MarkButtonVariant : ButtonVariant {
    override val category: Categories
        get() = Categories.MARK
}