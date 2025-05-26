package aula31.mygraph

/**
 * Code adapted from Sedgewick's Book "Algorithms in Java"
 *
 */
class Edge : Comparable<Edge?> {
    /**
     * Vertices v and w
     */
    var v: Int
    var w: Int

    /**
     * Edge weight
     */
    var weight: Double

    /**
     * Constructor
     * @param v
     * @param w
     */
    constructor(v: Int, w: Int) {
        this.v = v
        this.w = w
        weight = 1.0
    }

    /**
     * Constructor
     * @param v
     * @param w
     * @param weight
     */
    constructor(v: Int, w: Int, weight: Double) {
        this.v = v
        this.w = w
        this.weight = weight
    }

    override operator fun compareTo(edge: Edge?): Int {
        // Compare two double taking into account rounding errors
        return java.lang.Double.compare(weight, edge!!.weight)
    }
}