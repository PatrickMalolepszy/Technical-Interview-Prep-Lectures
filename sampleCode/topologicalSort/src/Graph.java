import java.util.*;

public class Graph<T> {

    List<Node<T>> nodes;

    public List<T> topologicalSort() {

        List<T> topologicalOrdering = new ArrayList<>();
        Queue<Node<T>> processNext = new LinkedList<>();

        // First update all nodes with number of inbound connections:
        for (Node<T> n : nodes) {
            for(Node<T> m : n.adjacentNodes) {
                m.inBoundNodes++;
            }
        }

        /* Find all nodes with no incoming connections,
             and to the queue of node to be processed. */
        for (Node<T> n : nodes) {
            if (n.inBoundNodes == 0) {
                processNext.add(n);
            }
        }

        /* process each node,
            decrement its adjacent nodes inbound nodes,
             if the adjacent node has 0 inbound edges, add it to the queue to be processed.*/
        while (!processNext.isEmpty()) {
            Node<T> n = processNext.remove();
            for (Node<T> m : n.adjacentNodes) {
                m.inBoundNodes--;
                if (m.inBoundNodes == 0 ) {
                    processNext.add(m);
                }
            }
            topologicalOrdering.add(n.data);
        }

        return topologicalOrdering;
    }
}
