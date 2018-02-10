package algorithms

import java.util.*

data class MyDate(val day: Int, val month: Int, val year: Int)


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val returnedDate = MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt())
    val expectedDate = MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt())

    println(calculateFine(returnedDate, expectedDate))
}

fun calculateFine(returnedMyDate: MyDate, expectedReturnMyDate: MyDate): Int {
   val year = expectedReturnMyDate.year - returnedMyDate.year
    val month = expectedReturnMyDate.month - returnedMyDate.month
    val day = expectedReturnMyDate.day - returnedMyDate.day

    if(year < 0) {
        return 10000
    } else if (year > 0) {
        return 0
    }

    if (month < 0) {
        return 500 * Math.abs(month)
    } else if (month > 0) {
        return 0
    }

    if (day < 0) {
        return 15 * Math.abs(day)
    }

    return 0
}