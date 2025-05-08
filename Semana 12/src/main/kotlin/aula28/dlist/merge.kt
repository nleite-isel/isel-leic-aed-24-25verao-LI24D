package aula28.dlist

import aula28.dlist.generic.Node


fun <E> merge(list1: Node<E>, list2: Node<E>, cmp: Comparator<E>): Node<E>? {
    var curr1: Node<E>? = list1.next
    var curr2: Node<E>? = list2.next
    // Auxiliary nodes
    var prev1: Node<E>? = null
    var next1: Node<E>? = null
    var prev2: Node<E>? = null
    var next2: Node<E>? = null
    // While list1 and list2 have elements, iterate these
    while (curr1 != list1 && curr2 != list2) {
        if (cmp.compare(curr1!!.value, curr2!!.value) <= 0)
            curr1 = curr1!!.next
        else {
            // Set references to previous and next places in the two lists
            prev1 = curr1!!.previous
            next1 = curr1
            prev2 = curr2!!.previous
            next2 = curr2!!.next
            // Move node "curr2" from list2 into list1
            curr2.previous = prev1
            curr2.next = next1
            prev1!!.next = curr2
            next1.previous = curr2
            // Disconnect curr2 node
            prev2!!.next = next2
            next2!!.previous = prev2
            // Advance curr2
            curr2 = next2
        }
    }
    // If list2 not ended, connect list2 to list1 (except sentinel node)
    if (curr2 != list2) {
        // Set aux references
        var last2 = list2.previous
        prev1 = curr1!!.previous
        next1 = curr1
        // Connect list2 into list1
        curr2!!.previous = prev1
        prev1!!.next = curr2
        next1.previous = last2
        last2!!.next = next1
    }
    // Empty list2
    list2.previous = list2
    list2.next = list2.previous
    // Return updated list1
    return list1
}














