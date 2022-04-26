import java.util.Iterator;

public class Vertex<T> implements VertexInterface<T>{

    T label;
    boolean visited;
    VertexInterface<T> previousVertex;
    double cost;
    List<Edge> edgeList; //TODO Edge class??

    /**
     * Constructor.
     * @param vertexLabel label of the vertex
     */
    Vertex(T vertexLabel) {
        label = vertexLabel;
        visited = false;
        previousVertex = null;
        //TODO: edgeList needs to be initialized to a default list?
    }

    /**
     * @return vertex's label.
     */
    @Override
    public T getLabel() {
        return label;
    }

    /**
     * @return number of neighbors of this vertex.
     */
    @Override
    public int getNumberOfNeighbors() {
        return 0;
    }

    /**
     * marks vertex as visited.
     */
    @Override
    public void visit() {
        visited = true;
    }

    /**
     * removes vertex's visited mark.
     */
    @Override
    public void unvisit() {
        visited = false;
    }

    /**
     * @return true if vertex is visited, false otherwise.
     */
    @Override
    public boolean isVisited() {
        return visited;
    }

    /**
     * Connects this vertex and endVertex with a weighted edge.
     * The vertices cannot be the same, and must not already have this edge between them.
     *
     * @param endVertex  the vertex that this vertex is getting connected to.
     * @param edgeWeight weight of the edge.
     * @return true if the connection is successful.
     */
    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
        return false;
    }

    /**
     * Connects this vertex and endVertex with an unweighted edge.
     *
     * @param endVertex vertex that is getting connected.
     * @return true if the connection is successful.
     */
    @Override
    public boolean connect(VertexInterface<T> endVertex) {
        return false;
    }

    /**
     * Disconnects vertex from a given vertex with a weighted edge.
     * The edge should exist in order to be disconnected.
     *
     * @param endVertex  vertex we're disconnecting from.
     * @param edgeWeight weight of the edge we're disconnecting.
     * @return true if the disconnection is successful.
     */
    @Override
    public boolean disconnect(VertexInterface<T> endVertex, double edgeWeight) {
        return false;
    }

    /**
     * Disconnects vertex from a given vertex with an unweighted edge.
     *
     * @param endVertex vertex we're disconnecting from.
     * @return true if disconnection is successful.
     */
    @Override
    public boolean disconnect(VertexInterface<T> endVertex) {
        return false;
    }

    /**
     * creates an iterator of this vertex's neighbors by following all
     * edges that begin at this vertex.
     *
     * @return iterator.
     */
    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return null;
    }

    /**
     * creates an iterator of the weights of the edges this vertex's neighbors
     * by following all edges that begin at this vertex.
     *
     * @return iterator.
     */
    @Override
    public Iterator<Double> getWeightIterator() {
        return null;
    }

    /**
     * @return true if this vertex has at least one neighbor.
     */
    @Override
    public boolean hasNeighbor() {
        return false;
    }

    /**
     * @return an unvisited neighbor, if any, of this vertex.
     */
    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {
        return null;
    }

    /**
     * Records the previous vertex on a path to this vertex.
     *
     * @param predecessor previous vertex.
     */
    @Override
    public void setPredecessor(VertexInterface<T> predecessor) {

    }

    /**
     * @return recorded predecessor of this vertex.
     */
    @Override
    public VertexInterface<T> getPredecessor() {
        return null;
    }

    /**
     * @return true if a predecessor was recorded for this vertex.
     */
    @Override
    public boolean hasPredecessor() {
        return false;
    }

    /**
     * Records cost of a path to this vertex.
     *
     * @param newCost cost to be recorded.
     */
    @Override
    public void setCost(double newCost) {

    }

    /**
     * @return cost of a path to this vertex.
     */
    @Override
    public double getCost() {
        return 0;
    }
}
