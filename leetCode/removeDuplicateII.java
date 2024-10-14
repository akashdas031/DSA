package DSA.leetCode;
import java.util.*;
/*
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class removeDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
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
}
