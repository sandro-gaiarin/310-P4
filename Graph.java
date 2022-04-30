import java.util.*;

public class Graph<T> implements GraphInterface<T>{

    /**
     * HashMap of the vertices in this graph.
     */
    Map<T, Vertex<T>> vertices;

    /**
     * Counts edges up as they get added.
     */
    int edgeCount;

    /**
     * Constructor.
     */
    Graph() {
        //idk man, i really don't think much has to happen here
        vertices = new HashMap<>();
        edgeCount = 0;
    }



    /**
     * Adds given vertex to this graph.
     *
     * @param vertexLabel vertex to be added.
     * @return false if vertexLabel is null.
     */
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
    public VertexInterface<T> removeVertex(T vertexLabel) {
        VertexInterface<T> returnVertex = vertices.get(vertexLabel);
        vertices.remove(vertexLabel);
        return returnVertex;
    }

    /**
     * Adds weighted edge between two given vertices.
     *
     * @param begin      first vertex.
     * @param end        last vertex.
     * @param edgeWeight Weight of edge.
     * @return true if add is successful.
     */
    public boolean addEdge(T begin, T end, double edgeWeight) {
        try {
            vertices.get(begin).connect(vertices.get(end), edgeWeight);
            edgeCount += 1; //increase count of edges
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adds unweighted edge between two given vertices.
     *
     * @param begin first vertex.
     * @param end   last vertex.
     * @return true if add is successful.
     */
    public boolean addEdge(T begin, T end) {
        try {
            vertices.get(begin).connect(vertices.get(end));
            edgeCount += 1; //increase count of edges
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Removes weighted edge between two given distinct vertices that are currently in this graph.
     *
     * @param begin      first vertex.
     * @param end        last vertex.
     * @param edgeWeight weight of edge.
     * @return true if removal is successful, false otherwise.
     */
    public boolean removeEdge(T begin, T end, double edgeWeight) {
        try {
            vertices.get(begin).disconnect(vertices.get(end), edgeWeight);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Removes unweighted edge between two distinct vertices that are currently in this graph.
     *
     * @param begin first vertex.
     * @param end   last vertex.
     * @return true if removal is successful.
     */
    public boolean removeEdge(T begin, T end) {
        try {
            vertices.get(begin).connect(vertices.get(end));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if an undirected edge exists between two vertices.
     *
     * @param begin first vertex.
     * @param end   last vertex.
     * @return true if edge exists.
     */
    public boolean hasEdge(T begin, T end) {
        VertexInterface<T> firstVertex = vertices.get(begin);
        Iterator<VertexInterface<T>> nIterator = firstVertex.getNeighborIterator();
        while (nIterator.hasNext()) {
            if (nIterator.next().getLabel() == end) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return number of vertices in this graph.
     */
    public int getNumberOfVertices() {
        return vertices.size();
    }

    /**
     * @return number of edges in this graph.
     */
    public int getNumberOfEdges() {
        return edgeCount;
    }

    /**
     * @return true if the graph is empty.
     */
    public boolean isEmpty() {
        return (0 == vertices.size()); //returns true if there are no key-value mappings
    }

    /**
     * @return list of all vertices in graph.
     */
    public List<VertexInterface<T>> getVertices() {
        ArrayList<VertexInterface<T>> returnArray = new ArrayList<>();
        vertices.forEach((key, value) -> returnArray.add(value)); //haven't actually used forEach before, hope I did it right
        return returnArray;
    }

    /**
     * clears the graph.
     */
    public void clear() {
        vertices.clear();
        edgeCount = 0; //reset edgeCount!!
    }

    /**
     * Performs a breadth-first traversal of a graph.
     *
     * @param origin where the search begins.
     * @return queue that contains the result.
     */
    public Queue<T> getBreadthFirstTraversal(T origin) {
        Queue<T> returnQueue = new LinkedList<>();
        Queue<VertexInterface<T>> toCheckQueue = new LinkedList<>();
        VertexInterface<T> rootVertex = vertices.get(origin); //first vertex we check
        returnQueue.add(rootVertex.getLabel()); //add the label of the vertex to the linked list
        rootVertex.visit(); //mark root as visited
        toCheckQueue.add(rootVertex); //add root to check queue

        while (toCheckQueue.size() > 0) {
            VertexInterface<T> checkingVertex = toCheckQueue.poll(); //pull next guy from the check queue
            while (checkingVertex.getUnvisitedNeighbor() != null) { //if getUnivisitedNeighbor is returning something, then we have more vertexes to visit
                VertexInterface<T> neighborVertex = checkingVertex.getUnvisitedNeighbor(); //get the vertex that getUnvisited is returning
                neighborVertex.visit(); //mark it as visited
                toCheckQueue.add(neighborVertex); //add it to the "to check queue"
                returnQueue.add(neighborVertex.getLabel()); //add it to the queue we'll return
            }
        }
        returnQueue.forEach((label) -> vertices.get(label).unvisit()); //mark all the vertices as unvisited again!!
        return returnQueue;
        // I ended up making this generic to VertexInterface because a lot of the Vertex class is generic.
    }

    /**
     * @param origin      first vertex.
     * @param destination destination vertex.
     * @param path        An empty stack, to be filled with the labels of vertices in the path to the destination.
     * @return shortest distance between origin and destination, if it exists (otherwise, returns max int).
     */
    public int getShortestPath(T origin, T destination, Stack<T> path) {
        VertexInterface<T> vertexStart = vertices.get(origin);
        vertexStart.visit();
        path.push(origin);
        while (!path.isEmpty()) {
            VertexInterface<T> stackTop = vertices.get(path.peek()); //current top vertex on the stack
            if (stackTop.getLabel() != destination) { //if top of stack is not destination...
                if (stackTop.getUnvisitedNeighbor() != null) { //if top of stack still has unvisited neighbors...
                    path.push(stackTop.getUnvisitedNeighbor().getLabel()); //add the neighbor to the stack
                    stackTop.getUnvisitedNeighbor().visit(); //mark the neighbor as visited
                }
                else { //if the top of the stack has no unvisited neighbors
                    path.pop(); //remove it from the stack
                }
            }
            else { //else, we have reached the destination.
                int returnInt = 0;
                while (!path.isEmpty()) { //count up on return int for each stack value popped out
                    path.pop();
                    returnInt += 1;
                }
                return returnInt;
            }

        }
        return Integer.MAX_VALUE; //return max value if there is no path!
    } //TODO Add unvisitAll function?
}
