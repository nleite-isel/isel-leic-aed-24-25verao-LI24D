package aula31.mygraph.queue

interface Queue<E> {
	fun put(e: E)
	fun get(): E
	val isEmpty: Boolean
}