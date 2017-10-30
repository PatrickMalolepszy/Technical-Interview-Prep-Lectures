## Trees & Graph Traversal

Patrick Malolepszy Oct. 23 2017

[malolepp.myweb.cs.uwindsor.ca](http://malolepp.myweb.cs.uwindsor.ca)



## Some questions from last time:
- How do I know if I'm ready to do an internship? Is it the same case for both graduates and undergraduates?
- How to determine skill-sets, passions, interests, etc. and excel in them. 
- What is the motivation behind working with Github?



## Graphs
- Data structure in which each node has a list of adjacent nodes
- Recursive data structure


## Trees
- Are graphs
- Added restriction: No loops (circuits).
- Easier to work with.

\* *There are more precise definitions which I will not go into here*


### Example Graph
![](img/graph.png)


### Example Binary Tree
![](img/binaryTree.jpg)


### Graph/Tree Implementation
```java
public class Node<T> {
    private List<Node<T>> children;
    private T datum;

    public Node (T datum) {
        children = new ArrayList<>();
        this.datum = datum;
    }
}
```


### Binary Tree Implementation
```java
public class Node<T> {
    private Node<T> left;
    private Node<T> right;
    private T datum;

    public Node (T datum) {
        left = null;
        right = null;
        this.datum = datum;
    }
}
```



## Tree Terminology


### Full:
Every node but the leaves have 2 children.

![](img/FullBinary.jpg)


### Complete: 
Every level of the tree is filled left to right.

![](img/CompleteBinary.jpg)



## Traversal Methods

- **Depth-First Search:** Starts at the root, and explores as far as possible along each branch before backtracking.
- **Breadth-First Search:** Starts at the root, and explores the tree in a level order approach, proceeding one level at a time.


### Depth First
![](img/Depth-First-Search.gif)


### Depth First Implementation (TREE)
```java
public void depthFirstPrint(Node<T> root) {
    if (root == null) return;
    System.out.println(root.datum);
    for (Node node : root.children) {
        depthFirstPrint(node);
    }
}
```


### Breadth First
![](img/Breadth-First-Search.gif)


### Breadth First Implementation (TREE)
```java
public void breadthFirstPrint(Node<T> root) {
    if (root == null) return;
    Queue<Node<T>> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node<T> current = queue.remove();
        System.out.println(current.datum);
        for (Node node : current.children) {
            queue.add(node);
        }
    }
}
```



### Example:

Given a tree return the minimum height.

- Implement with both a depth first search and breadth first search.
- Compare the implementations. Describe the advantages and disadvantages of each.


### Depth First
```java
public int findMinimumHeightDepthFirst(Node<T> root) {
    if (root == null) {
        throw new IllegalArgumentException("null root");
    }
    if (root.children.isEmpty()) {
        return 0;
    }
    List<Integer> depths = new ArrayList<>();
    for (Node<T> node : root.children) {
        int depth = findMinimumHeightDepthFirst(node);
        depths.add(depth);
    }
    int minimum = Integer.MAX_VALUE;
    for (int i : depths) {
        if (i < minimum) {
            minimum = i;
        }
    }
    return minimum + 1;
}
```


### Breadth First
```java
public int findMinimumHeightBreadthFirst(Node<T> root) {
    if (root == null) {
        throw new IllegalArgumentException("null root");
    }
    Queue<Node<T>> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node<T> current = queue.remove();
        if (current.children.isEmpty()) {
            return current.height;
        }
        for (Node<T> node : current.children) {
            node.height = current.height + 1;
            queue.add(node);
        }
    }
    return 0;
}
```


Given a tree which may not be finite, how would you approach finding a node? 


### Searching Algorithm Completeness Property

> If there is a solution, the algorithm is guaranteed to find it.

Depth First Search is not complete as it breaks on an infinite branch.



## Thank you!

See you next week.