package aula22.queue

fun main() {
//    val intQueue = IntQueueArray(20) // Array-based
//    val intQueue: IntQueue = IntQueueArray(20) // Array-based, note the type is IntQueue interface

    var intQueue: IntQueue // Type is IntQueue interface
    // COMMENT / UNCOMMENT alternatives
//    intQueue = IntQueueArray(20) // Array-based
    intQueue = IntQueueList() // List-based

    // Pushing into the queue (FIFO - First-In First-Out)
    for (i in 1 until 10)
        intQueue.put(i)
    // Popping from the queue
    while (!intQueue.isEmpty) // Note that isEmpty is a getter property, not a method
        println(intQueue.poll())
}









