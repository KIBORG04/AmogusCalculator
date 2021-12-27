package com.mygdx.game.buttonTypes

import com.badlogic.gdx.graphics.Color

class DigitButtonVariants {

    class Zero : DigitButtonVariant {
        override val name: String = "0"

        override val colorUp: Color = Color.GRAY
        override val colorDown: Color = Color.BLACK
        override val colorOver: Color = Color.DARK_GRAY
    }

    class One : DigitButtonVariant {
        override val name: String = "1"

        override val colorUp: Color = Color.YELLOW
        override val colorDown: Color = Color.ORANGE
        override val colorOver: Color = Color.GOLD
    }

    class Two : DigitButtonVariant {
        override val name: String = "2"

        override val colorUp: Color = Color.GREEN
        override val colorDown: Color = Color.LIME
        override val colorOver: Color = Color.CHARTREUSE
    }

    class Three : DigitButtonVariant {
        override val name: String = "3"

        override val colorUp: Color = Color.ROYAL
        override val colorDown: Color = Color.NAVY
        override val colorOver: Color = Color.BLUE
    }

    class Fourth : DigitButtonVariant {
        override val name: String = "4"
    }

    class Five : DigitButtonVariant {
        override val name: String = "5"
    }

    class Six : DigitButtonVariant {
        override val name: String = "6"
    }

    class Seven : DigitButtonVariant {
        override val name: String = "7"
    }

    class Eight : DigitButtonVariant {
        override val name: String = "8"
    }

    class Nine : DigitButtonVariant {
        override val name: String = "9"
    }

    val zeroButtonStyle = Zero()
    val oneButtonStyle = One()
    val twoButtonStyle = Two()
    val threeButtonStyle = Three()
    val fourthButtonStyle = Fourth()
    val fiveButtonStyle = Five()
    val sixButtonStyle = Six()
    val sevenButtonStyle = Seven()
    val eightButtonStyle = Eight()
    val nineButtonStyle = Nine()

}
