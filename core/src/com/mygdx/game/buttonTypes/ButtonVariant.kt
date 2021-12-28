package com.mygdx.game.buttonTypes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label

interface ButtonVariant {
    val name: String
    val category: Categories

    val colorUp: Color
        get() = Color.WHITE
    val colorDown: Color
        get() = Color.DARK_GRAY
    val colorOver: Color
        get() = Color.LIGHT_GRAY

    val background: Image
        get() = Image()

    fun touchDown(label: Label) { }

}

interface DigitButtonVariant : ButtonVariant {
    override val category: Categories
        get() = Categories.DIGIT

    override fun touchDown(label: Label) {
        label.setText("${label.text}$name")
    }
}

interface MarkButtonVariant : ButtonVariant {
    override val category: Categories
        get() = Categories.MARK

    override fun touchDown(label: Label) {
        label.setText("${label.text}$name")
    }
}