package source_code;

import java.util.*;

public class DFS_And_BFS {

    // Adjacency list representation of the graph is stored in graph
    private Map<String, List<String>> graph;

    public DFS_And_BFS() {
        graph = new HashMap<>();
        /*
         *  Before this constructor, we have declared a variable graph of type Map, which uses generic types String as keys
         *  and List<String> as values. The actual implementation of the map is a HashMap once inside the constructor.
         *  We initialize the graph based on the picture given.
         */

        // graph.put( arg 1 = THE NAME OF OUR NODE AS A STRING, arg 2 = THE NAMES OF CONNECTING NODES AS A LIST OF STRINGS)
        graph.put("A", Arrays.asList("C", "E"));
        graph.put("B", Arrays.asList("C", "F"));
        graph.put("C", Arrays.asList("A", "B", "D", "E", "F"));
        graph.put("D", Arrays.asList("C", "F"));
        graph.put("E", Arrays.asList("A", "C", "F"));
        graph.put("F", Arrays.asList("D", "C", "B"));
    }

    // Breadth first search  traversal
    public List<String> bfs(String startNode) {
        List<String> result = new ArrayList<>(); // Stores final order of traversal.
        Queue<String> queue = new LinkedList<>(); // Queue for BFS level-order traversal.
        Set<String> visited = new HashSet<>(); // Keeps track of visited nodes.

        /*
         * Begin with the start node
         * Add the start node to the queue
         * Mark the start node as visited
         */
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) { // Process nodes in the queue until it's empty
            String currentNode = queue.poll(); // Remove the node at the front of the queue
            result.add(currentNode); // Add the current node to the result list

            // Retrieve all neighbors of the current node
            List<String> neighbors = graph.get(currentNode);
            Collections.sort(neighbors); // Ensure neighbors are processed in alphabetical order for consistency
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) { // Only add unvisited neighbors
                    queue.add(neighbor); // Add neighbor to the queue for future processing
                    visited.add(neighbor); // Mark the neighbor as visited
                }
            }
        }
        // Return the list of nodes, which contains the bfs traversal order
        return result;
    }

    // Depth first search traversal
    public List<String> dfs(String startNode) {
        List<String> result = new ArrayList<>(); // Again, create an ArrayList to store the order of traversal
        Stack<String> stack = new Stack<>(); // Stack instead of queue for depth-first traversal.
        Set<String> visited = new HashSet<>(); // Keeps track of nodes already visited.

        // Start  by pushing the start node onto the stack and continue until all nodes are processed
        stack.push(startNode);

        while (!stack.isEmpty()) {
            String currentNode = stack.pop(); // Pop the top node from the stack
            if (!visited.contains(currentNode)) { // Process the node only if it's not visited
                visited.add(currentNode); // Mark the node as visited
                result.add(currentNode); // Add the current node to the result list

                // Retrieve neighbors and process them
                List<String> neighbors = graph.get(currentNode);
                Collections.sort(neighbors, Collections.reverseOrder()); // Reverse alphabetical order for DFS
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) { // Add unvisited neighbors to the stack
                        stack.push(neighbor);
                    }
                }
            }
        }
        // Return the list of nodes which are now in DFS order
        return result;
    }

    public static void main(String[] args) {
    	DFS_And_BFS traversal = new DFS_And_BFS();

        // Perform BFS and DFS with start node A
        List<String> bfsResult = traversal.bfs("A");
        List<String> dfsResult = traversal.dfs("A");

        // Display
        System.out.println("DFS traversal of graph: " + String.join(", ", dfsResult));
        System.out.println("BFS traversal of graph: " + String.join(", ", bfsResult));
    }
}