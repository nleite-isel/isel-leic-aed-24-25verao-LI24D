package aula31.mygraph

/**
 * Code adapted from Sedgewick's Book "Algorithms in Java"
 *
 * ADT interface
 */
object GraphIO {
    fun edges(graph: Graph): Array<Edge?> {
        var e = 0
        val edges = arrayOfNulls<Edge>(graph.numEdges)
        for (v in 0 until graph.numVertices) {
            val a = graph.getAdjList(v)
            var w = a!!.begin()
            while (!a.end()) {
                if (graph.isDirected || v < w) edges[e++] = Edge(v, w)
                w = a.next()
            }
        }
        return edges
    }

    fun show(graph: Graph) {
        for (s in 0 until graph.numVertices) {
            print("$s: ")
            val adjList = graph.getAdjList(s)
            var t = adjList!!.begin()
            while (!adjList.end()) {
                print("$t ")
                t = adjList.next()
            }
            println()
        }
    }

//    @JvmStatic
 /*   fun main(args: Array<String>) {
        println("\nDFS Example:")
        val numVertices = 13
        ///
        /// SEE, AND EXPLAIN, THE DIFFERENCE BETWEEN OUTPUTS USING ADJACENCY MATRIX AND ADJACENCY LIST IMPLEMENTATIONS
        ///

        //////////////////////////////////////////////////////////////////////////////
//        Graph graph = new GraphAdjacencyListImpl(numVertices, false);
        val graph: Graph = GraphAdjacencyMatrixImpl(numVertices, false)

        // Add edges
        graph.insert(Edge(0, 2))
        graph.insert(Edge(0, 5))
        graph.insert(Edge(0, 7))
        graph.insert(Edge(2, 6))
        graph.insert(Edge(6, 4))
        graph.insert(Edge(4, 3))
        graph.insert(Edge(4, 5))
        graph.insert(Edge(4, 7))
        graph.insert(Edge(7, 1))

//        // Add edges
//        graph.insert(Edge(0, 5))
//        graph.insert(Edge(4, 3))
//        graph.insert(Edge(0, 1))
//        graph.insert(Edge(9, 12))
//        graph.insert(Edge(6, 4))
//        graph.insert(Edge(5, 4))
//        graph.insert(Edge(0, 2))
//        graph.insert(Edge(11, 12))
//        graph.insert(Edge(9, 10))
//        graph.insert(Edge(0, 6))
//        graph.insert(Edge(7, 8))
//        graph.insert(Edge(9, 11))
//        graph.insert(Edge(5, 3))
        show(graph)
        print(graph.numEdges.toString() + " edges ")
        println("\nPerform DFS on a connected graph:")
        // Perform DFS on a connected graph. Only performs DFS on subgraph starting at vertice 0.
        val dfSc = GraphDFSc(graph, 0)
        //////////////////////////////////////////////////////////////////////////////
//        println("\nBFS Example:")
//        val numVertices1 = 8
//        val graph1: Graph = GraphAdjacencyMatrixImpl(numVertices1, false)
//
//        // Add edges
//        graph1.insert(Edge(0, 2))
//        graph1.insert(Edge(0, 5))
//        graph1.insert(Edge(0, 7))
//        graph1.insert(Edge(2, 6))
//        graph1.insert(Edge(6, 4))
//        graph1.insert(Edge(7, 1))
//        graph1.insert(Edge(5, 3))
//        graph1.insert(Edge(5, 4))
//        graph1.insert(Edge(4, 3))
//        graph1.insert(Edge(4, 7))
//        show(graph1)
//        print(graph1.numEdges.toString() + " edges ")
//        println("\nPerform BFS on a connected graph:")
//        // Perform BFS on a connected graph. Only performs BFS on subgraph starting at vertice 0.
//        val bfSc = GraphBFSc(graph1, 0)
        //////////////////////////////////////////////////////////////////////////////
    }
    */

}


fun main() {
    println("\nSlides Example:")
    val numVertices = 13
//    val graph: Graph = GraphAdjacencyMatrixImpl(numVertices, false)
    val graph: Graph = GraphAdjacencyListImpl(numVertices, false)

    // Add edges
    graph.insert(Edge(0, 1))
    graph.insert(Edge(0, 2))
    graph.insert(Edge(0, 5))
    graph.insert(Edge(0, 6))

    graph.insert(Edge(5, 3))
    graph.insert(Edge(5, 4))
    graph.insert(Edge(3, 4))
    graph.insert(Edge(6, 4))

    graph.insert(Edge(7, 8))

    graph.insert(Edge(9, 10))
    graph.insert(Edge(9, 11))
    graph.insert(Edge(12, 9))
    graph.insert(Edge(11, 12))

    GraphIO.show(graph)
    print(graph.numEdges.toString() + " edges ")
}









