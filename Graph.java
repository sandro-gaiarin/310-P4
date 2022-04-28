import java.util.*;

public class Graph<T> implements GraphInterface<T>{

    Map<T, Vertex<T>> vertices;

    Graph() {
        //idk man, i really don't think much has to happen here
        vertices = new HashMap<>();
    }



    /**
     * Adds given vertex to this graph.
     *
     * @param vertexLabel vertex to be added.
     * @return false if vertexLabel is null.
     */
    @Override
    public boolean addVertex(T vertexLabel) {
        try {
            vertices.put(vertexLabel, new Vertex<>(vertexLabel));
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Removes vertex.
     *
     * @param vertexLabel Removes vertex with this vertexLabel.
     * @return the removed vertex, or none if it doesn't exist.
     */
    @Override
    public VertexInterface<T> removeVertex(T vertexLabel) {
        return null;
    }

    /**
     * Adds weighted edge between two given vertices.
     *
     * @param begin      first vertex.
     * @param end        last vertex.
     * @param edgeWeight Weight of edge.
     * @return true if add is successful.
     */
    @Override
    public boolean addEdge(T begin, T end, double edgeWeight) {
        return false;
    }

    /**
     * Adds unweighted edge between two given vertices.
     *
     * @param begin first vertex.
     * @param end   last vertex.
     * @return true if add is successful.
     */
    @Override
    public boolean addEdge(T begin, T end) {
        return false;
    }

    /**
     * Removes weighted edge between two given distinct vertices that are currently in this graph.
     *
     * @param begin      first vertex.
     * @param end        last vertex.
     * @param edgeWeight weight of edge.
     * @return true if removal is successful, false otherwise.
     */
    @Override
    public boolean removeEdge(T begin, T end, double edgeWeight) {
        return false;
    }

    /**
     * Removes unweighted edge between two distinct vertices that are currently in this graph.
     *
     * @param begin first vertex.
     * @param end   last vertex.
     * @return true if removal is successful.
     */
    @Override
    public boolean removeEdge(T begin, T end) {
        return false;
    }

    /**
     * Checkes if an undirected edge exists between two vertices.
     *
     * @param begin first vertex.
     * @param end   last vertex.
     * @return true if edge exists.
     */
    @Override
    public boolean hasEdge(T begin, T end) {
        return false;
    }

    /**
     * @return number of vertices in this graph.
     */
    @Override
    public int getNumberOfVertices() {
        return 0;
    }

    /**
     * @return number of edges in this graph.
     */
    @Override
    public int getNumberOfEdges() {
        return 0;
    }

    /**
     * @return true if the graph is empty.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @return list of all vertices in graph.
     */
    @Override
    public List<VertexInterface<T>> getVertices() {
        return null;
    }

    /**
     * clears the graph.
     */
    @Override
    public void clear() {

    }

    /**
     * Performs a breadth-first traversal of a graph.
     *
     * @param origin where the search begins.
     * @return queue that contains the result.
     */
    @Override
    public Queue<T> getBreadthFirstTraversal(T origin) {
        return null;
    }

    /**
     * @param origin      first vertex.
     * @param destination destination vertex.
     * @param path        ???
     * @return shortest distance between origin and destination, if it exists (otherwise, returns max int).
     */
    @Override
    public int getShortestPath(T origin, T destination, Stack<T> path) {
        return 0;
    }
}
