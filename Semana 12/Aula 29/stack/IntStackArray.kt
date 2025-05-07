package aula22.stack

class IntStackArray(capacity: Int) : IntStack {
	private var stack: IntArray
	private var stkptr = 0

	private fun grow() {
		val newStack = IntArray(stack.size * 2) // E.g., doubles its size
		for (i in stack.indices)
			newStack[i] = stack[i]
		stack = newStack // A variavel de instancia stack passa a referir o novo array;
		// O array antigo e' limpo pelo GC (Garbage Colector)
	}

	override val isEmpty: Boolean
		get() = stkptr == 0

	override fun push(item: Int) {
		if (stkptr == stack.size)
			grow()
		stack[stkptr] = item
		++stkptr
	}

	// Assume-se que antes de invocar o metodo pop e' testado se a pilha esta' vazia
	override fun pop(): Int {
		--stkptr
		return stack[stkptr]
	}

	init {
		stack = IntArray(capacity)
	}
}









