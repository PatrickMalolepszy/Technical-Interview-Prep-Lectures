import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap <T extends Comparable<T>> {

    private List<T> data;

    // Constructor:
    public Heap() {
        this.data = new ArrayList<>();
    }

    // Accessor Methods:
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

    public int size() {
        return data.size();
    }

    // Heap Methods -> used to keep satisfy heap property
    private void bubbleUp(int i) {
        int parent = i / 2;
        while (i > 0 && (data.get(i).compareTo(data.get(parent)) > 0 )) {
            Collections.swap(data, i, parent);
            i = parent;
            parent = i / 2;
        }
    }

    private void bubbleDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int next = i;

        if ((left < data.size()) && (data.get(left).compareTo(data.get(i)) > 0)) {
            next = left;
        }
        if ((right < data.size()) && (data.get(right).compareTo(data.get(next)) > 0)) {
            next = right;
        }

        if (next != i) {
            Collections.swap(data, i, next);
            bubbleDown(next);
        }
    }
}

