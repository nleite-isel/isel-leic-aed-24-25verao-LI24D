package aula29

public interface MyInterface<in T1, /*in T2*/ out T2> {
    public fun xpto(other: T1): T2
}


//class Student(val number: Int) { // primary constructor in the head
////    private val number: Int
//    private var name: String?
//
//    // Secondary constructors
//    constructor(number: Int, name: String) : this(number) { // this(number) significa que esta' a chamar o construtor
////        this.number = number // opcional, pois esta' a ser iniciado no construtor primario em this(number)
//        this.name = name
//    }
////    constructor(name: String) : this(0) { } // Nao faz sentido passar zero no number
//
//    // Obrigatorio, para iniciar os campos (e.g. name)
//    init {
//        name = null
//    }
//}


//class Student {
//    private var number: Int
//    private var name: String?
//
//    // Constructors
//    constructor() {
//        this.number = 0
//        this.name = null
//        println("ctor 0")
//
//    }
//    constructor(number: Int, name: String) {
//        this.number = number
//        this.name = name
//        println("ctor 1")
//
//    }
//
//    init {
//        number = 0
//        name = null
//        println("Init 0")
//    }
//
//    init {
//        number = 10
//        name = "Luisa"
//        println("Init 1")
//    }
//}

// Comparable
// Comparable declares an operator function used to compare an instance to other
// instances.
public interface Comparable<in T> {
    public operator fun compareTo(other: T): Int
}


// Forma sugerida em AED
class Student : Comparable<Student> {
    private var number: Int
    private var name: String?

    // Constructors
    constructor() {
        this.number = 0
        this.name = null
        println("ctor 0")
    }

    constructor(number: Int, name: String) {
        this.number = number
        this.name = name
        println("ctor 1")
    }

    override fun compareTo(other: Student): Int {
        // 1. Use number field
//        return this.number.compareTo(other.number)
        // 2. Use explicit when
        return when {
            this.number > other.number -> 1 // Should be a positive number (any)
            number == other.number -> 0
            else -> -1
        }
    }
}




fun main() {
    val student1 = Student() // number = 0, name = null
    val student2 = Student(123, "Luisa")
    println(student1.compareTo(student2))
    println(student1.compareTo(student2) < 0)
    println(student1 < student2)
}






























