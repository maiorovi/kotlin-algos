package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()

    (0 until t).forEach {
        val number = sc.nextInt()

        println(findDigits(number))
    }
}

fun findDigits(n: Int): Int {
    var counter = 0

    for (ch in n.toString()) {
        val numb = ch.toNumb()

        if (numb != 0 && n % numb == 0) {
            counter += 1
        }
    }

    return counter
}

fun Char.toNumb():Int {
    return Character.getNumericValue(this)
}