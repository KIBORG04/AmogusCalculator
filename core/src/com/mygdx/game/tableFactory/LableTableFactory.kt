package com.mygdx.game.tableFactory

import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.mygdx.game.Calculator

class LabelTableFactory(private val calculator: Calculator) : TableFactory {
    override fun createTable(): Table {
        val labelTable = Table()

        val cell = labelTable.defaults()
        cell.width(calculator.WIDTH - 10)
        cell.height(calculator.HEIGHT / 6 - 10)
        labelTable.setPosition(calculator.WIDTH / 2, calculator.HEIGHT - 45)

        return labelTable
    }

    override fun initializeElements(parent: Table): Table {
        parent.add(calculator.label)
        return parent
    }

}