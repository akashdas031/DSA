package DSA.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetWithoutDuplicates {
     public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,result,new ArrayList<>());
        return result;
    }
    public static void helper(int[] nums,int index,List<List<Integer>> result,List<Integer> curr){
        
            result.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            
            curr.add(nums[i]);
            helper(nums,i+1,result,curr);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,2};
        List<List<Integer>> result=subsetsWithDup(nums);
        System.out.println(result);
    }
}
