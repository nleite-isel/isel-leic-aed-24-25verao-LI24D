package aula21.dlist.generic

// Class Node
public class Node<E> {
    var previous: Node<E>?
    var next: Node<E>?
    var value: E? = null

    constructor() { // To build the sentinel node
        previous = this
        next = this
    }
    constructor(e: E) { // To build the other nodes
        previous = null
        next = null
        value = e
    }
}


// Double linked list, with sentinel
class DList<E> {
    /*private*/ public /*val*/ var list: Node<E>? = Node<E>() // Sentinel node
    private var size = 0
    // Methods
    fun addFront(v: E) {
        //  Create new node with value v
        val newNode: Node<E> = Node<E>(v)
        // Set auxiliary references "prevNode" and "nextNode"
        var prevNode: Node<E>? = list // Points to sentinel
        var nextNode: Node<E>? = list!!.next // Points to first node
        // Connect new node after sentinel node
        prevNode!!.next = newNode
        newNode.previous = prevNode
        newNode.next = nextNode
        nextNode!!.previous = newNode
        // Increment size
        ++size
    }

    fun removeFront(): E? {
        if (isEmpty())
            return null
        // Get value of first node
        val v: E? = list!!.next!!.value
        // Set auxiliary references "prevNode" and "nextNode"
        var prevNode: Node<E>? = list // Points to sentinel
        var nextNode: Node<E>? = list!!.next!!.next // Points to second node
        // Disconnect first node
        prevNode!!.next = nextNode
        nextNode!!.previous = prevNode
        // Decrement size
        --size
        return v
    }

    fun addLast(v: E) {
        //  Create new node with value v
        val newNode: Node<E> = Node<E>(v)
        // Set auxiliary references "prevNode" and "nextNode"
        var prevNode: Node<E>? = list!!.previous // Points to last node
        var nextNode: Node<E>? = list // Points to sentinel
        // Connect new node after last node
        prevNode!!.next = newNode
        newNode.previous = prevNode
        newNode.next = nextNode
        nextNode!!.previous = newNode
        // Increment size
        ++size
    }

    fun removeLast(): E? {
        if (isEmpty())
            return null
        // Get value of last node
        val v: E? = list!!.previous!!.value
        // Set auxiliary references "prevNode" and "nextNode"
        var prevNode: Node<E>? = list!!.previous!!.previous // Points to last node
        var nextNode: Node<E>? = list // Points to sentinel
        // Disconnect last node
        prevNode!!.next = nextNode
        nextNode!!.previous = prevNode
        // Decrement size
        --size
        return v
    }

    fun isEmpty(): Boolean = size == 0

    // index belongs to [0, size]
    fun insert(v: E, index: Int) {
        val newNode = Node<E>(v)
        var prevNode: Node<E>? = null
        var nextNode: Node<E>? = null
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

    fun print() {
        var curr: Node<E>? = list!!.next
        while (curr != list) {
            print("${curr!!.value} ")
            curr = curr!!.next
        }
    }
}
















