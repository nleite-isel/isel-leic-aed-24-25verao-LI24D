package aula01

data class Triple(val left: Int, val right: Int, val sum: Double)


/**
 * This solution is quadratic.
 * @param array The changes of prices in consecutive days
 * @param left The first day to consider
 * @param right The last day to consider
 * @return An object which describes what is the subarray (array,l,r) where the sum is maximum within the subarray (array,left,right)
 */
//TPC aula prática
fun maximumSubArrayQuadratic(array: DoubleArray, left: Int, right: Int): Triple {
    var l = left
    var r = left
    var bestSum = array[l]
    var actualSum: Double
    for (i in left..right) {
        actualSum = 0.0
        for (j in i..right) {
            actualSum += array[j]
            if (bestSum < actualSum) { //it case of more than one solution, it keeps the first one.
                bestSum = actualSum
                r = j
                l = i
            }
        }
    }
    return Triple(l, r, bestSum)
}

/**
 * This solution is linear (N).
 * Kadane Algorithm
 * @param array The changes of prices in consecutive days
 * @param left The first day to consider
 * @param right The last day to consider
 * @return An object which describes what is the subarray (array,l,r) where the sum is maximum within the subarray (array,left,right)
 */
fun maximumSubArrayLinear(array: DoubleArray, left: Int, right: Int): Triple {

    // TODO
    
}
