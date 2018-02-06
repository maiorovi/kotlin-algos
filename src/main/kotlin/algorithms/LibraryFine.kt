package algorithms

import java.util.*

data class MyDate(val day: Int, val month: Int, val year: Int) {
    fun isBeforeOrEqual(date: MyDate):Boolean {
        val b = date.year >= year
        val b1 = b && date.month >= month
        return (b) ||
                b1 ||
                (date.day >= day && b1)
    }

    fun toDigit():Int {
        return day + month*31 + year*365
    }
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val returnedDate = MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt())
    val expectedDate = MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt())

    println(calculateFine(returnedDate, expectedDate))
}

fun calculateFine(returnedMyDate: MyDate, expectedReturnMyDate: MyDate): Int {
    if(returnedMyDate.isBeforeOrEqual(expectedReturnMyDate)) {
        return 0
    }

    val yearDiff = returnedMyDate.year - expectedReturnMyDate.year
    if (yearDiff > 0) {
        return 10_000
    }

    val monthDiff = returnedMyDate.month - expectedReturnMyDate.month

    if (monthDiff > 0) {
        return 500 * monthDiff
    }

    val dayDiff = returnedMyDate.day - expectedReturnMyDate.day


    return 15 * dayDiff
}