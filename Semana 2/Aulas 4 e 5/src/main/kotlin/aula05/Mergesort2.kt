package aula05

import aula04.less

////////////////////////////////////////////////////////
//
// Implementation #2 - uses an aux array inside merge
//
///////////////////////////////////////////////////////
/**
 *
 * @param array
 * @param left
 * @param mid
 * @param right
 */
fun merge2(array: IntArray, left: Int, mid: Int, right: Int) {
    var i: Int
    var j: Int
    // Auxiliary array
    val aux = IntArray(array.size)
    // Copy original array to auxiliary array,
    // but invert the right part (see Figure 8.1),
    // in order to eliminate the need for limit tests
    i = mid + 1
    while (i > left) {
        aux[i - 1] = array[i - 1]
        i--
    }
    j = mid
    while (j < right) {
        aux[right + mid - j] = array[j + 1]
        j++
    }
    for (k in left..right) {
        if (less(aux[j], aux[i]))
            array[k] = aux[j--]
        else
            array[k] = aux[i++]
    }
}





