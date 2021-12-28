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
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.ScreenUtils
import com.mygdx.game.buttonTypes.ButtonFactory
import com.mygdx.game.buttonTypes.ButtonTypes


class Calculator(private val HEIGHT: Float, private val WIDTH: Float) : ApplicationAdapter() {

    private val background: Texture by lazy { Texture("amogus_back.png") }
    val skin: Skin by lazy { Skin() }

    private val batch: SpriteBatch by lazy { SpriteBatch() }
    private val camera: OrthographicCamera by lazy { OrthographicCamera() }
    lateinit var label: Label

    private val stage: Stage by lazy { Stage() }
    private val buttonTable: Table by lazy { Table() }
    private val labelTable: Table by lazy { Table() }

    // TODO: New class for button configuration and initialization
    private val buttonByRow: Int = 4
    private val buttonByColumn: Int = 6

    override fun create() {
        camera.setToOrtho(false, WIDTH, HEIGHT)
        setupSkin()

        Gdx.input.inputProcessor = stage

        var cell = buttonTable.defaults()
        cell.width(WIDTH / buttonByRow)
        cell.height(HEIGHT / buttonByColumn)
        buttonTable.setPosition(WIDTH / 2, HEIGHT / 2 - 50)

        cell = labelTable.defaults()
        cell.width(WIDTH - 10)
        cell.height(HEIGHT / buttonByColumn - 10)
        labelTable.setPosition(WIDTH / 2, HEIGHT - 45)

        createLabel()
        initializeButtons()

        stage.addActor(labelTable)
        stage.addActor(buttonTable)
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
        labelTable.add(label)
    }

    private fun initializeButtons() {
        val buttonFactory = ButtonFactory(this)
        val buttonList = mutableSetOf<TextButton>()

        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.equalButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.emptyButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.delSymbolButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.clearButtonStyle))

        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.sevenButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.eightButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.nineButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.divisionButtonStyle))

        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.fourthButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.fiveButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.sixButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.multiplyButtonStyle))

        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.oneButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.twoButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.threeButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.minusButtonStyle))

        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.bracketLeftButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.digitButtons.zeroButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.bracketRightButtonStyle))
        buttonList.add(buttonFactory.createButton(ButtonTypes.markButtons.plusButtonStyle))

        var i = 1
        for(button in buttonList) {
            buttonTable.add(button)

            if(i % buttonByRow == 0) {
                buttonTable.row()
            }

            i++
        }

    }
}

