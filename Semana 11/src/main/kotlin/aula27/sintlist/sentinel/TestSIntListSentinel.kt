package aula27.sintlist.sentinel

import aula27.sintlist.sentinel.SIntListSentinel

fun main() {
    // Test addFront and removeFront
    val list = SIntListSentinel() // With sentinel
    for (i in 0 until 10) {
        list.addFront(i)
    }

    while (!list.isEmpty()) {
        print("${list.removeFront()} ") // 9 8 7 6 5 4 3 2 1 0
    }
    // Test insert
    val list1 = SIntListSentinel()
    for (i in 0 until 10) {
        list1.insert(i, i) // 0 1 2 3 4 5 6 7 8 9
    }
    list1.insert(16, 4)

    println()
    while (!list1.isEmpty()) {
        print("${list1.removeFront()} ") // 0 1 2 3 16 4 5 6 7 8 9
    }


}













