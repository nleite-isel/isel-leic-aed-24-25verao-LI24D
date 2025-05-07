package aula22.stack.genericStack


class GenericStackArray<E>(capacity: Int) : GenericStack<E> {
    private val stack: Array<E?>
    private var n = 0
    override val isEmpty: Boolean
        get() = n == 0

    override fun push(item: E) {
        if (isFull)
            throw ArrayStoreException("Stack full")
        stack[n] = item
        ++n
    }

    // Assume-se que antes de invocar o metodo pop e' testado se a pilha esta' vazia
    override fun pop(): E {
        --n
        val item = stack[n]
        stack[n] = null // To release reference to object
        return item!!
    }

    val isFull: Boolean
        get() = n == stack.size

    init {
//        stack = arrayOfNulls<E?>(capacity) // Nao e' possivel criar um array de E porque a JVM nao mantem informacao
        // de tipo no codigo intermedio (bytecode) que vai ser executado pela JVM. E' feito um processo de "Type erasure"
        //  e o codigo generico e' traduzido para codigo que manipula o tipo Any/Object (Kotlin/Java).
        stack = arrayOfNulls<Any>(capacity) as Array<E?> // OK, criacao de um array de Any e cast para Array<E?>.
        // Embora o campo stack seja do tipo Array<E?>, vai referenciar um Array<Any> (Any e' a superclasse de qualquer
        // objeto Kotlin)
    }
}

/*
class Student {

}
In fact, Student implicitly "extends" Any
// In Kotlin
class Student : Any() {

}
// In Java, extends from Object (Object <=> Any)
class Student : Object {

}
 */












