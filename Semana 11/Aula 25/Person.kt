package aula16

// COMMENT / UNCOMMENT
data class Person constructor(val name: String) {
///*data*/ class Person constructor(val name: String) { // Primary constructor; parameters will generate fields/properties

    var personName: String // This field is not needed because primary constructor already defines a "name" field
    var age: Int

    init { // Initializer
        personName = name
        age = -1
    }

    // Secondary constructor
//    constructor(age: Int) { // Error, you must call primary constructor
    constructor(age: Int, personName: String) : this(personName) {
        // We need to add an "age" field and copy the constructor parameter to it
        this.age = age
    }

	override fun toString() {
		println("Name = $this.name, Age = $this.age")
	}

}


fun main() {
//    val person = Person("Luis") // calls Primary constructor
    val person = Person(39, "Luis") // calls Secondary constructor

    println(person)
    println(person.name)
    println(person.personName)
    println(person.age)
}

/*
with data class:
Person(name=Luis)

with class:
aula16.Person@548c4f57

Prints: package name . class name @ object id or hash code

 */







