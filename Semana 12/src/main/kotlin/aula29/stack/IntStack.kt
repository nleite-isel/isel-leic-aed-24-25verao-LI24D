package aula29.stack


// Implements an operation ordering known as LIFO: Last In First Out
interface IntStack {
	fun push(i: Int)
	fun pop(): Int
	val isEmpty: Boolean
}
