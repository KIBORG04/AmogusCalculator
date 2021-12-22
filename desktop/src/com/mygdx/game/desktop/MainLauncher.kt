package com.mygdx.game.desktop

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.mygdx.game.Calculator


fun main() {

    val config = Lwjgl3ApplicationConfiguration()
    config.setTitle("Amogus")
    config.setResizable(false)
    config.setWindowedMode(350, 512)
    config.setWindowIcon("amogus_application_icon.png")

    Lwjgl3Application(Calculator(), config)
}