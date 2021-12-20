package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.mygdx.game.MyGdxGame
import com.mygdx.game.buttoVariants.*
import kotlin.reflect.*

fun main() {
    println(ButtonVariant::class.sealedSubclasses)
    println(System.getProperty("java.class.path"))

    val config = LwjglApplicationConfiguration()
    config.title = "Amogus"
    config.resizable = false
    config.width = 350
    config.height = 512

    LwjglApplication(MyGdxGame(), config)
}