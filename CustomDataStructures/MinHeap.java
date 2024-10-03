package DSA.CustomDataStructures;
import java.util.*;
public class MinHeap <T extends Comparable<T>> {
    private ArrayList<T> data;
    public MinHeap(){
       data=new ArrayList<>();
    }
    //Swap two indices
    private void swap(int first,int second){
        T temp=data.get(first);
        data.set(first,data.get(second));
        data.set(second,temp);
    }
    //to get the parent index
    private int parent(int index){
        return (index-1)/2;
    }
    //to get the left index
    private int left(int index){
        return index*2+1;
    }
    //to get the right index
    private int right(int index){
        return index*2+2;
    }
    //insert value to the heap 
    public void insert(T value){
        data.add(value);
        upHeap(data.size()-1);
    }
    private void upHeap(int index){
        if(index==0){
            return;
        }
        int parent=parent(index);
        if(data.get(index).compareTo(data.get(parent))<0){
            swap(index,parent);
            upHeap(parent);
        }
    }
    //remove element from the heap
    //Remove from heap works as first it will remove the root element and then add the last element of the heap to the root and 
    //then place it in it's correct place .Here DownHeap method will compare the left and right elements to it and place it in it's correct position
    public T remove() throws Exception{
        if(data.isEmpty()){
            throw new Exception("Already Empty");
        }
        T removed=data.get(0);
        T last=data.remove(data.size()-1);
        if(!data.isEmpty()){
            data.set(0,last);
            downHeap(0);
        }
        return removed;
    }
    //down heap method
    private void downHeap(int index){
        int curr=index;
        int left=left(index);
        int right=right(index);
        if(left<data.size() && data.get(curr).compareTo(data.get(left))>0){
            curr=left;
        }
        if(right<data.size() && data.get(curr).compareTo(data.get(right))>0){
            curr=right;
        }
        if(curr!=index){
            swap(curr,index);
            downHeap(curr);
        }

    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public int size(){
        return data.size();
    }
    //heap sort ascending order
    public List<T> heapSort() throws Exception{
        List<T> sorted=new ArrayList<>();
        while(!data.isEmpty()){
            sorted.add(this.remove());
        }
        return sorted;
    }


}
