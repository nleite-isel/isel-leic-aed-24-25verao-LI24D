

class HashSet<E>: MutableSet<E> { // Hashset
    private data class Node<E>(
        val elem: E,
        var next: Node<E>? = null,
        var previous: Node<E>? = null)

    // Hashset internal table
    private var table: Array<Node<E>?>?
    // size property
    override var size: Int = 0
    override fun contains(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    // Table dimension
    private var dimTable: Int

    constructor() {
        // table construction with dimension equal to 10
        table = arrayOfNulls<Node<Any>?>(10) as Array<Node<E>?>
        dimTable = 10
    }

    /**
     *
     */
    private fun index(e: E): Int {
       var pos = e.hashCode() % dimTable
        // hashCode could be negative
       if (pos < 0) {
           pos += dimTable
       }
       return pos
    }

    private fun search(e: E, idx: Int): Node<E>? {
        var curr: Node<E>? = table?.get(idx)
        while (curr != null) {
            curr.elem?.let {
                if (it.equals(e))
                    return curr
            }
            // Advance curr
            curr = curr.next
        }
        return curr
    }

    override fun add(elem: E): Boolean {
        // Get elem's index
        var pos = index(elem)
        // Search elem at entry pos
        val node = search(elem, pos)
        if (node != null)
            return false // Repeated key case
        if ((size / dimTable).toDouble() > 0.75)
            resize() // Resize table using a greater Mersenne number
        pos = index(elem)
        // Insert at list head
        val newNode = Node<E>(elem)
        newNode.next = table?.get(pos)
        table?.let {
            table?.get(pos)?.previous = newNode
        }
        // Update head
        table?.set(pos, newNode)
        ++size
        return true
    }

    override fun addAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    private fun getLengthMersenne(current: Int): Int {
        // Just returns next prime-like number for resizing
        return current * 2 + 1 // A mock-up (e.g., next Mersenne-ish number)
        // TODO - change the above code in order to generate Mersenne numbers
        // like described in file:
        // "[Pearson] - Algorithms, 4th ed. - [Sedgewick, Wayne].pdf"
    }

    /**
     *
     */
    private fun resize() {
        // Increase table dimension and
        // recalculate element position in
        // the new table
        dimTable = getLengthMersenne(dimTable)
        // New table instantiation
        val newTable = arrayOfNulls<Node<Any?>>(dimTable) as Array<Node<E>?>
            // Iterate over each index
        table?.let {
            for (i in it.indices) {
                // Current points to the first node at table[i]
                var current = it[i]
                // If the entry is not null, iterate the list
                while (current != null) {
                    // Get elem's new index, taking into consideration
                    // the new table
                    val newPos = index(current.elem)
                    // Remove element (current) at head
                    it[i] = it[i]?.next
                    // Insert current at the new list's head,
                    // in the new table
                    // 1. (See lecture notes)
                    current.next = newTable[newPos]
                    if (newTable[newPos] != null) {
                        newTable[newPos]?.previous = current
                    }
                    // 2.
                    newTable[newPos] = current
                    // 3.
                    current = it[i]
                } // while
            } // for
        }
        table = newTable
    } // resize

    // MutableSet interface inherits Collection interface, which, on its
    // turn, inherits from Iterable interface
    override fun iterator(): MutableIterator<E> {
        return MyIterator()
    }

    override fun remove(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Class that implements Iterator interface
     */
    private inner class  MyIterator : MutableIterator<E> { // MyIterator
        // table's index
        var currentPos: Int = -1
        // Current node in list to be iterated
        var nodeIt: Node<E>? = null
        var currentElement: Node<E>? = null

        // Iterator interface has two important methods:
        //  - hasNext
        //  - next
        //
        override fun hasNext(): Boolean {
            if (currentElement != null)
                return true

            table?.let {
                while (currentPos < it.size) {
                    if (nodeIt == null) {
                        ++currentPos
                        if (currentPos < it.size)
                            nodeIt = it[currentPos]
                    }
                    else {
                        currentElement = nodeIt
                        nodeIt = nodeIt?.next
                        return true
                    }
                } // while
            }
            return false
        }

        override fun next(): E {
            if (!hasNext())
                throw NoSuchElementException()

            val aux = currentElement?.elem
            currentElement = null
            return aux!! // aux will never be null,
                         // because we assume that currentElement is not null initially


        }

        override fun remove() {
            TODO("Not yet implemented")
        }
    }
}















