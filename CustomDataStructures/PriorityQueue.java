package DSA.CustomDataStructures;

/**
 * The {@code PriorityQueue} class implements a priority queue using a max-heap.
 * In this implementation, elements with higher values have higher priority.
 * This class provides methods for inserting elements, removing the maximum priority element, 
 * and peeking at the maximum priority element.
 *
 * @param <T> the type of elements in the priority queue, which must be comparable
 */
public class PriorityQueue<T extends Comparable<T>> {
    private MaxHeap<T> mh;

    /**
     * Constructs an empty priority queue.
     */
    public PriorityQueue() {
        mh = new MaxHeap<>();
    }

    /**
     * Inserts a new value into the priority queue.
     *
     * @param value the value to be inserted
     */
    public void insert(T value) {
        mh.insert(value);
    }

    /**
     * Removes and returns the element with the highest priority from the priority queue.
     *
     * @return the element with the highest priority
     * @throws Exception if the priority queue is empty
     */
    public T remove() throws Exception {
        return mh.remove();
    }

    /**
     * Returns the element with the highest priority without removing it from the priority queue.
     *
     * @return the element with the highest priority, or {@code null} if the priority queue is empty
     */
    public T peek() {
        return mh.peek();
    }
}
