package com.mygdx.game.tableFactory

import com.badlogic.gdx.scenes.scene2d.ui.Table

interface TableFactory {
    fun createTable(): Table
    fun initializeElements(parent: Table): Table

    fun getTable(): Table = initializeElements(createTable())
}