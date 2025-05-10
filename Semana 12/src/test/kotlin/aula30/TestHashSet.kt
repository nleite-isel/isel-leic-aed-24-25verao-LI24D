
fun main() {
    // Create a new HashSet of integers
    val mySet = HashSet<Int>()

    println("Adding 10: ${mySet.add(10)}")  // Should print true
    println("Adding 20: ${mySet.add(20)}")  // Should print true
    println("Adding 10 again: ${mySet.add(10)}")  // Should print false (duplicate)

    println("\nElements in the HashSet:")
    for (elem in mySet) {
        println(elem)
    }

    // Add more elements to trigger a resize
    println("\nAdding more elements...")
    for (i in 30..100 step 10) {
        println("Adding $i: ${mySet.add(i)}")
    }

    println("\nFinal contents of the HashSet:")
    for (elem in mySet) {
        println(elem)
    }

    println("\nTotal size: ${mySet.size}")
}
