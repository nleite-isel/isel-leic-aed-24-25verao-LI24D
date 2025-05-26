package aula31.mygraph.queue

class QueueArrayImpl<E>(elementType: Class<E>?, private val capacity: Int) : Queue<E> {
	private val queue: Array<E>
	private var head: Int
	private var tail: Int
	private var size = 0
	override fun put(elem: E) {
		if (size < capacity) {
			queue[tail] = elem
			tail = (tail + 1) % capacity
			++size
		}
	}

	// Assume-se que antes de invocar o metodo get e' testado se a fila esta' vazia
	override fun get(): E {
		val elem = queue[head]
		head = (head + 1) % capacity
		--size
		return elem
	}

	override val isEmpty: Boolean
		get() = size == 0

	/**
	 * Constructor
	 *
	 * @param capacity
	 */
	init {
		queue = java.lang.reflect.Array.newInstance(elementType, capacity) as Array<E>
		head = 0
		tail = 0
	}
}