package aula02

data class Triple(val left: Int, val right: Int, val sum: Double)


/**
 * This solution is quadratic.
 * @param array The changes of prices in consecutive days
 * @param left The first day to consider
 * @param right The last day to consider
 * @return An object which describes what is the subarray (array,l,r) where the sum is maximum within the subarray (array,left,right)
 */

// TPC
//fun maximumSubArrayQuadratic(array: DoubleArray, left: Int, right: Int): Triple {

//}

// Implementar um teste unitário para o array de teste:
//          13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7
// Índices:  0,  1,   2,  3,  4,   5,   6,  7,  8,  9, 10, 11,  12, 13, 14, 15
// que retorna o triplo (leftIndex, rightIndex, sum) = (7, 10, 43)



/**
 * This solution is linear (N).
 * Kadane Algorithm
 * @param array The changes of prices in consecutive days
 * @param left The first day to consider
 * @param right The last day to consider
 * @return An object which describes what is the subarray (array,l,r) where the sum is maximum within the subarray (array,left,right)
 */

// TPC Aula Pratica (posteriormente)
//fun maximumSubArrayLinear(array: DoubleArray, left: Int, right: Int): Triple {

//}
