import java.util.*

/**
 * Created by nuno on 18-04-2021.
 */

fun less(v: Int, w: Int): Boolean {
    return v - w < 0
}

fun exch(array: IntArray, i: Int, j: Int) {
    val t = array[i]
    array[i] = array[j]
    array[j] = t
}

fun sort(array: IntArray, hSize: Int) {
    val heapSortObject = HeapSort(array, hSize)
    heapSortObject.heapSort()
}

data class HeapSort(var array: IntArray, val hSize: Int)


fun HeapSort.heapSort() {
    // Transform array into a heap
    buildHeap(array, hSize) // O(N)
    var n = hSize
    // Sort using exchange and heapify operations
    while (n > 0) {
        // Exchange root (the maximum) with the last element
        exch(array, 0, n - 1)
        // Max-heapify the first element (the new root), putting it to order
        maxHeapify(array, --n, 0)
    }
}

/////////////////////////////////////////////
// Heap operations
//
/**
 * buildHeap - Executes O(size) operations
 *
 * @param array
 * @param hSize
 * @param <E>
</E> */
private fun buildHeap(array: IntArray, hSize: Int) {
    // Get last element's parent, max-heapify it, and continue to the other parents,
    // from right to left and bottom to top
    for (idxParent in hSize / 2 - 1 downTo 0) {
        maxHeapify(array, hSize, idxParent)
    }
}

/**
 * Top-down heapify (sink)
 *
 * @param array
 * @param hSize
 * @param k
 * @param <E>
</E> */
private fun maxHeapify(array: IntArray, hSize: Int, k: Int) {
    // Get index of left descendant
    var k = k
    var idxLeftChild = 2 * k + 1
    var idxRightChild: Int
    // If there exists a left descendant
    while (idxLeftChild < hSize) {
        // Get index of right descendant
        idxRightChild = idxLeftChild + 1
        // Get the largest index of the left and right descendants
        if (idxRightChild < hSize && less(array[idxLeftChild], array[idxRightChild]))
            idxLeftChild = idxRightChild
        // If the largest descendant is not greater than the parent, stop (the heap is ordered)
        if (!less(array[k], array[idxLeftChild]))
            break
        // Else, exchange the largest descendant by its parent
        exch(array, k, idxLeftChild)
        // Set the next parent to be the left descendant
        k = idxLeftChild
        // Update left descendant
        idxLeftChild = 2 * k + 1
    }
}

/////////////////////////////////////////////
/// TEST
fun main() {
    val array = intArrayOf(8, 10, 1, 9, 4, 7, 3, 5, 6, 2)
    println("Original array: " + Arrays.toString(array))
    sort(array, array.size)
    println("After sorting: " + Arrays.toString(array))
}












