/**
 * Created by nuno on 18-04-2021.
 */

fun less(v: Char, w: Char): Boolean {
    return v < w
}

fun exch(array: CharArray, i: Int, j: Int) {
    val t = array[i]
    array[i] = array[j]
    array[j] = t
}

fun compExch(array: CharArray, i: Int, j: Int) {
    if (less(array[j], array[i]))
        exch(array, i, j)
}


/**
 * Priority Queue array implementation
 */
data class PriorityQueueArray(val pq: CharArray, var size: Int)

/**
 *
 * @return
 */
fun PriorityQueueArray.empty(): Boolean {
    return size == 0
}

/**
 *
 * @param elem
 */
fun PriorityQueueArray.insert(elem: Char) {
    pq[size++] = elem
}

/**
 * Pre-condition: Not empty
 * @return
 */
fun PriorityQueueArray.removeMax(): Char {
    var max = 0
    // Find maximum
    for (j in 1 until size) {
        if (less(pq[max], pq[j]))
            max = j
    }
    // Exchange maximum with last element
    exch(pq, max, size - 1)
    // Decrease size and return last element (maximum)
    return pq[--size]
}

fun PriorityQueueArray.print() {
    if (empty()) {
        println("Empty")
        return
    }
    print("Size = $size")
    print(" [")
    for (i in 0 until size - 1) {
        print(pq[i].toString() + ", ")
    }
    print(pq[size - 1])
    println("]")
}












