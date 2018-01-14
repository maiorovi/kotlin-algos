package algorithms

import java.util.*
import java.util.regex.Pattern

fun main(args:Array<String>) {
    val scanner = Scanner(System.`in`)
    val pattern = Pattern.compile("\\d{4}")

    val year = scanner.next(pattern)

    println(programmerDay(year))
}

fun programmerDay(year:String): String {
    if (year == "1918") {
        return "26.09.1918"
    }

    val februaryDates = if (isLeapYear(year)) { 29 } else {28}
    val dates = listOf(31 , februaryDates, 31, 30, 31, 30, 31, 31)

    val sum = dates.sum()
    val monthes = 9
    val days = 256 - sum

    return "$days.0$monthes.$year"
}

fun isLeapYear(year:String):Boolean {
    val intYear = year.toInt()
    return if (intYear > 1917 ) {
        (intYear % 4 == 0 &&  intYear % 100 != 0) || intYear % 400 == 0
    } else {
        intYear % 4 == 0
    }
}