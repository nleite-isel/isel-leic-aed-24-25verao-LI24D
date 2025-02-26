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

// T.P.C.
// Insertion sort em que em vez de fazer *troca* (lessExch), *move* o valor fora de ordem (que se encontra na janela)
// para a frente. No final insere o valor a ordenar (na posição i) na posição final
// Esta nova versão é O(n) quando o array de entrada está ordenado crescentemente
fun insertionSort2(a: CharArray, l: Int, r: Int) {

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

