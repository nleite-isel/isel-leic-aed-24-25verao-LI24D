import java.util.*

/**
 * Created by nuno on 18-04-2021.
 */

/**
 * Priority Queue heap implementation comprised of
 * a Priority queue array
 * and Priority queue size
 */
data class PriorityQueueHeapBased(var pq: CharArray, var size: Int)


/**
 *
 * Build a heap given an array (in non-heap strucuture)
 *
 * @param array Non-empty array
 */
fun PriorityQueueHeapBased.buildFromArray(array: CharArray, size: Int) {
    pq = CharArray(size + 1) // In this implementation, the zero position is not used
    for (i in 0 until size) {
        pq[i + 1] = array[i]
    }
    // Set pq size
    this.size = size
    // Build heap from pq array
    buildHeap()
}

/**
 *
 * @return
 */
fun PriorityQueueHeapBased.empty(): Boolean {
    return size == 0
}

/**
 *
 * @param elem
 */
fun PriorityQueueHeapBased.insert(elem: Char) {
    /// Changed
    pq[size + 1] = elem // Indices start at 1
    // Increment size
    ++size
    // Fix up the heap
    increaseKey(size)
}

/**
 *
 * @return
 */
fun PriorityQueueHeapBased.max(): Char = pq[1]

/**
 *
 * @return
 */
fun PriorityQueueHeapBased.removeMax(): Char {
    // Get max
    val max = pq[1]
    // Set the new root to be the last element
    pq[1] = pq[size]
    // Remake heap from the root
    maxHeapify(1, size - 1)
    // Decrement size
    --size
    // Return the maximum
    return max
}

/////////////////////////////////////////////
// Heap operations
//
/**
 * O(size)
 * Algorithm:
 * 1. Get last element's parent (index = size / 2)
 * 2. max-heapify (sink operation) this parent
 * in order to maintain the heap condition
 * 3. Go the previous parent (--index) and heapify it.
 * 4. Continue in this fashion until reaching the root.
 */
private fun PriorityQueueHeapBased.buildHeap() {
    // Get last element's parent
    var idxParent = size / 2
    while (idxParent >= 1) {
        maxHeapify(idxParent, size)
        // Go to previous parent
        --idxParent
    }
}

/**
 * Bottom-up heapify (swim)
 * @param k
 */
private fun PriorityQueueHeapBased.increaseKey(k: Int) {
    var k = k
    var idxParent: Int
    while (k > 1) {
        // Get parent
        idxParent = k / 2
        // Verify if parent is less than current key index k
        if (!less(pq[idxParent], pq[k])) break // The heap is in order
        // and exchange parent with current key index
        exch(pq, k, idxParent)
        // Set current key index to parent index
        k = idxParent
    }
}

/**
 * Top-down heapify (sink)
 * @param k
 * @param hSize
 */
private fun PriorityQueueHeapBased.maxHeapify(k: Int, hSize: Int) {
    // Get index of left descendant
    var k = k
    var idxLeftChild = 2 * k
    var idxRightChild: Int
    // If there exists a left descendant
    while (idxLeftChild <= hSize) {
        // Get index of right descendant
        idxRightChild = idxLeftChild + 1
        // Get the largest index of the left and right descendants
        if (idxRightChild <= hSize && less(pq[idxLeftChild], pq[idxRightChild]))
            idxLeftChild = idxRightChild
        // If the largest descendant is not greater than the parent, stop (the heap is ordered)
        if (!less(pq[k], pq[idxLeftChild]))
            break
        // Else, exchange the largest descendant by its parent
        exch(pq, k, idxLeftChild)
        // Set the next parent to be the left descendant
        k = idxLeftChild
        // Update left descendant
        idxLeftChild = 2 * k
    }
}

/////////////////////////////////////////////
fun PriorityQueueHeapBased.print() {
    /// Changed
    if (empty()) {
        println("Empty")
        return
    }
    print("Size = $size")
    print(" [")

    // Now, indices start at 1
    for (i in 1 until size) {
        print(pq[i].toString() + ", ")
    }
    print(pq[size])
    println("]")
}

fun main() {
    //
    // MaxPriorityQueueHeapBased
    //

    // 1. Build Priority queue by successive insertion
    // For convenience, indices start at 1. The zero position is not used.
    val capacity = 21
    val pq = PriorityQueueHeapBased(CharArray(capacity), 0)
    val array = charArrayOf('A', 'S', 'O', 'R', 'T', 'I', 'N', 'G', 'E', 'X', 'A', 'M', 'P', 'L', 'E')

    // Insert keys 'A', 'S', 'O', 'R', 'T', 'I', 'N', 'G'  - Figure 9.5
    val size = 8
    for (i in 0 until size) {
        pq.insert(array[i])
    }
    pq.print() // Size = 8 [T, S, O, G, R, I, N, A]

    // Insert keys 'E', 'X', 'A', 'M', 'P', 'L', 'E' - Figure 9.6
    for (i in size until array.size) {
        pq.insert(array[i])
    }
    pq.print() // Size = 15 [X, T, P, G, S, O, N, A, E, R, A, I, M, L, E]

    // 2. Build heap from initial (non-heap) array
    pq.buildFromArray(array, array.size)
    pq.print() // Size = 15 [X, T, P, G, S, O, N, A, E, R, A, I, M, L, E]
    // Print in sorted order
    while (!pq.empty()) {
        // Remove the maximum
        println("Max = " + pq.removeMax())
        pq.print()
    }
}









