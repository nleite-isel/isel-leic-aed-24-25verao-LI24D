package aula19.sintlist

// Single linked list, without sentinel
class SIntList {
    private var head: IntNode? = null
    private var size = 0
    // Methods
    fun addFront(v: Int) {
        val newNode: IntNode = IntNode(v)
        if (head == null) {
            head = newNode
        }
        else {
            newNode.next = head
            head = newNode
        }
    }

    fun removeFront(): Int? {
        if (head == null) {
            return null
        }
        else {
            val elem = head!!.value
            // Remove node
            head = head!!.next
            return elem
        }
        --size
    }

    fun isEmpty(): Boolean = head == null

    // index belongs to [0, size]
    fun insert(v: Int, index: Int) {
        val newNode = IntNode(v)
        var prevNode: IntNode? = null
        var nextNode: IntNode? = null
        // Case 1: // Insert in the head
        if (index == 0) { // We have to change list head
            nextNode = head
            newNode.next = nextNode
            head = newNode
        }
        // Case 2: // Insert other than in the head
        else {
            var i = 0
            prevNode = head
            while (i < index - 1) {
                prevNode = prevNode!!.next
                ++i
            }
            // Insert newNode at front of prevNode
            nextNode = prevNode!!.next
            newNode.next = nextNode
            prevNode.next = newNode
        }
        ++size
    }
}

















