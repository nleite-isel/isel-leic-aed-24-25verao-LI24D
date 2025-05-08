package aula07

fun binarySearch(array: IntArray, left: Int, right: Int, element: Int): Int {
    var l = left
    var r = right
    var mid: Int
    while (l <= r) {
        mid = (l + r) / 2// mid = l + (r - l) / 2
        if (array[mid] == element)
            return mid
        else if (array[mid] < element)
            l = mid + 1
        else
            r = mid - 1
    }
    return -1
}

fun binarySearchRecursive(array: IntArray, l: Int, r: Int, element: Int): Int {
    if (l > r)
        return -1
    val mid = (l + r) / 2// mid = l + (r - l) / 2
    if (array[mid] == element)
        return mid
    return if (array[mid] < element)
        binarySearchRecursive(array, mid + 1, r, element)
    else
        binarySearchRecursive(array, l, mid - 1, element)
}

