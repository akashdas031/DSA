package DSA.leetCode;
import java.util.*;
/*
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class removeDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //create map to track of the element and the index 
        Map<Integer,Integer> mp=new HashMap<>();
        //iterate over the array and check if the number is present in the map 
        //that means the number is duplicate and check whether the absolute of the difference between the 
        //index is less than equal to k and if it is equal then return true otherwise add the number to the map
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                if(Math.abs(mp.get(nums[i])-i)<=k){
                    return true;
                }
            }
            mp.put(nums[i],i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(containsNearbyDuplicate(nums,1));
    }
}
