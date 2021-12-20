package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils


class MyGdxGame : ApplicationAdapter() {
    private val background: Texture by lazy { Texture("amogus_back.png") }

    private val batch: SpriteBatch by lazy { SpriteBatch() }
    private val camera: OrthographicCamera by lazy { OrthographicCamera() }

    override fun create() {
        camera.setToOrtho(false, 350f, 512f)
    }

    override fun render() {
        ScreenUtils.clear(0.75f, 0.75f, 0.75f, 1f)

        camera.update()

        batch.projectionMatrix = camera.combined

        batch.begin()
        batch.draw(background, 0f, 0f, 350f, 512f)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        background.dispose()
    }
}

