package aula31.mygraph

/**
 * Code adapted from Sedgewick's Book "Algorithms in Java"
 *
 */
interface AdjList {
    fun begin(): Int
    operator fun next(): Int
    fun end(): Boolean
}