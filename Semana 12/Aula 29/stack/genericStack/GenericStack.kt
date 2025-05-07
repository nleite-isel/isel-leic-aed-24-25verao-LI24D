package aula22.stack.genericStack;


interface GenericStack<E> {
    fun push(i: E)
    fun pop(): E
    val isEmpty: Boolean
}


