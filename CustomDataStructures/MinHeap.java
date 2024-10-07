package DSA.CustomDataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MinHeap} class implements a min-heap data structure.
 * A min-heap is a complete binary tree where each node is less than or equal to its children.
 * This class provides methods for inserting elements, removing the minimum element, 
 * heap sorting, and displaying the heap.
 *
 * @param <T> the type of elements in the heap, which must be comparable
 */
public class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> data;

    /**
     * Constructs an empty min-heap.
     */
    public MinHeap() {
        data = new ArrayList<>();
    }

    /**
     * Swaps two elements in the heap at the specified indices.
     *
     * @param first  the index of the first element
     * @param second the index of the second element
     */
    private void swap(int first, int second) {
        T temp = data.get(first);
        data.set(first, data.get(second));
        data.set(second, temp);
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
     * Inserts a new value into the min-heap.
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
        if (index == 0) {
            return;
        }
        int parent = parent(index);
        if (data.get(index).compareTo(data.get(parent)) < 0) {
            swap(index, parent);
            upHeap(parent);
        }
    }

    /**
     * Removes and returns the minimum element from the min-heap.
     *
     * @return the minimum element
     * @throws Exception if the heap is empty
     */
    public T remove() throws Exception {
        if (data.isEmpty()) {
            throw new Exception("Already empty");
        }
        T removed = data.get(0);
        T last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            downHeap(0);
        }
        return removed;
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
        if (left < data.size() && data.get(curr).compareTo(data.get(left)) > 0) {
            curr = left;
        }
        if (right < data.size() && data.get(curr).compareTo(data.get(right)) > 0) {
            curr = right;
        }
        if (curr != index) {
            swap(curr, index);
            downHeap(curr);
        }
    }

    /**
     * Checks if the min-heap is empty.
     *
     * @return {@code true} if the heap is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Returns the number of elements in the min-heap.
     *
     * @return the size of the heap
     */
    public int size() {
        return data.size();
    }

    /**
     * Performs heap sort on the elements in the min-heap and returns them in ascending order.
     *
     * @return a list containing the elements sorted in ascending order
     * @throws Exception if an error occurs during removal from the heap
     */
    public List<T> heapSort() throws Exception {
        List<T> sorted = new ArrayList<>();
        while (!data.isEmpty()) {
            sorted.add(this.remove());
        }
        return sorted;
    }

    /**
     * Displays the elements in the min-heap.
     */
    public void display() {
        if (data.isEmpty()) {
            System.out.println("Heap is empty");
            return;
        }
        System.out.println(data.toString());
    }
}
