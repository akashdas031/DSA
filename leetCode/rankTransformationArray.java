package DSA.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import DSA.CustomDataStructures.PriorityQueue;
/**
 * rankTransformationArray
 */
public class rankTransformationArray {

    public int[] arrayRankTransformWithoutPQ(int[] arr) {
        Set<Integer> nums=new HashSet<>();
        for(int n:arr){
            nums.add(n);
        }
        int[] ranks=new int[nums.size()];
        int ind=0;
        for(int val:nums){
         ranks[ind++]=val;
        }
        Arrays.sort(ranks);
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<ranks.length;i++){
          m.put(ranks[i],i+1);
        }
        int []res=new int[arr.length];
        int index=0;
        for(int v:arr){
          res[index++]=m.get(v);
        }
        return res;
    }
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num:arr){
          minHeap.offer(num);
        }
        int[] res=new int[arr.length];
        Map<Integer,Integer> mp=new HashMap<>();
        int rank=1;
        while(!minHeap.isEmpty()){
            int min=minHeap.poll();
            if(!mp.containsKey(min)){
                mp.put(min,rank);
                rank++;
            }
           
        }
        int index=0;
        for(int n:arr){
            if(mp.containsKey(n) && index<arr.length){
                res[index]=mp.get(n);
                index++;
            }
        }
        return res;
    }

}