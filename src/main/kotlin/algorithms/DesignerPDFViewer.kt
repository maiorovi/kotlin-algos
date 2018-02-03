package algorithms

import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val letterHeightDictionary: HashMap<Char, Int> = HashMap(26)
    val sc = Scanner(System.`in`)

    ('a'..'z').forEach {
        letterHeightDictionary[it] = sc.nextInt()
    }

    val word = sc.next()

    println(findSquare(word = word, dictionary = letterHeightDictionary))

}

fun findSquare(dictionary: HashMap<Char, Int>, word: String): Int {
    val maxHeight = word.map { dictionary.getOrDefault(it, 0) } .fold(0) {acc,y -> Integer.max(acc,y) }
    return maxHeight * word.length * 1
}