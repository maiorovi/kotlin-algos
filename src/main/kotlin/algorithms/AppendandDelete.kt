package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val initialString = sc.next()
    val targetString = sc.next()
    val targetNumberOfOperations = sc.nextInt()

    val minimalStringAligningOperationsAmount = countOperations(initialString, targetString)

    println(isAlignableInSpecifiedNumberOfOperations(minimalStringAligningOperationsAmount, targetNumberOfOperations, targetString))
}

fun isAlignableInSpecifiedNumberOfOperations(stringAligningOperationsAmount: Int, targetOperationsAmount: Int, target: String) : String {
    val reminderIsEven = (targetOperationsAmount - stringAligningOperationsAmount).rem(2) == 0

    return if ((stringAligningOperationsAmount <= targetOperationsAmount && reminderIsEven) ||
            (target.length * 2 <= targetOperationsAmount) ) "Yes" else "No"
}

fun countOperations(initial: String, target: String): Int {
    val commonPrefixLength = initial.commonPrefixWith(target).length

    val deletions = initial.length - commonPrefixLength
    val insertions = target.length - commonPrefixLength

    return deletions + insertions
}

fun Int.isEven() = this.rem(2) == 0

fun Int.isOdd() = !this.isEven()