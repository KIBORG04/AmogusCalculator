package com.mygdx.game.tableFactory

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.mygdx.game.Calculator
import com.mygdx.game.buttonTypes.ButtonFactory
import com.mygdx.game.buttonTypes.ButtonTypes

class ButtonTableFactory(private val calculator: Calculator) : TableFactory {
    private val buttonByRow: Int = 4
    private val buttonByColumn: Int = 6

    override fun createTable(): Table {
        val buttonTable = Table()

        val cell = buttonTable.defaults()
        cell.width(calculator.WIDTH / buttonByRow)
        cell.height(calculator.HEIGHT / buttonByColumn)
        buttonTable.setPosition(calculator.WIDTH / 2, calculator.HEIGHT / 2 - 50)

        return buttonTable
    }

    override fun initializeElements(parent: Table): Table {
        val buttonFactory = ButtonFactory(calculator)
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
            parent.add(button)

            if(i % buttonByRow == 0) {
                parent.row()
            }
            i++
        }

        return parent
    }
}
