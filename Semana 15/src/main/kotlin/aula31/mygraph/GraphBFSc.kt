package aula31.mygraph

import aula31.mygraph.queue.QueueArrayImpl

/**
 * Code adapted from Sedgewick's Book "Algorithms in Java"
 *
 * Breadth First Search (DFS)
 */
class GraphBFSc(private val graph: Graph, v: Int) {
    private val visited: BooleanArray
    private fun searchC(e: Edge) {
        var e = e
        val edgeQueue = QueueArrayImpl(Edge::class.java, graph.numVertices)
        edgeQueue.put(e)
        while (!edgeQueue.isEmpty) {
            if (!visited[edgeQueue.get().also { e = it }.w]) {
                val v = e.v
                val w = e.w
                visited[w] = true
                ///////////////////////////
                /// DEBUG
                println("Visited vertice $w")
                ///////////////////////////
                val adjList = graph.getAdjList(w)
                var t = adjList!!.begin()
                while (!adjList.end()) {
                    if (!visited[t]) edgeQueue.put(Edge(w, t))
                    t = adjList.next()
                }
            }
        }
    }

    // Constructor
    init {
        visited = BooleanArray(graph.numVertices) // Initialised to false
        // BFS search
        searchC(Edge(v, v))
    }
}