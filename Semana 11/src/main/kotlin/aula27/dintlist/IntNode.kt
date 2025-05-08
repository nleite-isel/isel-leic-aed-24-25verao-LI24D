package aula27.dintlist

class IntNode {
    var value: Int
    var previous: IntNode? // Added
    var next: IntNode?
    // Constructors
    //
    // Used to build Sentinel node, which points to itself
    constructor() {
        value = 0
        previous = this
        next = this
    }
    // Used to build other nodes
    constructor(v: Int) {
        value = v
        previous = null
        next = null
    }
}
