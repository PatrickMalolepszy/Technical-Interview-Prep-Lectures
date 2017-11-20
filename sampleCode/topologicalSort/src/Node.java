import java.util.ArrayList;
import java.util.List;

class Node<T> {
    T data;
    List<Node<T>> adjacentNodes;
    int inBoundNodes;

    public Node(T data) {
        this.data = data;
        adjacentNodes = new ArrayList<>();
    }
}
