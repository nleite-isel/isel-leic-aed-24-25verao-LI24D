package aula29.stack

class IntStackList : IntStack {
	// Classe aninhada Node
//	private inner class Node constructor(val item: Int) { // constructor keyword is optional here
	private inner class Node (val item: Int) { // Without constructor keyword
		var next: Node? = null
		// If we use the "inner" keyword, class Node can access fields/methods of the outer class (it knows the "this"
	    // of outer class IntStackList). Otherwise, we cannot access fields/methods of the outer class
	}

	private var head: Node? = null // Without sentinel node
	override val isEmpty: Boolean
		get() = head == null

	override fun push(item: Int) {
		val n: Node = Node(item)
		n.next = head
		head = n
	}

	// Assume-se que antes de invocar o metodo pop e' testado se a pilha esta' vazia
	override fun pop(): Int {
		val item = head!!.item
		head = head!!.next
		return item
	}
}







