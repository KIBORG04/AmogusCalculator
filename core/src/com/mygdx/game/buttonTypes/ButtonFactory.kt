package com.mygdx.game.buttonTypes

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton

class ButtonFactory {

    fun createButton(buttonType: ButtonVariant, skin: Skin): TextButton {
        val button = TextButton(buttonType.name, skin)

        val inputListener: InputListener = object : InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                buttonType.touchDown()
                return false
            }
        }

        button.addListener(inputListener)

        return button
    }

}