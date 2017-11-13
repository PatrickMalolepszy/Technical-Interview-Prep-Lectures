# Heaps

### Patrick Malolepszy - Nov. 13 / 2017



## Overview

* What is a heap?
* Implementation.
* Complexities!
* When to use one?
* Sample question.



## What is a Heap?

* Binary Heaps are a **complete** **binary** tree data-structure used to efficiently store ordered data
* Heaps store values with the following “Heap” property:
    * For a node A, its children B and C (if it has them), have values less than or equal to A 
    * (val(A) >= val(B) and val(A) >= val(C)
* The above rule is for max heaps, but can easily be changed to create min heaps.


### Complete Tree

> “All levels of the tree, except possibly the last one (deepest), are fully filled, and, if the last level of the tree is not complete, the nodes of that level are filled from left to right.”
- wikipedia


![](../img/CompleteBinary.jpg)


### Max Heap Example

![](../img/maxHeap.png)


### Min heap, max heap

![](../img/heap.bmp)



## When to use a heap?




## Implementation

* Since the Heap must be a complete binary tree, we can actually store the data in an array.
* Avoids the overhead of a tree-based implementations (no pointers to other nodes).


### Implicit Data Structure

> "An implicit data structure or space-efficient data structure is a data structure that stores very little information other than the main or required data: a data structure that requires low overhead." - wikipedia


### Indexing elements in array as a complete binary tree:

For a node at index i, we can find it’s left and right children:

* left_child = (i * 2) + 1
* right_child = (i * 2) + 2


![](../img/completeTreeArray.gif)


### Creating heap class

Our heap class needs only two member variables:

* The array containing the data
* An index representing the current “size” of the array, used for where to insert elements into the heap


```java
public class Heap <T extends Comparable<T>> {

    private List<T> data;

    // Constructor:
    public Heap() {
        this.data = new ArrayList<>();
    }
}
```


### Accessor Methods:

```java
public void push(T n) {
    data.add(n);
    bubbleUp(data.size() - 1);
}

public T top() {
    return data.get(0);
}

public void pop() {
    data.set(0, data.remove(data.size()-1));
    bubbleDown(0);
}
```


### Bubble Up:

```java
private void bubbleUp(int i) {
    int parent = i / 2;
    while (i > 0 && (data.get(i).compareTo(data.get(parent)) > 0 )) {
        Collections.swap(data, i, parent);
        i = parent;
        parent = i / 2;
    }
}
```


![](../img/Insert-Bubble-Up-Min-Heap.gif)


### Bubble Down:

```java
private void bubbleDown(int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int next = i;

    if ((left < data.size()) && (data.get(left).compareTo(data.get(i)) > 0)) {
        next = left;
    }
    if ((right < data.size()) && (data.get(right).compareTo(data.get(k)) > 0)) {
        next = right;
    }

    if (next != i) {
        Collections.swap(data, i, next);
        bubbleDown(next);
    }
}
```


![](../img/bubbleDown.gif)


## Testing

```java
private Heap<Integer> heap;

@Before
public void init() {
    heap = new Heap<>();
    heap.push(3);
    heap.push(2);
    heap.push(5);
    heap.push(4);
}
```

## Testing

```java
@Test
public void TopOfHeapShouldBeMaxElement() {
    // Arrange
    int  expected = 5;
    // Act
    int result = heap.top();
    // Assert
    Assert.assertEquals(expected, result);
}
```

## Testing

```java
@Test
public void PoppingElementShouldRemoveMax() {
    // Arrange
    int expected = 4; // 2nd largest
    // Act
    heap.pop();
    int result = heap.top();
    // Assert
    Assert.assertEquals(expected, result);
}
```


## Complexity

* Pushing (inserting) an element into the heap:
    * First we put it at the bottom rightmost position in the tree -> O(1)
    * We bubble up the element to find its appropriate spot and maintain heap property -> O(log(n))
* Popping (removing max/min) element from the heap:
    * Remove top element and replace it with the bottom rightmost element in the tree -> O(1)
    * Bubble down the root element --> O(log(n))
* Get the max/min element:
    * O(1)



## When to use Heaps?

* Can act like a priority queue
* Need to get max/min elements & n is large.



## Sample Question


