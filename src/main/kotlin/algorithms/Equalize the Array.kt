package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    val arr = IntArray(n)

    for (i in 0..arr.lastIndex) {
        arr[i] = sc.nextInt()
    }

    println(countDeletions(arr))
}

fun countDeletions(arr: IntArray): Int {
    val tmp = arr.copyOf()

    tmp.sort()

    var longestSequence = 0
    var currentSequenceLength = 1
    var prevElem = tmp[0]

    for (i in 1..tmp.lastIndex) {
        if(tmp[i] == prevElem) {
            currentSequenceLength++
        } else {
            longestSequence = Math.max(currentSequenceLength, longestSequence)
            prevElem = tmp[i]
            currentSequenceLength = 1
        }
    }

    longestSequence = Math.max(currentSequenceLength, longestSequence)

    return arr.size - longestSequence
}
