package aula05

fun main() {
    val arr = intArrayOf(5, 1, 10, 6, 2, 8, 3, 7)

    println("Before sorting")
    println(arr.asList())

    mergeSort(arr, 0, arr.size - 1)

    println("After sorting")
    println(arr.asList())
}