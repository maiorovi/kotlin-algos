package chapter4

import com.google.common.base.Stopwatch

class RateLimiter(val ratePerSecond: Int) {
    var lastRequestTimestamp: Long = System.currentTimeMillis()
    val intervalBetweenRequests:Double = 1.div(ratePerSecond.toDouble()) * 1000

    fun isAllowed():Boolean {
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis - lastRequestTimestamp >= intervalBetweenRequests) {
            lastRequestTimestamp = currentTimeMillis
            return true
        } else {
            return false
        }
    }

}

fun main(args:Array<String>) {
    val limiter = RateLimiter(10)
    val stopWatch = Stopwatch.createStarted()
    val map = hashMapOf<Boolean, Int>(true to 0, false to 0)

    (0..1000).forEach {
        Thread.sleep(25)
        val isAllowed = limiter.isAllowed()
        map.computeIfPresent(isAllowed) { bool, u ->  u + 1}
//        println("$it  ${isAllowed}")
    }

    println("elapsed: ${stopWatch.elapsed().toMillis()}")
    println("true amount is: ${map[true]}")
    println("false amount is: ${map[false]}")
}