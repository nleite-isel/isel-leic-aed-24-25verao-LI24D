package aula28.dlist

import aula28.dlist.generic.DList

// # Test 1
fun main1() {
    // List1
    val list1 = DList<Int>()
    // addLast
    for (i in 0 until 5) {
        list1.addLast(i)
    }
    // List2
    val list2 = DList<Int>()
    // addLast
    for (i in 3 until 7) {
        list2.addLast(i)
    }
    // Print lists contents
    list1.print() // 0 1 2 3 4
    println()
    list2.print() // 3 4 5 6
    println()

    var listRes =
        merge<Int>(list1.list!!, list2.list!!, { v1: Int, v2: Int -> v1 - v2 }) // We can pass a lambda function
    // for the Comparator

    val mergeList = DList<Int>()
    // Set sentinel reference of mergeList with listRes
    mergeList.list = listRes
    mergeList.print() // 0 1 2 3 3 4 4 5 6
    println()
}

////////////////////////////////////////////
// # Test 2
fun main() {
    // List1
    val list1 = DList<Int>()
    // addLast
    list1.addLast(1)
    list1.addLast(3)
    list1.addLast(5)
    list1.addLast(10)

    // List2
    val list2 = DList<Int>()
    // addLast
    list2.addLast(2)
    list2.addLast(3)
    list2.addLast(4)
    list2.addLast(5)
    list2.addLast(7)
    list2.addLast(8)

    // Print lists contents
    list1.print() //
    println()
    list2.print() //
    println()

    var listRes =
        merge<Int>(list1.list!!, list2.list!!, { v1: Int, v2: Int -> v1 - v2 }) // We can pass a lambda function
    // for the Comparator

    val mergeList = DList<Int>()
    // Set sentinel reference of mergeList with listRes
    mergeList.list = listRes
    mergeList.print() //
    println()

/*
1 3 5 10
2 3 4 5 7 8
1 2 3 3 4 5 5 7 8 10
 */

}























