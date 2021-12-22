package com.mygdx.game.buttonTypes

interface ButtonVariant {
    val name: String
    val category: Categories

    fun touchDown() {}

}

interface DigitButtonVariant : ButtonVariant {
    override val category: Categories
        get() = Categories.DIGIT

    override fun touchDown() {
        println(name)
    }

}

interface MarkButtonVariant : ButtonVariant {
    override val category: Categories
        get() = Categories.MARK

    override fun touchDown() {
        println(name)
    }
}