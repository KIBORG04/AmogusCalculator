package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
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

        Gdx.input.inputProcessor = stage

        val cell = mainTable.defaults()
        cell.width(87.5f)
        cell.height(95f)

        mainTable.setSize(350f, 450f)
        //mainTable.debug = true

        initializeButtons()

        stage.addActor(mainTable)
    }

    override fun render() {
        ScreenUtils.clear(0.75f, 0.75f, 0.75f, 1f)
        stage.act(Gdx.graphics.deltaTime)

        camera.update()

        batch.projectionMatrix = camera.combined
        batch.begin()
        batch.draw(background, 0f, 0f, 350f, 512f)
        batch.end()

        stage.draw()

    }

    override fun dispose() {
        stage.dispose()
        batch.dispose()
        background.dispose()
    }

    private fun initializeButtons() {
        val buttonFactory = ButtonFactory()
        val buttonList = mutableSetOf<TextButton>()

        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.equalButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.emptyButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.delSymbolButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.clearButtonStyle, skin))

        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.nineButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.eightButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.sevenButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.divisionButtonStyle, skin))

        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.sixButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.fiveButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.fourthButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.multiplyButtonStyle, skin))

        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.threeButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.twoButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.oneButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.minusButtonStyle, skin))

        buttonList.add(buttonFactory.createButton(ButtonTypes.emptyButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.zeroButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.emptyButtonStyle, skin))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.plusButtonStyle, skin))

        var i = 1
        val buttonsByRow = 4
        for(button in buttonList) {
            mainTable.add(button)

            if(i % buttonsByRow == 0) {
                mainTable.row()
            }

            i++
        }

    }
}

