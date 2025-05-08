package aula07

fun main() {
    val array : IntArray = intArrayOf(1, 5, 8, 10, 13, 14, 15, 20, 32, 34, 50)

    println("Found 34 at index ${binarySearch(array, 0,array.size - 1, 34)}")

    println("Found 34 at index ${binarySearchRecursive(array, 0,array.size - 1, 34)}")

}