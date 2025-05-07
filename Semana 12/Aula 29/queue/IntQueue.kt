package aula22.queue

// Implements an operation ordering known as FIFO: First In First Out

interface IntQueue {
	fun put(i: Int)
	fun poll(): Int
	val isEmpty: Boolean
}