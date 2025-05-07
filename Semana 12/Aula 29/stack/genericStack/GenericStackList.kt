package aula22.stack.genericStack

class GenericStackList<E> : GenericStack<E> {
    private inner class Node<E> {
        var value: E?
        var next: Node<E>?
        // Constructors
        constructor() {
            value = null
            next = null
        }
        constructor(v: E) {
            value = v
            next = null
        }
    }

    private var head: Node<E>? = null
    override fun push(item: E) {
        val n: Node<E>? = Node<E>(item)
        n!!.next = head
        head = n
    }

    // Assume-se que antes de invocar o metodo pop e' testado se a pilha esta' vazia
    override fun pop(): E {
        val item: E = head!!.value!!
        head = head!!.next
        return item
    }

    override val isEmpty: Boolean
        get() = head == null
}











