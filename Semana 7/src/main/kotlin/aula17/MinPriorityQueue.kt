import java.util.*

/**
 * Created by nuno on 18-04-2021.
 */


fun less(v: Patient, w: Patient): Boolean {
    return v.priority < w.priority
}

fun exch(array: Array<Patient?>, i: Int, j: Int) {
    val t = array[i]
    array[i] = array[j]
    array[j] = t
}


/**
 * Priority Queue heap implementation comprised of
 * a Priority queue array
 * and Priority queue size
 */
//data class MinPriorityQueue(var pq: Array<Patient?>, var size: Int)

// In order to support updates
data class MinPriorityQueue(var pq: Array<Patient?>, var positions: IntArray, var size: Int)


/**
 *
 * Build a heap given an array (in non-heap strucuture)
 *
 * @param array Non-empty array
 */
fun MinPriorityQueue.buildFromArray(array: Array<Patient?>, size: Int) {
    pq = Array<Patient?>(size + 1, { i -> null }) // In this implementation, the zero position is not used
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
fun MinPriorityQueue.empty(): Boolean {
    return size == 0
}

/**
 *
 * @param elem
 */
fun MinPriorityQueue.insert(elem: Patient) {
    pq[size + 1] = elem // Indices start at 1
    // Update positions
    positions[elem.patientId] = size + 1
    // Increment size
    ++size
    // Fix up the heap
    decreaseKey(size)
}

/**
 * Pre-condition: Heap is not empty
 *
 * @return
 */
fun MinPriorityQueue.min(): Patient = pq[1]!!

/**
 *
 * @return
 */
fun MinPriorityQueue.removeMin(): Patient {
    // Get max
    val min = pq[1]
    // Set the new root to be the last element
    pq[1] = pq[size]
    //////////////////////////
    /// Update positions
    positions[pq[1]!!.patientId] = 1
    // Last element
    positions[pq[size]!!.patientId] = -1
    pq[size] = null
    //////////////////////////
    // Remake heap from the root
    minHeapify(1, size - 1)
    // Decrement size
    --size
    // Return the maximum
    return min!!
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
private fun MinPriorityQueue.buildHeap() {
    // Get last element's parent
    var idxParent = size / 2
    while (idxParent >= 1) {
        minHeapify(idxParent, size)
        // Go to previous parent
        --idxParent
    }
}

/**
 * Bottom-up heapify (swim)
 * @param k
 */
private fun MinPriorityQueue.decreaseKey(k: Int) {
    var k = k
    var idxParent: Int
    while (k > 1) {
        // Get parent
        idxParent = k / 2
        // Max-heap
        // Verify if parent is less than current key index k
        //if (!less(pq[idxParent], pq[k]))
        // Min-heap
        // Verify if parent is greater than current key index k
        if (!less(pq[k]!!, pq[idxParent]!!)) // !! operator "double bang" or not-null assertion operator. The contents are not null
                                             // as assured by the programmer.
            break // The heap is in order
        // and exchange parent with current key index
        exch(pq, k, idxParent)
        // Update positions
        exch(positions, pq[k]!!.patientId, pq[idxParent]!!.patientId)
        // Set current key index to parent index
        k = idxParent
    }
}

/**
 * Top-down heapify (sink)
 * @param k
 * @param hSize
 */
private fun MinPriorityQueue.minHeapify(k: Int, hSize: Int) {
    // Get index of left descendant
    var k = k
    var idxLeftChild = 2 * k
    var idxRightChild: Int
    // If there exists a left descendant
    while (idxLeftChild <= hSize) {
        // Get index of right descendant
        idxRightChild = idxLeftChild + 1
        /*
        // Max-heap
        // Get the largest index of the left and right descendants
        if (idxRightChild <= hSize && less(pq[idxLeftChild], pq[idxRightChild]))
            idxLeftChild = idxRightChild
        // If the largest descendant is not greater than the parent, stop (the heap is ordered)
        if (!less(pq[k], pq[idxLeftChild]))
            break
        */
        // Min-heap
        // Get the smallest index of the left and right descendants
        if (idxRightChild <= hSize && less(pq[idxRightChild]!!, pq[idxLeftChild]!!))
            idxLeftChild = idxRightChild
        // If the smallest descendant is not smaller than the parent, stop (the heap is ordered)
        if (!less(pq[idxLeftChild]!!, pq[k]!!))
            break
        // Else, exchange the largest descendant by its parent
        exch(pq, k, idxLeftChild)
        // Update positions
        exch(positions, pq[k]!!.patientId, pq[idxLeftChild]!!.patientId)
        // Set the next parent to be the left descendant
        k = idxLeftChild
        // Update left descendant
        idxLeftChild = 2 * k
    }
}


/////////////////////////////////////////////
fun MinPriorityQueue.print() {
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

/**
 * This method does not exist in Java/Kotlin
 */
fun MinPriorityQueue.update(newStatus: Patient) {
    val oldStatus = pq[positions[newStatus.patientId]]!!
    pq[positions[newStatus.patientId]] = newStatus
    if (less(oldStatus, newStatus)) {
        minHeapify(positions[newStatus.patientId], size)
    }
    else {
        decreaseKey(positions[newStatus.patientId])
    }
}


fun main() {
    //
    // MixPriorityQueueHeapBased
    //

    /* Java PriorityQueue - resizable */
    val pq = PriorityQueue<Patient>({ x: Patient, y: Patient -> x.priority - y.priority });
    val Patient0 = Patient("Joaquim", 0, 9)
    val Patient1 = Patient("Anabela", 1, 4)
    val Patient2 = Patient("Alice", 2, 3)
    val Patient3 = Patient("Pedro", 3, 6)
    val Patient4 = Patient("Manuel", 4, 7)
    val Patient5 = Patient("Beatriz", 5, 1)
    val Patient6 = Patient("Francisco", 6, 2)
    val Patient7 = Patient("Rodrigo", 7, 2)
    pq.offer(Patient0)
    pq.offer(Patient1)
    pq.offer(Patient2)
    pq.offer(Patient3)
    pq.offer(Patient4)
    pq.offer(Patient5)
    pq.offer(Patient6)
    pq.offer(Patient7)
    println(pq.toString())

    /* HeapQueue - not resizable */
    val heap = Array<Patient?>(10, { i -> null })
    val positions = IntArray(10, { i -> -1 })
    //val pqAED = MinPriorityQueue(heap, positions, 0, { x: Patient, y: Patient -> x.priority - y.priority })
    val pqAED = MinPriorityQueue(heap, positions, 0)
    pqAED.insert(Patient0)
    pqAED.insert(Patient1)
    pqAED.insert(Patient2)
    pqAED.insert(Patient3)
    pqAED.insert(Patient4)
    pqAED.insert(Patient5)
    pqAED.insert(Patient6)
    pqAED.insert(Patient7)
    println(pqAED)
    println("############################")
    println(pqAED.size)
    println(pq.peek())
    println(pqAED.min())

    val update1 = Patient("Joaquim", 0, 5)
    pqAED.update(update1)
    println(pqAED)

    ///
    /// COMMENT / UNCOMMENT these lines to see the effect
//    val update2 = Patient("Joaquim", 0, 10)
//    pqAED.update(update2)
//    println(pqAED)
    ///
    pq.poll()
    println(pq)
    pqAED.removeMin()
    println(pqAED)

    while (!pqAED.empty())
        println(pqAED.removeMin())

}









