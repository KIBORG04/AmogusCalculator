package com.mygdx.game.buttonTypes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.utils.Null

interface ButtonVariant {
    val name: String
    val category: Categories

    val colorUp: Color
        get() = Color.WHITE
    val colorDown: Color
        get() = Color.DARK_GRAY
    val colorOver: Color
        get() = Color.LIGHT_GRAY

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