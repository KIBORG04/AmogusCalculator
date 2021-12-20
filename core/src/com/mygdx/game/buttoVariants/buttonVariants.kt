package com.mygdx.game.buttoVariants

enum class Categories {
    DIGIT, MARK
}

interface ButtonVariant {
    val name: String
    val category: Categories
}

class One : ButtonVariant {
    override val name = "One"
    override val category: Categories = Categories.DIGIT
}

class Two : ButtonVariant {
    override val name = "Two"
    override val category: Categories = Categories.DIGIT
}