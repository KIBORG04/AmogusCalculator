package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.ScreenUtils
import com.mygdx.game.tableFactory.ButtonTableFactory
import com.mygdx.game.tableFactory.LabelTableFactory


class Calculator(val HEIGHT: Float, val WIDTH: Float) : ApplicationAdapter() {

    private val background: Texture by lazy { Texture("amogus_back.png") }
    val skin: Skin by lazy { Skin() }

    private val batch: SpriteBatch by lazy { SpriteBatch() }
    private val camera: OrthographicCamera by lazy { OrthographicCamera() }

    lateinit var label: Label

    private val stage: Stage by lazy { Stage() }

    override fun create() {
        camera.setToOrtho(false, WIDTH, HEIGHT)
        setupSkin()
        createLabel()

        Gdx.input.inputProcessor = stage

        stage.addActor(LabelTableFactory(this).getTable())
        stage.addActor(ButtonTableFactory(this).getTable())
    }

    override fun render() {
        ScreenUtils.clear(0.8f, 0.8f, 0.8f,1f)

        camera.update()

        batch.projectionMatrix = camera.combined
        batch.begin()
        batch.draw(background, 0f, 0f, WIDTH, HEIGHT)
        batch.end()

        stage.act(Gdx.graphics.deltaTime)
        stage.draw()

    }

    override fun dispose() {
        stage.dispose()
        batch.dispose()
        background.dispose()
    }

    private fun setupSkin() {
        createFont()
    }

    private fun createFont() {
        val generator = FreeTypeFontGenerator(Gdx.files.internal("data/FixedsysExcelsior3.01Regular.ttf"))
        val parameter = FreeTypeFontParameter()
        parameter.size = 35
        parameter.borderColor = Color.BLACK
        parameter.borderWidth = 2f
        val font35 = generator.generateFont(parameter)
        skin.add("font-button", font35)

        parameter.size = 50
        val font50 = generator.generateFont(parameter)
        skin.add("font-label", font50)

        generator.dispose() // don't forget to dispose to avoid memory leaks!

    }


    private fun createLabel() {
        label = Label("", Label.LabelStyle(skin.getFont("font-label"), null))
        label.wrap = true
        label.setAlignment(Align.right)
    }

}

