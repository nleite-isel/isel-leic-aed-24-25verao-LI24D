package aula31.mygraph

/**
 * Code adapted from Sedgewick's Book "Algorithms in Java"
 *
 * sparse multigraph implementation
 */
class GraphAdjacencyListImpl(override val numVertices: Int, override val isDirected: Boolean) : Graph {
    override var numEdges = 0
        private set

    private inner class Node internal constructor(var v: Int, var next: Node?)

    private val adj: Array<Node?>
    override fun insert(e: Edge?) {
        val v = e!!.v
        val w = e.w
        adj[v] = Node(w, if (adj[v] == null) null else adj[v])
        if (!isDirected)
            adj[w] = Node(v, if (adj[w] == null) null else adj[w])
        numEdges++
    }

    override fun remove(edge: Edge?) {
        throw UnsupportedOperationException()

        // TO DO
    }

    override fun existsEdge(v1: Int, v2: Int): Boolean {
        throw UnsupportedOperationException()

        // TO DO
    }

    override fun getAdjList(v: Int): AdjList? {
        return AdjLinkedList(v)
    }

    private inner class AdjLinkedList(private val v: Int) : AdjList {
        private var t: Node? = null
        override fun begin(): Int {
            t = adj[v]
            return if (t == null) -1 else t!!.v
        }

        override fun next(): Int {
            if (t != null)
                t = t!!.next
            return if (t == null) -1 else t!!.v
        }

        override fun end(): Boolean {
            return t == null
        }
    }

    init {
        adj = arrayOfNulls(numVertices)
    }
}