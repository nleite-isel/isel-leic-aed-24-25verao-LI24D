package aula22


// OUTRA IMPLEMENTACAO
class IntStackArray2 { // Sem constructor primário
    // Fields
    private val stack: IntArray
    private var n: Int

    // Metodos
    public fun isEmpty(): Boolean = n == 0

    public fun push(item: Int) {
        if (n < stack.size) {
            stack[n] = item
            ++n // n indica proxima posicao livre
        }
    }

    // Assume-se que antes de invocar o método pop é testado se a pilha está vazia
    public fun pop(): Int {
        --n // decrementa n para passar a apontar para o ultimo elemento
        return stack[n]
    }
    //
    // Constructors
    //

    // Constructor 1
    constructor() {
        stack = IntArray(10)
        n = 0
    }

    // Constructor 2
    constructor(capacity: Int) {
        stack = IntArray(capacity)
        n = 0
    }
}

fun main() {
    val intStack1 = IntStackArray2() // Constructor 1
    val intStack2 = IntStackArray2(20) // Constructor 2

    // Pushing into the stack
    for (i in 1 until 10)
        intStack1.push(i)
    // Popping from the stack
    while (!intStack1.isEmpty())
        println(intStack1.pop())

    /////////////////////////////////////////

    // Pushing into the stack
    for (i in 1 until 10)
        intStack2.push(i)
    // Popping from the stack
    while (!intStack2.isEmpty())
        println(intStack2.pop())

}











