package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()

    val arr = IntArray(n)

    (0 until n).forEach { arr[it] = sc.nextInt() }

    println(calculateLeftEnergy(arr, k))
}

fun calculateLeftEnergy(arr: IntArray, k: Int): Int {
    var initialEnergy = 100
    for(i in 0 until arr.size step k) {
        initialEnergy -= calculateEnergyLossForCloud(arr[i])
    }

//    if(arr.size % k != 0) initialEnergy -= 1

    return initialEnergy
}

fun calculateEnergyLossForCloud(cloudType: Int) = if (cloudType == 1) 3 else 1