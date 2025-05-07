package aula22.queue

class IntQueueList : IntQueue {
	private inner class Node internal constructor(var item: Int) {
		var next: Node? = null
	}

	private var head: Node? = null
	private var tail: Node? = null
	override fun put(item: Int) {
		val t = tail
		tail = Node(item)
		if (isEmpty) head = tail else t!!.next = tail
	}

	// Assume-se que antes de invocar o metodo poll e' testado se a fila esta' vazia
	override fun poll(): Int {
		val v = head!!.item
		head = head!!.next
		return v
	}

	override val isEmpty: Boolean
		get() = head == null

}




