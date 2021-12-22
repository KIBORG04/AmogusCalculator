package com.mygdx.game.buttonTypes

import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton

class ButtonFactory {

    fun createButton(buttonType: ButtonVariant, skin: Skin): TextButton {
        val style = TextButton.TextButtonStyle(null, null, null, skin.getFont("default-font"))
        return TextButton(buttonType.name, skin)
    }

}