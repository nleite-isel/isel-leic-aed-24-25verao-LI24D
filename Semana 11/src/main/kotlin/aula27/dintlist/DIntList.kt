package aula27.dintlist

// Double linked list, with sentinel
class DIntList {
    private var list: IntNode? = IntNode() // Sentinel node
    private var size = 0
    // Methods
    fun addFront(v: Int) {
        //  Create new node with value v
        val newNode: IntNode = IntNode(v)
        // Set auxiliary references "prevNode" and "nextNode"
        var prevNode: IntNode? = list // Points to sentinel
        var nextNode: IntNode? = list!!.next // Points to first node
        // Connect new node after sentinel node
        prevNode!!.next = newNode
        newNode.previous = prevNode
        newNode.next = nextNode
        nextNode!!.previous = newNode
        // Increment size
        ++size
    }

    fun removeFront(): Int? {
        if (isEmpty())
            return null
        // Get value of first node
        val v: Int = list!!.next!!.value
        // Set auxiliary references "prevNode" and "nextNode"
        var prevNode: IntNode? = list // Points to sentinel
        var nextNode: IntNode? = list!!.next!!.next // Points to second node
        // Disconnect first node
        prevNode!!.next = nextNode
        nextNode!!.previous = prevNode
        // Decrement size
        --size
        return v
    }

    fun addLast(v: Int) {
        //  Create new node with value v
        val newNode: IntNode = IntNode(v)
        // Set auxiliary references "prevNode" and "nextNode"
        var prevNode: IntNode? = list!!.previous // Points to last node
        var nextNode: IntNode? = list // Points to sentinel
        // Connect new node after last node
        prevNode!!.next = newNode
        newNode.previous = prevNode
        newNode.next = nextNode
        nextNode!!.previous = newNode
        // Increment size
        ++size
    }

    fun removeLast(): Int? {
        if (isEmpty())
            return null
        // Get value of last node
        val v: Int = list!!.previous!!.value
        // Set auxiliary references "prevNode" and "nextNode"
        var prevNode: IntNode? = list!!.previous!!.previous // Points to last node
        var nextNode: IntNode? = list // Points to sentinel
        // Disconnect last node
        prevNode!!.next = nextNode
        nextNode!!.previous = prevNode
        // Decrement size
        --size
        return v
    }

    fun isEmpty(): Boolean = size == 0

    // index belongs to [0, size]
    fun insert(v: Int, index: Int) {
        val newNode = IntNode(v)
        var prevNode: IntNode? = null
        var nextNode: IntNode? = null
        var i = 0
        prevNode = list
        while (i < index) {
            prevNode = prevNode!!.next
            ++i
        }
        // Insert newNode at front of prevNode
        nextNode = prevNode!!.next
        newNode.next = nextNode
        prevNode.next = newNode
        ++size
    }
}

















