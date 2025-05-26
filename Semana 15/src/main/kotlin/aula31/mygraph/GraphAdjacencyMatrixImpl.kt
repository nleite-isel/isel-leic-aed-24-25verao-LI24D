package aula31.mygraph

/**
 * Code adapted from Sedgewick's Book "Algorithms in Java"
 *
 * ADT interface
 */
class GraphAdjacencyMatrixImpl(override val numVertices: Int, override val isDirected: Boolean) : Graph {
    override var numEdges = 0
        private set
    private val adj: Array<BooleanArray>
    override fun insert(e: Edge?) {
        val v = e!!.v
        val w = e.w
        if (adj[v][w] == false)
            numEdges++
        adj[v][w] = true
        if (!isDirected)
            adj[w][v] = true
    }

    override fun remove(e: Edge?) {
        val v = e!!.v
        val w = e.w
        if (adj[v][w] == true)
            numEdges--
        adj[v][w] = false
        if (!isDirected)
            adj[w][v] = false
    }

    override fun existsEdge(v: Int, w: Int): Boolean {
        return adj[v][w]
    }

    override fun getAdjList(v: Int): AdjList? {
        return AdjArray(v)
    }

    private inner class AdjArray(private val v: Int) : AdjList {
        private var i: Int
        override fun begin(): Int {
            i = -1
            return next()
        }

        override fun next(): Int {
            i++
            while (i < numVertices) {
                if (existsEdge(v, i) == true)
                    return i
                i++
            }
            return -1
        }

        override fun end(): Boolean {
            return i >= numVertices
        }

        init {
            i = -1
        }
    }

    init {
        adj = Array(numVertices) { BooleanArray(numVertices) }
    }
}