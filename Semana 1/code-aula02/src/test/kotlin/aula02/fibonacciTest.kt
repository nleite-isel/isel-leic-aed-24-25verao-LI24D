package aula02


// Performance tests
fun main() {
    var init = System.currentTimeMillis()
    fibonacci_1(60)
    var end = System.currentTimeMillis()
    println((end - init) / 1000) //in seconds
    init = System.currentTimeMillis()
    fibonacci_2(60)
    end = System.currentTimeMillis()
    println((end - init) / 1000) //in seconds
}