package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.mygdx.game.Calculator

fun main() {

    val config = LwjglApplicationConfiguration()
    config.title = "Amogus"
    config.resizable = false
    config.width = 350
    config.height = 512

    LwjglApplication(Calculator(), config)
}