package DSA.leetCode;


import java.util.*;
/**
 * maximalScoreAfterKOperations
 * https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/?envType=daily-question&envId=2024-10-14
 */
public class maximalScoreAfterKOperations {

    //using sorted list not efficient because of sorting overhead timecomplexity : O(n log n)+O(k* n logn)
    public static long maxKelementsList(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        Collections.sort(list, Collections.reverseOrder()); // Sort in descending order
        
        long ans = 0;
        
        for (int i = 0; i < k; i++) {
            // Get the maximum element
            int n = list.get(0);
            ans += n;
            // Replace the maximum element
            list.set(0, (n + 2) / 3);
            // Re-sort the list
            Collections.sort(list, Collections.reverseOrder());
        }
        
        return ans;
    }
    //using max heap priority queue
     public static long maxKelementsPQ(int[] nums, int k) {
        PriorityQueue<Long> maxHeap=new PriorityQueue<>((a,b)->Long.compare(b,a));
        //add elements to the max heap
        for(long num: nums){
            maxHeap.offer(num);
        }
        long score=0;
        int i=0;
        //then remove the maximim element from the max heap and ceil the number and calculate the score and again add the ceiling number to the max heap
        //score will be the sum of max elements each time removed from the max heap
        //after calculating score calculate the ceiling of the number/3 and then add it to the max heap
        //ceiling value of a number is the number which is the smallest value greater than the number
        while(i<k){
            long val=maxHeap.poll();
            score+=val;
            val=(long)Math.ceil(val/3.0);
            maxHeap.offer(val);
            i++;
        }
        return score;

        
    }
    public static void main(String[] args) {
       int[] nums = {1,10,3,3,3};
        int k = 3;
        System.out.println(maxKelementsPQ(nums,k));
    }
}