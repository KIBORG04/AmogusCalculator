package com.mygdx.game.buttonTypes

import com.badlogic.gdx.scenes.scene2d.ui.Label
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager


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

    class BracketLeft : MarkButtonVariant {
        override val name: String = "("
    }

    class BracketRight : MarkButtonVariant {
        override val name: String = ")"
    }

    class Equal : MarkButtonVariant{
        override val name: String = "="

        override fun touchDown(label: Label) {
            val engine: ScriptEngine = ScriptEngineManager().getEngineByName("js")

            try {
                val result: Any = engine.eval(label.text.toString())
                label.setText("$result")
            } catch (e: javax.script.ScriptException) {
                label.setText("AMOGUS!")
            }

        }
    }

    class DelSymbol : MarkButtonVariant {
        override val name: String = "<-"

        override fun touchDown(label: Label) {
            if (label.text.isEmpty){
                return
            }

            val newText = StringBuilder(label.text)
            newText.setLength(label.text.length - 1)
            label.setText("")
            label.setText(newText)
        }
    }

    class Clear : MarkButtonVariant {
        override val name: String = "C"

        override fun touchDown(label: Label) {
            label.setText("")
        }
    }


    val plusButtonStyle = Plus()
    val minusButtonStyle = Minus()
    val multiplyButtonStyle = Multiply()
    val divisionButtonStyle = Division()
    val bracketLeftButtonStyle = BracketLeft()
    val bracketRightButtonStyle = BracketRight()
    val equalButtonStyle = Equal()
    val delSymbolButtonStyle = DelSymbol()
    val clearButtonStyle = Clear()

}
