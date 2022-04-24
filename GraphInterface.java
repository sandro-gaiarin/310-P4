import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Interface that represents functionalities of the graph data structure.
 *
 * @author Alessandro Gaiarin
 * @version 0.1
 */

public interface GraphInterface<T> {
    /**
     * Adds given vertex to this graph.
     * @param vertexLabel vertex to be added.
     * @return false if vertexLabel is null.
     */
    boolean addVertex(T vertexLabel);

    /**
     * Removes vertex.
     * @param vertexLabel Removes vertex with this vertexLabel.
     * @return the removed vertex, or none if it doesn't exist.
     */
    VertexInterface<T> removeVertex(T vertexLabel); //TODO VertexInterface<T> needs to be implemented

    /**
     * Adds weighted edge between two given vertices.
     * @param begin first vertex.
     * @param end last vertex.
     * @param edgeWeight Weight of edge.
     * @return true if add is successful.
     */
    boolean addEdge(T begin, T end, double edgeWeight);

    /**
     * Adds unweighted edge between two given vertices.
     * @param begin first vertex.
     * @param end last vertex.
     * @return true if add is successful.
     */
    boolean addEdge(T begin, T end);

    /**
     * Removes weighted edge between two given distinct vertices that are currently in this graph.
     * @param begin first vertex.
     * @param end last vertex.
     * @param edgeWeight weight of edge.
     * @return true if removal is successful, false otherwise.
     */
    boolean removeEdge(T begin, T end, double edgeWeight);

    /**
     * Removes unweighted edge between two distinct vertices that are currently in this graph.
     * @param begin first vertex.
     * @param end last vertex.
     * @return true if removal is successful.
     */
    boolean removeEdge(T begin, T end);

    /**
     * Checkes if an undirected edge exists between two vertices.
     * @param begin first vertex.
     * @param end last vertex.
     * @return true if edge exists.
     */
    boolean hasEdge(T begin, T end);

    /**
     * @return number of vertices in this graph.
     */
    int getNumberOfVertices();

    /**
     * @return number of edges in this graph.
     */
    int getNumberOfEdges();

    /**
     * @return true if the graph is empty.
     */
    boolean isEmpty();

    /**
     * @return list of all vertices in graph.
     */
    List<VertexInterface<T>> getVertices();

    /**
     * clears the graph.
     */
    void clear();

    /**
     * Performs a breadth-first traversal of a graph.
     * @param origin where the search begins.
     * @return queue that contains the result.
     */
    Queue<T> getBreadthFirstTraversal(T origin);

    /**
     *
     * @param origin first vertex.
     * @param destination destination vertex.
     * @param path ???
     * @return shortest distance between origin and destination, if it exists (otherwise, returns max int).
     */
    int getShortestPath(T origin, T destination, Stack<T> path); //TODO doc comment cleanup
}
