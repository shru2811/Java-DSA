import java.util.*;

public class WieghtedGraph {
    private int vertices;
    private Map<Integer, List<Node>> adjacencyList;

    public WieghtedGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 1; i <= vertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        if (!adjacencyList.containsKey(source)) {
            adjacencyList.put(source, new LinkedList<>());
        }
        if (!adjacencyList.containsKey(destination)) {
            adjacencyList.put(destination, new LinkedList<>());
        }

        adjacencyList.get(source).add(new Node(destination, weight));
        adjacencyList.get(destination).add(new Node(source, weight)); // for undirected graph
    }

    public List<Node> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    public int getWeight(int source, int destination) {
        for (Node node : adjacencyList.get(source)) {
            if (node.vertex == destination) {
                return node.weight;
            }
        }
        return -1; // If there is no edge between source and destination
    }

    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public void dijkshtra(int src) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        Map<Integer, Integer> dist = new HashMap<>();

        // Step 1: Initialization
        for (int vertex : this.getVertices()) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(src, 0);
        minHeap.add(new Node(src, 0));

        // Step 2: Relaxation
        while (!minHeap.isEmpty()) {
            int curr = minHeap.poll().vertex;

            // Neighbors of the current node are accessed to update their distances
            for (Node neighbor : this.getNeighbors(curr)) {
                if (dist.get(curr) == Integer.MAX_VALUE) {
                    // Skip if the distance to the current node is infinity
                    continue;
                }

                int newDist = dist.get(curr) + this.getWeight(curr, neighbor.vertex);

                // Relaxation: update the distances if the calculated one is lesser
                if (newDist < dist.get(neighbor.vertex)) {
                    dist.put(neighbor.vertex, newDist);
                    minHeap.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        // Step 3: Termination
        System.out.println("The shortest distances from source " + src + " are: " + dist);
    }


    public static void main(String[] args) {
        WieghtedGraph wg = new WieghtedGraph(8);
        wg.addEdge(0,1,4);
        wg.addEdge(0,7,8);
        wg.addEdge(1,7,11);
        wg.addEdge(1,2,8);
        wg.addEdge(7,8,7);
        wg.addEdge(7,6,1);
        wg.addEdge(2,8,2);
        wg.addEdge(8,6,6);
        wg.addEdge(6,5,2);
        wg.addEdge(2,5,4);
        wg.addEdge(2,3,7);
        wg.addEdge(3,5,14);
        wg.addEdge(3,4,9);
        wg.addEdge(5,4,10);
        wg.dijkshtra(0);
    }
}
