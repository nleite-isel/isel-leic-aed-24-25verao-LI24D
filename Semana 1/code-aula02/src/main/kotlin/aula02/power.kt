package aula02

fun powerLinear(a: Int, n: Int): Int =
    if (n == 0) 1 else a * powerLinear(a, n - 1)


fun powerLogarithmic(a: Int, n: Int): Int {
    if (n == 0)
        return 1
    val z = powerLogarithmic(a, n / 2)
    return if (n % 2 == 0) z * z else a * z * z
}