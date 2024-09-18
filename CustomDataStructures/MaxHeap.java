package CustomDataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * MaxHeap
 */
public class MaxHeap<T extends Comparable<T>> {

    // to store data of heap
    private ArrayList<T> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    // Create parent node and left and right node
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // left node
    private int left(int index) {
        return index * 2 + 1;
    }

    // right node
    private int right(int index) {
        return index * 2 + 2;
    }

    // swap
    public void swap(int first, int second) {
        T temp = data.get(first);
        data.set(first, data.get(second));
        data.set(second, temp);
    }

    // insert
    public void insert(T value) {
        data.add(value);
        upHeap(data.size() - 1);
    }

    private void upHeap(int index) {
        int parent = parent(index);

        if (data.get(index).compareTo(data.get(parent)) > 0) {
            swap(index, parent);
            upHeap(parent);
        }

    }

    // remove
    public T remove() throws Exception {
        if (data.isEmpty()) {
            throw new Exception("Can not remove from Empty heap...");
        }
        T temp = data.get(0);
        T last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            downHeap(0);
        }
        return temp;
    }

    private void downHeap(int index) {
        int curr = index;
        int left = left(index);
        int right = right(index);
        if (left < data.size() && data.get(curr).compareTo(data.get(left)) < 0) {
            curr = left;
        }
        if (right < data.size() && data.get(curr).compareTo(data.get(right)) < 0) {
            curr = right;
        }
        if (curr != index) {
            swap(curr, index);
            downHeap(curr);
        }
    }

    // Heap sort descending order
    public List<T> heapSort() throws Exception {
        List<T> res = new ArrayList<>();
        while (!data.isEmpty()) {
            res.add(this.remove());
        }
        return res;
    }
    //get peek element
    public T peek(){
        return data.get(0);
    }

}