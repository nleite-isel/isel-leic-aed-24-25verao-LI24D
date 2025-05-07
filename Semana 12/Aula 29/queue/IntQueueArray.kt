package aula22.queue
/*
capacity = 5 elements
_ _ _ _ _  // empty array slots
head = 0
tail = 0

/////////////////
put(10)
10 _ _ _ _
head = 0
tail = 1
/////////////////
put(11)
10 11 _ _ _
head = 0
tail = 2
/////////////////
put(12)
10 11 12 _ _
head = 0
tail = 3
/////////////////
put(13)
10 11 12 13 _
head = 0
tail = 4
/////////////////
put(14)
10 11 12 13 14
head = 0
tail = 0  // (4+1) % 5 = 0
/////////////////
poll() -> 10
_ 11 12 13 14
head = 1
tail = 0
/////////////////
put(15)
15 11 12 13 14
head = 1
tail = 1
/////////////////
poll() -> 11
15 _ 12 13 14
head = 2
tail = 1
/////////////////
poll() -> 12
15 _ _ 13 14
head = 3
tail = 1
...

 */

// Ringbuffer implementation
class IntQueueArray(private val capacity: Int) : IntQueue {
	private val queue: IntArray
	private var head: Int
	private var tail: Int
	private var size = 0
	override fun put(i: Int) {
		if (size < capacity) {
			queue[tail] = i
			tail = (tail + 1) % capacity // tail in [0, capacity - 1]
			++size
		}
	}

	// Assume-se que antes de invocar o metodo poll e' testado se a fila esta' vazia
	override fun poll(): Int {
		val i = queue[head]
		head = (head + 1) % capacity
		--size
		return i
	}

	override val isEmpty: Boolean
		get() = size == 0

	init {
		queue = IntArray(capacity)
		head = 0
		tail = 0
	}
}