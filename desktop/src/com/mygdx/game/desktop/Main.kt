package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.mygdx.game.Calculator

const val HEIGHT = 512
const val WIDTH = 350

fun main() {
    val config = Lwjgl3ApplicationConfiguration()
    config.setTitle("Amogus")
    config.setResizable(false)
    config.setWindowedMode(WIDTH, HEIGHT)
    config.setWindowIcon("amogus_application_icon.png")

    Lwjgl3Application(Calculator(HEIGHT.toFloat(), WIDTH.toFloat()), config)
}