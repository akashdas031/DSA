package DSA.CustomDataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MaxHeap} class implements a max-heap data structure.
 * A max-heap is a complete binary tree where each node is greater than or equal to its children.
 * This class provides methods for inserting elements, removing the maximum element, 
 * heap sorting, and peeking at the maximum element.
 *
 * @param <T> the type of elements in the heap, which must be comparable
 */
public class MaxHeap<T extends Comparable<T>> {

    // to store data of heap
    private ArrayList<T> data;

    /**
     * Constructs an empty max-heap.
     */
    public MaxHeap() {
        data = new ArrayList<>();
    }

    /**
     * Calculates the index of the parent node of the given index.
     *
     * @param index the index of the child node
     * @return the index of the parent node
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Calculates the index of the left child node of the given index.
     *
     * @param index the index of the parent node
     * @return the index of the left child node
     */
    private int left(int index) {
        return index * 2 + 1;
    }

    /**
     * Calculates the index of the right child node of the given index.
     *
     * @param index the index of the parent node
     * @return the index of the right child node
     */
    private int right(int index) {
        return index * 2 + 2;
    }

    /**
     * Swaps two elements in the heap at the specified indices.
     *
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public void swap(int first, int second) {
        T temp = data.get(first);
        data.set(first, data.get(second));
        data.set(second, temp);
    }

    /**
     * Inserts a new value into the max-heap.
     *
     * @param value the value to be inserted
     */
    public void insert(T value) {
        data.add(value);
        upHeap(data.size() - 1);
    }

    /**
     * Restores the heap property by moving the element at the given index up the heap.
     *
     * @param index the index of the element to move up
     */
    private void upHeap(int index) {
        int parent = parent(index);

        if (index > 0 && data.get(index).compareTo(data.get(parent)) > 0) {
            swap(index, parent);
            upHeap(parent);
        }
    }

    /**
     * Removes and returns the maximum element from the max-heap.
     *
     * @return the maximum element
     * @throws Exception if the heap is empty
     */
    public T remove() throws Exception {
        if (data.isEmpty()) {
            throw new Exception("Cannot remove from an empty heap...");
        }
        T temp = data.get(0);
        T last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            downHeap(0);
        }
        return temp;
    }

    /**
     * Restores the heap property by moving the element at the given index down the heap.
     *
     * @param index the index of the element to move down
     */
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

    /**
     * Performs heap sort on the elements in the max-heap and returns them in descending order.
     *
     * @return a list containing the elements sorted in descending order
     * @throws Exception if an error occurs during removal from the heap
     */
    public List<T> heapSort() throws Exception {
        List<T> res = new ArrayList<>();
        while (!data.isEmpty()) {
            res.add(this.remove());
        }
        return res;
    }

    /**
     * Returns the maximum element in the max-heap without removing it.
     *
     * @return the maximum element
     */
    public T peek() {
        return data.isEmpty() ? null : data.get(0);
    }
}
