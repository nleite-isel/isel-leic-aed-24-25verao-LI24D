package aula31.mygraph

/**
 * Code adapted from Sedgewick's Book "Algorithms in Java"
 *
 * ADT interface
 */
interface Graph {
    val numVertices: Int
    val numEdges: Int
    val isDirected: Boolean

    fun insert(edge: Edge?)
    fun remove(edge: Edge?)
    fun existsEdge(v1: Int, v2: Int): Boolean
    fun getAdjList(v: Int): AdjList?
}