package aula13


class IntStackArray(capacity: Int) {
    private val stack: IntArray
    private var n = 0

    fun isEmpty(): Boolean = n == 0

    fun push(item: Int) {
        if (n < stack.size) {
            stack[n] = item
            ++n
        }
    }

    // Assume-se que antes de invocar o método pop é testado se a pilha está vazia
    fun pop(): Int {
        --n
        return stack[n]
    }

    init {
        stack = IntArray(capacity)
    }
}