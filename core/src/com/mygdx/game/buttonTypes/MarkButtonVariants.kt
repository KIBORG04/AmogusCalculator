package com.mygdx.game.buttonTypes

class MarkButtonVariants {

    class Plus : MarkButtonVariant {
        override val name: String = "+"
    }

    class Minus : MarkButtonVariant {
        override val name: String = "-"
    }

    class Multiply : MarkButtonVariant {
        override val name: String = "*"
    }

    class Division : MarkButtonVariant {
        override val name: String = "/"
    }

    class Equal : MarkButtonVariant {
        override val name: String = "="
    }

    val plusButtonStyle = Plus()
    val minusButtonStyle = Minus()
    val multiplyButtonStyle = Multiply()
    val divisionButtonStyle = Division()
    val equalButtonStyle = Equal()

}
