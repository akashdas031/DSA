package DSA.leetCode;
import java.util.*;
/**
 * DivideMinimumIntervals
 */
public class DivideMinimumIntervals {
    //not working for bigger numbers in the array need to fix and debug
    public static int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        boolean [] mark=new  boolean[intervals.length];
        
        List<Stack<Integer>> res=new ArrayList<>();
        for(int i=0;i<intervals.length && !mark[i];i++){
           Stack<Integer> stack=new Stack<>();
           stack.push(intervals[i][0]);
           stack.push(intervals[i][1]);
           mark[i]=true;
           for(int j=i;j<intervals.length;j++){
            if(intervals[j][0] >stack.peek() && !mark[j]){
                stack.push(intervals[j][0]);
                stack.push(intervals[j][1]); 
                mark[j]=true;
            }
           }
           res.add(stack);
        }
        return res.size();
    }
    //This is working for big numbers 
    public static int minGroupsWorking(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Step 3: Check if the current interval can fit in an existing group
            if (!minHeap.isEmpty() && minHeap.peek() < start) {
                // If the earliest ending group can accommodate this interval
                minHeap.poll();  // Remove the group as it can now be updated
            }

            // Add the current interval's end time to the heap (new or updated group)
            minHeap.offer(end);
        }

        // The size of the heap is the number of groups needed
        return minHeap.size();
    }
    public static void main(String[] args) {
        int[][] intervals={
            {441459,446342},
            {801308,840640},
            {871890,963447},
            {228525,336985},
            {807945,946787},
            {479815,507766},
            {693292,944029},
            {751962,821744}
        };
        System.out.println(minGroupsWorking(intervals));
    }

}