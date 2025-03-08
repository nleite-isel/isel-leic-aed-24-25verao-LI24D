package aula05

import java.util.Arrays

////////////////////////////////////////////////////////
//
// Implementation #1 - uses two aux arrays inside merge
//
///////////////////////////////////////////////////////

fun mergeSort(a: IntArray, left: Int, right: Int) {
    if (left < right) {
        val mid = left + (right - left) / 2 // Equals to (left + right) / 2

        // Sort the left part recursively
        mergeSort(a, left, mid)
        // Sort the right part recursively
        mergeSort(a, mid + 1, right)
        // Merge the sorted left and right parts
        merge(a, left, mid, right)
        // Impl. #2
        //merge2(a, left, mid, right)

        println(Arrays.toString(a))

    }
}

fun merge(a: IntArray, left: Int, mid: Int, right: Int) {
    val dimLeft = mid - left + 1
    val dimRight = right - mid // right - (mid + 1) + 1 = right - mid - 1 + 1 = right - mid
    val leftArray = IntArray(dimLeft)
    val rightArray = IntArray(dimRight)
    for (i in left..mid)
        leftArray[i - left] = a[i]
    for (i in mid + 1..right)
        rightArray[i - mid - 1] = a[i]
    var iLeft = 0
    var iRight = 0
    var iA = left
    while (iLeft < leftArray.size && iRight < rightArray.size) {
        if (leftArray[iLeft] <= rightArray[iRight])
            a[iA] = leftArray[iLeft++]
        else
            a[iA] = rightArray[iRight++]
        iA++
    }
    while (iLeft < leftArray.size) {
        a[iA++] = leftArray[iLeft]
        iLeft++
    }
    while (iRight < rightArray.size) {
        a[iA++] = rightArray[iRight]
        iRight++
    }
}

