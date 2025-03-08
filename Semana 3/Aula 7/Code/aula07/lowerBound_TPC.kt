package aula07

// T.P.C.

// lower bound - algoritmo da família de binarySearch, devolvendo o índice onde o elemento
// passado em argumento poderia ser adicionado de forma ordenada (a inserção propriamente dita
// não é contemplada neste algoritmo. Apenas indica o índice onde vai ser adicionado). Complexidade O(log2 N).

//fun lowerBound(array: IntArray, left: Int, right: Int, element: Int): Int {
//    // ...
//}
//
//
//fun main() {
//    val array : IntArray = intArrayOf(1, 2, 3, 3, 3, 5, 8)
///*
//Searching for 1 -> index 0, array[0] == 1, elements in indices in [0, index found [ < 1 (1 is the value to search and insert a posteriori)
//Searching for 2 -> index 1, array[1] == 2, elements in indices in [0, index found [ < 2
//Searching for 3 -> index 2, array[2] == 3, elements in indices in [0, index found [ < 3
//Searching for 4 -> index 5, array[5] == 5, ...
//Searching for 5 -> index 5, array[5] == 5
//Searching for 6 -> index 6, array[6] == 8
//Searching for 7 -> index 6, array[6] == 8
//Searching for 8 -> index 6, array[6] == 8
//Searching for 9 -> index 7, past the end, elements in indices in [0, index found [ < 9
//Searching for 10 -> index 7, past the end, elements in indices in [0, index found [ < 10
// */
//    // Example
//    val list : MutableList<Int> = mutableListOf(1, 2, 3, 3, 3, 5, 8)
//
//    // Search for index of the element so that, when inserted, it is ordered
//    val index = lowerBound(list.toIntArray(), 0, list.size - 1, 10)
//
//    list.add(index, 10) // Insert element in order
//    // Test with other elements above
//}