package aula04

fun main() {
    val arr = charArrayOf('A', 'S', 'O', 'R', 'T', 'I', 'N', 'G', 'E', 'X', 'A', 'M', 'P', 'L', 'E')

    println("Before sorting")
    println(arr.asList())

    insertionSort1(arr, 0, arr.size - 1)

    println("After sorting")
    println(arr.asList())
}