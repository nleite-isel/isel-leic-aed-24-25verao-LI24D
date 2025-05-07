package aula19.sintlist.sentinel

import aula19.sintlist.IntNode

// Single linked list, with sentinel
class SIntListSentinel {
    private var head: IntNode? = IntNode() // Sentinel node
    private var size = 0

    // Methods
    fun addFront(v: Int) {
        val newNode: IntNode = IntNode(v)
        /*
        // Old code - without sentinel
        if (head == null) {
            head = newNode
        }
        else {
            newNode.next = head
            head = newNode
        }
        ++size
        */
        newNode.next = head!!.next
        head!!.next = newNode
        ++size
    }

    fun removeFront(): Int? {
        /*
        // Old code - without sentinel
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
         */
        if (head!!.next == null) {
            return null
        } else {
            val elem = head!!.next!!.value
            // Remove node
            head!!.next = head!!.next!!.next
            return elem
        }
        --size
    }

    // Old code - without sentinel
    // fun isEmpty(): Boolean = head == null

    fun isEmpty(): Boolean = head!!.next == null

    // Old code - without sentinel

    //    // index belongs to [0, size]
//    fun insert(v: Int, index: Int) {
//        val newNode = IntNode(v)
//        var prevNode: IntNode? = null
//        var nextNode: IntNode? = null
//        // Case 1: // Insert in the head
//        if (index == 0) { // We have to change list head
//            nextNode = head
//            newNode.next = nextNode
//            head = newNode
//        }
//        // Case 2: // Insert other than in the head
//        else {
//            var i = 0
//            prevNode = head
//            while (i < index - 1) {
//                prevNode = prevNode!!.next
//                ++i
//            }
//            // Insert newNode at front of prevNode
//            nextNode = prevNode!!.next
//            newNode.next = nextNode
//            prevNode.next = newNode
//        }
//        ++size
//    }

    // index belongs to [0, size]
    fun insert(v: Int, index: Int) {
        val newNode = IntNode(v)
        var prevNode: IntNode? = null
        var nextNode: IntNode? = null
        var i = 0
        prevNode = head
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

















