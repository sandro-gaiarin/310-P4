import java.util.*;


public class Vertex<T> implements VertexInterface<T>{

    /**
     * label of the vertex.
     */
    T label;
    /**
     * stores if the vertex has been visited or not.
     */
    boolean visited;
    /**
     * the previous vertex on the path to this vertex.
     */
    VertexInterface<T> previousVertex;
    /**
     * cost of the path to this vertex.
     */
    double cost;
    /**
     * list of edges to neighbors.
     */
    List<Edge> edgeList; //TODO Edge class??


    /*--------------------------------------------------------------------------
    Private class: Edge
     -------------------------------------------------------------------------*/
    //TODO Create inner class: Edge. We can use the example from the textbook.
    private class Edge {
        VertexInterface<T> endVertex;
        double weight;

        /**
         * Constructor, no weight parameter.
         * @param vertex endVertex.
         */
        Edge(VertexInterface<T> vertex) {
            endVertex = vertex;
            weight = 0; //no weight provided in this constructor
        }

        /**
         * Constructor with a weighted edge.
         * @param vertex  endVertex.
         * @param weight weight of edge.
         */
        Edge(VertexInterface<T> vertex, double weight) {
            endVertex = vertex;
            this.weight = weight;
        }

        /**
         * Getter for the end vertex.
         * @return endVertex.
         */
        VertexInterface<T> getEndVertex() {
            return endVertex;
        }

        /**
         * Getter for weight.
         * @return weight.
         */
        double getWeight() {
            return weight;
        }
    }


    /*----------------------------------------------------------------------
    Constructor:
     ---------------------------------------------------------------------*/
    /**
     * Constructor.
     * @param vertexLabel label of the vertex
     */
    Vertex(T vertexLabel) {
        label = vertexLabel;
        visited = false;
        previousVertex = null;
        //TODO: edgeList needs to be initialized to a default list?
        edgeList = new LinkedList<>();
    }

    /**
     * @return vertex's label.
     */
    public T getLabel() {
        return label;
    }

    /**
     * @return number of neighbors of this vertex.
     */
    public int getNumberOfNeighbors() {
        return edgeList.size(); //TODO this won't work
    }

    /**
     * marks vertex as visited.
     */
    public void visit() {
        visited = true;
    }

    /**
     * removes vertex's visited mark.
     */
    public void unvisit() {
        visited = false;
    }

    /**
     * @return true if vertex is visited, false otherwise.
     */
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
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
        Edge newEdge = new Edge(endVertex, edgeWeight);
        if (!edgeList.contains(newEdge) || endVertex.getLabel() != label) {
            edgeList.add(newEdge);
            return true;
        }
        return false;
    }

    /**
     * Connects this vertex and endVertex with an unweighted edge.
     *
     * @param endVertex vertex that is getting connected.
     * @return true if the connection is successful.
     */
    public boolean connect(VertexInterface<T> endVertex) {
        Edge newEdge = new Edge(endVertex);
        if (!edgeList.contains(newEdge) || endVertex.getLabel() != label) {
            edgeList.add(newEdge);
            return true;
        }
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
    public boolean disconnect(VertexInterface<T> endVertex, double edgeWeight) {
        for (int i = 0; i < edgeList.size(); ++i) {
            Edge currentEdge = edgeList.get(i);
            if (currentEdge.getEndVertex() == endVertex && currentEdge.getWeight() == edgeWeight) {
                edgeList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Disconnects vertex from a given vertex with an unweighted edge.
     *
     * @param endVertex vertex we're disconnecting from.
     * @return true if disconnection is successful.
     */
    public boolean disconnect(VertexInterface<T> endVertex) {
        for (int i = 0; i < edgeList.size(); ++i) {
            Edge currentEdge = edgeList.get(i);
            if (currentEdge.getEndVertex() == endVertex) {
                edgeList.remove(i);
                return true;
            }
        }
        return false;
    }

    /*---------------------------------------------------------------------------------
    NeighborIterator:
    ---------------------------------------------------------------------------------*/
    /**
     * creates an iterator of this vertex's neighbors by following all
     * edges that begin at this vertex.
     *
     * @return iterator.
     */
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return new NeighborIterator();
    }


    /**
     * Private class NeighborIterator, for use in getNeighborIterator.
     */
    private class NeighborIterator implements Iterator<VertexInterface<T>> {

        /**
         * Iterator over edgeList.
         */
        private Iterator<Edge> edgeIterator;

        /**
         * Constructor.
         */
        private NeighborIterator() {
            edgeIterator = edgeList.listIterator();
        }

        /**
         * Returns true if there are more elements in the list.
         * @return true if there are more elements in the list.
         */
        public boolean hasNext() {
            return edgeIterator.hasNext();
        }

        /**
         * Returns next vertex in the list; NOT the edge!
         * @return next vertex stored in edgeList.
         */
        public VertexInterface<T> next() {
            try {
                return edgeIterator.next().getEndVertex();
            } catch (NoSuchElementException e) {
                throw e;
            }
        }

        /**
         * Not implemented.
         * @throws UnsupportedOperationException.
         */
        public void remove() {
            Iterator.super.remove();
        }
    }

    /*------------------------------------------------------------------------
    WeightIterator:
     -----------------------------------------------------------------------*/
    /**
     * creates an iterator of the weights of the edges this vertex's neighbors
     * by following all edges that begin at this vertex.
     *
     * @return iterator.
     */
    public Iterator<Double> getWeightIterator() {
        return new WeightIterator();
    }

    /**
     * Private class WeightIterator, for use in getWeightIterator.
     */
    private class WeightIterator implements Iterator<Double> {

        /**
         * Iterator over edgeList.
         */
        private Iterator<Edge> edgeIterator;

        /**
         * Constructor.
         */
        private WeightIterator() {
            edgeIterator = edgeList.listIterator();
        }

        /**
         * Returns true if there are more elements in the list.
         * @return true if there are more elements in the list.
         */
        public boolean hasNext() {
            return edgeIterator.hasNext();
        }

        /**
         * Returns weight of next edge in list.
         * @return double, weight of edge.
         */
        public Double next() {
            try {
                return edgeIterator.next().getWeight();
            } catch (NoSuchElementException e) {
                throw e;
            }
        }

        /**
         * Not implemented.
         * @throws UnsupportedOperationException.
         */
        public void remove() {
            Iterator.super.remove();
        }
    }

    /**
     * @return true if this vertex has at least one neighbor.
     */
    @Override
    public boolean hasNeighbor() {

    }

    /**
     * @return an unvisited neighbor, if any, of this vertex.
     */
    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {

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

    }

    /**
     * @return true if a predecessor was recorded for this vertex.
     */
    @Override
    public boolean hasPredecessor() {

    }

    /**
     * Records cost of a path to this vertex.
     *
     * @param newCost cost to be recorded.
     */
    @Override
    public void setCost(double newCost) {
        cost = newCost;
    }

    /**
     * @return cost of a path to this vertex.
     */
    @Override
    public double getCost() {
        return cost;
    }
}
