package aula22.stack.genericStack

fun main() {
    var intStack: GenericStack<Int> // Type is IntStack interface
    // COMMENT / UNCOMMENT alternatives
    intStack = GenericStackArray<Int>(10) // Array-based
//    intStack = GenericStackList<Int>() // List-based

    // Pushing into the stack (LIFO - Last-In First-Out)
    for (i in 1 until 10)
        intStack.push(i)
    // Popping from the stack
    while (!intStack.isEmpty) // Note that isEmpty is a getter property, not a method
        println(intStack.pop())
}









