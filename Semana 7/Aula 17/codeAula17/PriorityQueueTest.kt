/**
 * Created by nuno on 18-04-2021.
 */
///
/// TEST
///
fun main() {
    // Simulate example from Figure 9.1 (with character array)

    //
    // PriorityQueueArray
    //
    val pq: PriorityQueueArray = PriorityQueueArray(CharArray(20), 0)

    //
    // PriorityQueueHeapBased
    //
//    val pq: PriorityQueueHeapBased = PriorityQueueArray(CharArray(20), 0)

    // Insert 'B'
    pq.insert('B')
    pq.print()
    // Insert 'E'
    pq.insert('E')
    pq.print()
    // Remove the maximum
    System.out.println("Max = " + pq.removeMax())
    pq.print()

    // Insert 'S'
    pq.insert('S')
    pq.print()
    // Insert 'T'
    pq.insert('T')
    pq.print()
    // Insert 'I'
    pq.insert('I')
    pq.print()
    // Remove the maximum
    System.out.println("Max = " + pq.removeMax())
    pq.print()

    // Insert 'N'
    pq.insert('N')
    pq.print()
    // Remove the maximum
    System.out.println("Max = " + pq.removeMax())
    pq.print()

    // Insert 'F'
    pq.insert('F')
    pq.print()
    // Insert 'I'
    pq.insert('I')
    pq.print()
    // Insert 'R'
    pq.insert('R')
    pq.print()
    // Remove the maximum
    System.out.println("Max = " + pq.removeMax())
    pq.print()

    // Insert 'S'
    pq.insert('S')
    pq.print()
    // Insert 'T'
    pq.insert('T')
    pq.print()
    // Remove the maximum
    System.out.println("Max = " + pq.removeMax())
    pq.print()
    // Remove the maximum
    System.out.println("Max = " + pq.removeMax())
    pq.print()

    // Insert 'O'
    pq.insert('O')
    pq.print()
    // Insert 'U'
    pq.insert('U')
    pq.print()
    // Remove the maximum
    System.out.println("Max = " + pq.removeMax())
    pq.print()

    // Insert 'T'
    pq.insert('T')
    pq.print()
    while (!pq.empty()) {
        // Remove the maximum
        System.out.println("Max = " + pq.removeMax())
        pq.print()
    }
}









