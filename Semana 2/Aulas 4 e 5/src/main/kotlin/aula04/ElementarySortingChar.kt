package aula04

// With CharArray

fun less(x: Char, y: Char): Boolean = x < y


fun exch(a: CharArray, i: Int, j: Int) {
    val aux = a[i]
    a[i] = a[j]
    a[j] = aux
}

fun lessExch(a: CharArray, i: Int, j: Int) {
    if (less(a[i], a[j]))
        exch(a, i, j)
}


// Insertion sort
fun insertionSort1(a: CharArray, l: Int, r: Int) {
    for (i in l + 1..r) {
        for (j in i downTo l + 1)
            lessExch(a, j, j - 1)
    }
}

fun insertionSort2(a: CharArray, l: Int, r: Int) {
    for (i in l + 1..r) {
        val v = a[i]
        var j = i
        while (j >= l + 1 && less(v, a[j - 1])) {
            a[j] = a[j - 1]
            --j
        }
        a[j] = v
    }
}

// Selection Sort
fun selectionSort(a: CharArray, l: Int, r: Int) {
    for (i in l until r) {
        var min = i
        for (j in i + 1..r)
            if (less(a[j], a[min]))
                min = j
        exch(a, i, min)
    }
}

// Bubble sort
fun bubbleSort(a: CharArray, l: Int, r: Int) {
    for (i in l until r) {
        for (j in r downTo i + 1) {
            lessExch(a, j, j - 1)
        }
    }
}



