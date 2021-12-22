package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.utils.ScreenUtils
import com.mygdx.game.buttonTypes.ButtonFactory
import com.mygdx.game.buttonTypes.ButtonTypes


class Calculator : ApplicationAdapter() {
    private val background: Texture by lazy { Texture("amogus_back.png") }
    private val skin: Skin by lazy { Skin(Gdx.files.internal("data/uiskin.json")) }

    private val batch: SpriteBatch by lazy { SpriteBatch() }
    private val camera: OrthographicCamera by lazy { OrthographicCamera() }

    private val stage: Stage by lazy { Stage() }
    private val mainTable: Table by lazy { Table() }

    override fun create() {
        camera.setToOrtho(false, 350f, 512f)

        Gdx.input.inputProcessor = stage;

        mainTable.setFillParent(true)
        mainTable.debug = true

        val buttonFactory = ButtonFactory()
        
        val button = buttonFactory.createButton(ButtonTypes().digitButtons.oneButtonStyle, skin)
        button.addListener(object : InputListener() {
            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                println("touchDown 1")
                return false
            }
        })
        mainTable.add(button)

        stage.addActor(mainTable)
    }

    override fun render() {
        ScreenUtils.clear(0.75f, 0.75f, 0.75f, 1f)
        stage.act(Gdx.graphics.deltaTime);
        stage.draw();

        camera.update()

       // batch.projectionMatrix = camera.combined

      //  batch.begin()
      //  batch.draw(background, 0f, 0f, 350f, 512f)
      //  batch.end()
    }

    override fun dispose() {
        stage.dispose();
        batch.dispose()
        background.dispose()
    }
}

