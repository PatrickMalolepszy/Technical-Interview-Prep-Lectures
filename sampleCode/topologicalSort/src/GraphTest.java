import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {

    @Test
    public void testTopSort() {
        Graph<Integer> graph = new Graph<>();
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        n1.adjacentNodes.add(n2);
        n2.adjacentNodes.add(n3);
        n2.adjacentNodes.add(n5);
        n4.adjacentNodes.add(n2);
        n5.adjacentNodes.add(n6);
        n6.adjacentNodes.add(n3);
        List<Node<Integer>> graphNodes = new ArrayList<>();
        graphNodes.add(n1);
        graphNodes.add(n2);
        graphNodes.add(n3);
        graphNodes.add(n4);
        graphNodes.add(n5);
        graphNodes.add(n6);
        graph.nodes = graphNodes;
        List<Integer> topSorted = graph.topologicalSort();
        System.out.println(topSorted);
    }

}

