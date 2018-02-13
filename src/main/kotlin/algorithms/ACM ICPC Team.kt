package algorithms

import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val n =sc.nextInt()
    val m = sc.nextInt()

    val intArray = arrayOfNulls<String>(n)

    for (i in 0..intArray.lastIndex) {
        intArray[i] = sc.next()
    }

    var maxTopics: Int = 0
    var counter: Int = 0

    for(i in 0..intArray.lastIndex) {
         for(j in i+1..intArray.lastIndex) {
             if (i != j) {
                 val xorResult = xorStr(intArray[i]!!, intArray[j]!!)
                 val currentMax = onesNumber(xorResult)
                 maxTopics = Math.max(maxTopics, currentMax)
             }

        }
    }

    for(i in 0..intArray.lastIndex) {
        for(j in i+1..intArray.lastIndex) {
            if (i != j) {
                val xorResult = xorStr(intArray[i]!!, intArray[j]!!)
                val currentMax = onesNumber(xorResult)
                if (currentMax == maxTopics) counter++
                maxTopics = Math.max(maxTopics, currentMax)
            }

        }
    }

    println(maxTopics)
    println(counter)
}

fun xorStr(x: String, y:String):String {
    val buffer = StringBuffer()

    for (i in 0..x.lastIndex) {
        val result = if (x[i] == '1') '1' else y[i]

        buffer.append(result)
    }

    return buffer.toString()
}

fun onesNumber(x:String): Int = x.filter { it == '1' }.length