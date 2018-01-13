package algorithms

import chapter2.max
import java.util.*

fun main(args: Array<String>):Unit {
    val `in` = Scanner(System.`in`)
    val s = `in`.nextInt()
    val n = `in`.nextInt()
    val m = `in`.nextInt()
    val keyboards = IntArray(n)
    for (keyboards_i in 0 until n) {
        keyboards[keyboards_i] = `in`.nextInt()
    }
    val drives = IntArray(m)
    for (drives_i in 0 until m) {
        drives[drives_i] = `in`.nextInt()
    }
    //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
    val moneySpent = getMoneySpent(keyboards, drives, s)
    println(moneySpent)
}

fun getMoneySpent(keyboards: IntArray, drives: IntArray, s: Int): Int {
    // Complete this function
    var maxSum = -1

//    keyboards.forEach { k ->
//        drives.forEach { d ->
//          maxSum = if (k + d <= s && k + d > maxSum) k + d else maxSum
//        }
//    }
return 0
}
