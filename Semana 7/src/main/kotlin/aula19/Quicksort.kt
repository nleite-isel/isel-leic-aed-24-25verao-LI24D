package aula19

import java.util.*

var cnt = 0

private fun less(x: Int, y: Int): Boolean {
    ++cnt
    return x < y
}

private fun exch(a: IntArray, i: Int, j: Int) {
    val aux = a[i]
    a[i] = a[j]
    a[j] = aux
}

private fun lessExch(a: IntArray, i: Int, j: Int) {
    if (less(a[i], a[j]))
        exch(a, i, j)
}

// Selection Sort
private fun selectionSort(a: IntArray, l: Int, r: Int) {
    for (i in l until r) {
        var min = i
        for (j in i + 1..r) if (less(a[j], a[min]))
            min = j
        exch(a, i, min)
    }
}

private fun insertionSort1(a: IntArray, l: Int, r: Int) {
    for (i in l + 1..r) {
        for (j in i downTo l + 1)
            lessExch(a, j, j - 1)
    }
}

private fun insertionSort2(a: IntArray, l: Int, r: Int) {
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

private fun bubbleSort(a: IntArray, l: Int, r: Int) {
    for (i in l until r) {
        for (j in r downTo i + 1) {
            lessExch(a, j, j - 1)
        }
    }
}

/////////////////  Quicksort //////////////////////////////
// Um algoritmo básico de shuffle
private fun shuffle(a: IntArray, l: Int, r: Int) {
    val size = r - l + 1
    for (i in 0 until 2 * size) {
        // Gerar indice aleatorio do array
        val randomIdx = (Math.random() * size).toInt() // randomIdx entre [0;size-1]
        // Trocar último elemento com a[randomIdx]
        val aux = a[r]
        a[r] = a[l + randomIdx]
        a[l + randomIdx] = aux
    }
}

fun quicksort(a: IntArray, l: Int, r: Int) {
    shuffle(a, l, r); // OPCIONAL
    qsort(a, 0, a.size - 1)
}

private fun partition(a: IntArray, l: Int, r: Int): Int {
    var i = l - 1
    var j = r
    val v = a[r]
    while (true) {
        while (less(a[++i], v));
        while (less(v, a[--j]))
            if (j == l) break // Encontra indice elemento <= pivot 'a direita
        if (i >= j)
            break
        exch(a, i, j)
    }
    exch(a, i, r) // Troca a[i] com pivot de particao
    return i // Retorna indice do pivot
}

private fun qsort(a: IntArray, l: Int, r: Int) {
    if (r <= l)
        return
    val m = partition(a, l, r)
    qsort(a, l, m - 1)
    qsort(a, m + 1, r)
}

fun nonRecursiveQuicksort(a: IntArray, l: Int, r: Int) {
    // Shuffle
    var l = l
    var r = r
    shuffle(a, l, r) // OPCIONAL
    val s: IntStackArray = IntStackArray(50)
    s.push(l)
    s.push(r)
    while (!s.isEmpty()) {
        r = s.pop()
        l = s.pop()
        if (r <= l) continue
        val i = partition(a, l, r)
        if (i - l > r - i) { // i-l  e' a maior
            s.push(l)
            s.push(i - 1)
        }
        s.push(i + 1)
        s.push(r)
        if (r - i >= i - l) {
            s.push(l)
            s.push(i - 1)
        }
    }
}

///////////////////////////////////////////////////////////
fun sort(a: IntArray, l: Int, r: Int) {
    // selectionSort(a, l, r);
    // insertionSort1(a, l, r);
    //insertionSort2(a, l, r);
    // bubbleSort(a, l, r);
//    quicksort(a, l, r)
    nonRecursiveQuicksort(a, l, r);
}

fun main(args: Array<String>) {
    // Teste1
    val n = 800000
    val a = IntArray(n)
    for (i in 0 until n) {
        // random gera números no intervalo [0.0; 1.0[
        a[i] = (Math.random() * 100).toInt()
    }

    // Ordenar array
    sort(a, 0, a.size - 1);
    // Imprimir array
    for (i in a.indices)
        print(a[i].toString() + " ")
    println()
    println("Comparacoes usadas: $cnt")

    // Teste2
    cnt = 0 // Colocar contador de comparacoes a zero
//    val a1 = intArrayOf(10, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    val a1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

    sort(a1, 0, a1.size - 1)
    for (i in a1.indices)
        print(a1[i].toString() + " ")
    println()
    println("Comparacoes usadas: $cnt")
}












