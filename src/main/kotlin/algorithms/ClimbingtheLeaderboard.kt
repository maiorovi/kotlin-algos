package algorithms

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()
    val leaderboard = IntArray(n)

    (0 until n).forEach { leaderboard[it] = scanner.nextInt() }

    val alAm = scanner.nextInt()
    val alice = IntArray(alAm)

    (0 until alAm).forEach { alice[it] = scanner.nextInt() }

    countRank(leaderboard, alice).forEach { println("$it ") }
}

fun countRank(leaderBoard: IntArray, aliceScore: IntArray): IntArray {
    val result = IntArray(aliceScore.size)
    var currentLastRank = 1

    (1 until leaderBoard.size).forEach {
        if (leaderBoard[it - 1] != leaderBoard[it]) {
            currentLastRank++
        }
    }

    currentLastRank += 1
    var position = leaderBoard.lastIndex
    var rank = currentLastRank

    (0..aliceScore.lastIndex).forEach {
        while (leaderBoard[position] < aliceScore[it]) {
            position--
            rank--
        }

        result[it] = rank
    }

    return result
}

