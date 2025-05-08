package aula02

/* Sequencia de Fibonacci
F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2), n > 1
 */

/* Método 1 -
Complexidade Temporal O(2^n)
Complexidade em termos de espaço O(n)
 */
fun fibonacci_1(n: Int): Int =
    if (n <= 1) n
    else fibonacci_1(n - 1) + fibonacci_1(n - 2)


/* Método 2 -
Usar programação dinâmica - técnica de memorização
Solução utilização de um array para armanzenar os números calculados até agora
Complexidade Temporal O(n)
Complexidade em termos de espaço O(n)
 */
fun fibonacci_2(n: Int): Int {
    val f = IntArray(n + 2)
    var i: Int
    f[0] = 0
    f[1] = 1
    i = 2
    while (i <= n) {
        f[i] = f[i - 1] + f[i - 2]
        i++
    }
    return f[n]
}

/*Método 3 -
Usar apenas memorização nos últimos 2 termos -> Reduz a complexidade espacial para O(1)
//Deixar para TPC
 */
fun fib(n: Int): Int {
    var a = 0
    var b = 1
    var c: Int
    if (n == 0) return a
    for (i in 2..n) {
        c = a + b
        a = b
        b = c
    }
    return b
}