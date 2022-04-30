import java.util.Iterator;

/**
 * Generic interface of a vertex for a graph data structure.
 * @param <T> generic parameter
 * @author Alessandro Gaiarin
 * @version 0.9
 */
public interface VertexInterface<T> {
    /**
     * Getter for label.
     * @return vertex's label.
     */
    T getLabel();

    /**
     * Getter for number of neighbors.
     * @return number of neighbors of this vertex.
     */
    int getNumberOfNeighbors();

    /**
     * marks vertex as visited.
     */
    void visit();

    /**
     * removes vertex's visited mark.
     */
    void unvisit();

    /**
     * Returns true if vertex has been visited.
     * @return true if vertex is visited, false otherwise.
     */
    boolean isVisited();

    /**
     * Connects this vertex and endVertex with a weighted edge.
     * The vertices cannot be the same, and must not already have this edge between them.
     * @param endVertex the vertex that this vertex is getting connected to.
     * @param edgeWeight weight of the edge.
     * @return true if the connection is successful.
     */
    boolean connect(VertexInterface<T> endVertex, double edgeWeight);

    /**
     * Connects this vertex and endVertex with an unweighted edge.
     * @param endVertex vertex that is getting connected.
     * @return true if the connection is successful.
     */
    boolean connect(VertexInterface<T> endVertex);

    /**
     * Disconnects vertex from a given vertex with a weighted edge.
     * The edge should exist in order to be disconnected.
     * @param endVertex vertex we're disconnecting from.
     * @param edgeWeight weight of the edge we're disconnecting.
     * @return true if the disconnection is successful.
     */
    boolean disconnect(VertexInterface<T> endVertex, double edgeWeight);

    /**
     * Disconnects vertex from a given vertex with an unweighted edge.
     * @param endVertex vertex we're disconnecting from.
     * @return true if disconnection is successful.
     */
    boolean disconnect(VertexInterface<T> endVertex);

    /**
     * creates an iterator of this vertex's neighbors by following all
     * edges that begin at this vertex.
     * @return iterator.
     */
    Iterator<VertexInterface<T>> getNeighborIterator();

    /**
     * creates an iterator of the weights of the edges this vertex's neighbors
     * by following all edges that begin at this vertex.
     * @return iterator.
     */
    Iterator<Double> getWeightIterator();

    /**
     * Returns true if this vertex has at least one neighbor.
     * @return true if this vertex has at least one neighbor.
     */
    boolean hasNeighbor();

    /**
     * Returns an unvisited neighbor if one exists.
     * @return an unvisited neighbor, if any, of this vertex.
     */
    VertexInterface<T> getUnvisitedNeighbor();

    /**
     * Records the previous vertex on a path to this vertex.
     * @param predecessor previous vertex.
     */
    void setPredecessor(VertexInterface<T> predecessor);

    /**
     * Returns recorded predecessor of this vertex.
     * @return recorded predecessor of this vertex.
     */
    VertexInterface<T> getPredecessor();

    /**
     * Returns true if a predecessor was recorded for this vertex.
     * @return true if a predecessor was recorded for this vertex.
     */
    boolean hasPredecessor();

    /**
     * Records cost of a path to this vertex.
     * @param newCost cost to be recorded.
     */
    void setCost(double newCost);

    /**
     * Returns cost of a path to this vertex.
     * @return cost of a path to this vertex.
     */
    double getCost();
}
