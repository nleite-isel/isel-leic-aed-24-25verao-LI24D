package aula19.sintlist

class IntNode {
    var value: Int
    var next: IntNode?
    // Constructors
    constructor() {
        value = 0
        next = null
    }
    constructor(v: Int) {
        value = v
        next = null
    }
}