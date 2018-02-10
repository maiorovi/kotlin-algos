package algorithms

import algorithms.hackerrank.CountingValleys
import chapter6.sendEmailTo
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()
    val arr = IntArray(n)

    (0 until n).forEach { arr[it] = sc.nextInt() }

    println(findSizeOfLargestSubset(arr, k).size)

}

data class Value(val count: Int, val key: Int) {
    fun incrementCount():Value = Value(count+1, key)
}

fun findSizeOfLargestSubset(arr:IntArray, k: Int): Set<Int> {
    if(k == 1){
        return setOf(1)
    }

    if (k == 2) {
        return setOf(1, 0)
    }


    val result = mutableSetOf<Int>()
    val reminders = arr.map { it % k }
    val m = groupByReminder(reminders)

    val forbiddenReminders = mutableSetOf<Int>()

    val skippedRimender = if (k % 2 == 0) k / 2 else -1

    val orderedReminders = m.values.sortedWith(compareByDescending {it.count}).filter {
        it ->

        val contains = !(forbiddenReminders.contains(it.key))
        if(contains) forbiddenReminders.add(k - it.key)

        contains && it.key != 0 && (it.key != skippedRimender)
    }.map {it.key} .toSet()

    var seenZeroReminder = false
    var seenP = false

    for(elem in arr) {
        val r = elem % k
        if (orderedReminders.contains(r)) {
            result.add(elem)
        }

        if (!seenZeroReminder && r == 0) {
           result.add(elem)
            seenZeroReminder = true
        }

        if (k % 2 == 0 && elem % 2 == 0 && !seenP) {
            result.add(elem)
            seenP = true
        }
    }


    return result
}


fun groupByReminder(reminders: List<Int>): Map<Int, Value> {
    val m = hashMapOf<Int, Value>()

    for(elem in reminders) {
        m.putIfAbsent(elem, Value(1, elem))
        m.computeIfPresent(elem) { key, value -> value.incrementCount()}
    }

    return m
}
