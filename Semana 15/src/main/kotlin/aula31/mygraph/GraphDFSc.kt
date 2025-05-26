package aula31.mygraph

/**
 * Code adapted from Sedgewick's Book "Algorithms in Java"
 *
 * Depth First Search (DFS)
 */
class GraphDFSc(private val graph: Graph, v: Int) {
    private val visited: BooleanArray
    private fun searchC(v: Int) {
        visited[v] = true
        ///////////////////////////
        /// DEBUG
        println("Visited vertice $v")
        ///////////////////////////
        val adjList = graph.getAdjList(v)
        var t = adjList!!.begin()
        while (!adjList.end()) {
            if (!visited[t])
                searchC(t)
            t = adjList.next()
        }
    }

    // Constructor
    init {
        visited = BooleanArray(graph.numVertices) // Initialised to false
        searchC(v)
    }
}