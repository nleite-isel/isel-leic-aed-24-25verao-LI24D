package aula29.stack

fun main() {
//    val intStack = IntStackArray(10) // Array-based
//    val intStack: IntStack = IntStackArray(10) // Array-based, note the type is IntStack interface

    var intStack: IntStack // Type is IntStack interface
    // COMMENT / UNCOMMENT alternatives
//    intStack = IntStackArray(10) // Array-based
    intStack = IntStackList() // List-based

    // Pushing into the stack (LIFO - Last-In First-Out)
    for (i in 1 until 10)
        intStack.push(i)
    // Popping from the stack
    while (!intStack.isEmpty) // Note that isEmpty is a getter property, not a method
        println(intStack.pop())
}









