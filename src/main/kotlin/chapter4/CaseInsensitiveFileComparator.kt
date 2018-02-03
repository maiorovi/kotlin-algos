package chapter4

import java.io.File

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, true)
    }
}


fun main(args:Array<String>) {
    val files = listOf(File("/Z"), File("/a"))
    files.sortedWith(CaseInsensitiveFileComparator)
}
