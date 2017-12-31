package chapter2

import chapter2.Color.*

fun getMnemonic(color: Color) =
        when(color) {
            RED -> "Richard"
            ORANGE -> "Of"
            YELLOW -> "York"
            GREEN -> "Gave"
            BLUE -> "Battle"
            INDIGO -> "In"
            VIOLET -> "Vain"
        }

fun getWarmgth(color: Color) =
        when(color) {
            RED, ORANGE, YELLOW -> "warm"
            GREEN -> "neutral"
            BLUE, INDIGO, VIOLET -> "colod"
        }

fun mix(c1: Color, c2:Color) =
        when(setOf(c1, c2)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO

            else -> throw Exception("dirty color")
        }