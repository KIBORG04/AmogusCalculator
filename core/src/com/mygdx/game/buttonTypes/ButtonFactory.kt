package com.mygdx.game.buttonTypes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable
import com.mygdx.game.Calculator

class ButtonFactory(private val calculator: Calculator) {

    private fun generatePixmap(name: String, color: Color, skin: Skin) {
        if(!skin.has(name, Sprite::class.java)) {
            val pixmap = Pixmap(1, 1, Pixmap.Format.RGBA8888)
            pixmap.setColor(color)
            pixmap.fill()

            val sprite = Sprite(Texture(pixmap))
            sprite.setAlpha(128f)
            skin.add(name, sprite)
        }
    }

    private fun getTextButtonStyle(buttonType: ButtonVariant): TextButtonStyle {
        val style = TextButtonStyle()
        val skin = calculator.skin

        style.font = skin.getFont("font-button")
        if(buttonType.name != "") {
            generatePixmap("${buttonType.name}-button-up", buttonType.colorUp, skin)
            generatePixmap("${buttonType.name}-button-down", buttonType.colorDown, skin)
            generatePixmap("${buttonType.name}-button-over", buttonType.colorOver, skin)

            style.up = SpriteDrawable(skin.getSprite("${buttonType.name}-button-up"))
            style.down = SpriteDrawable(skin.getSprite("${buttonType.name}-button-down"))
            style.over = SpriteDrawable(skin.getSprite("${buttonType.name}-button-over"))
        }
        skin.add("${buttonType.name}-button-style", style)
        return style
    }

    fun createButton(buttonType: ButtonVariant): TextButton {
        val button = TextButton(buttonType.name, getTextButtonStyle(buttonType))

        val inputListener: InputListener = object : InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                buttonType.touchDown(calculator.label)
                return false
            }
        }

        button.addListener(inputListener)

        return button
    }

}