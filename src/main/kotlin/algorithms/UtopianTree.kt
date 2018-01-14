package algorithms

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val testCasesAmount = scanner.nextInt()
    val answers = IntArray(testCasesAmount)

    (0 until testCasesAmount).forEach {
        answers[it] = countHiehgtOfTree(scanner.nextInt())
    }

    answers.forEach { println(it) }
}

fun countHiehgtOfTree(cycles:Int): Int {
    val initialHeight = 1

    return (1..cycles).fold(initialHeight) {acc, elem  ->
        if (elem % 2 != 0) {
            acc * 2
        } else {
            acc + 1
        }
    }
}