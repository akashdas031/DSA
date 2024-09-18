package DSA.CustomDataStructures;
/*
 * We can use Max heap where the priority will be max and min heap for the priority as minimum element
 */
public class PriorityQueue<T extends Comparable<T>> {
    MaxHeap<T> mh;
    public PriorityQueue(){
        mh=new MaxHeap<>();
    }
    //insert into the priority Queue having max priority
    public void insert(T value){
        mh.insert(value);
    }
    //remove
    public T remove() throws Exception{
        return mh.remove();
    }
    //get peek element
    public T peek(){
        return mh.peek();
    }

}
