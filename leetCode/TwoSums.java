package DSA.leetCode;
import java.util.*;
public class TwoSums {
    //But here is a problem in this method that it can use same number to form the target which is not a proper solution
    //in case if we use the same number then this method will work fine
    public static int[] getSum(int []nums,int target){
        //create a map and store the compliments of each element of the array and the index at which compliment is available
        Map<Integer,Integer> mp=new HashMap<>();
        //traverse the array and put the compliment (target-current number) in the map
        for(int i=0;i<nums.length;i++){
            mp.put(target-nums[i],i);
        }

        System.out.println(mp);
        //traverse the array and check whether the number is present in the map or not if present 
        //then return the index at which compliment is created and the current index else return empty array
        for(int j=0;j<nums.length;j++){
         if(mp.containsKey(nums[j])){
            return new int[] {mp.get(nums[j]),j};
         }
        }
        return new int[] {-1,-1};
    }
    public static int[] getSumWithoutSameNumber(int []nums,int target){
        //create a map and store the compliments of each element of the array and the index at which compliment is available
        Map<Integer,Integer> mp=new HashMap<>();
        //check whether the compliment of the number which is target-currentNumber is present in the map or not
        //if not then put the current number and it's index in the map 
        //if present return the index of the compliment number and the current number
       
        for(int j=0;j<nums.length;j++){
            int compliment=target-nums[j];
         if(mp.containsKey(compliment)){
            return new int[] {mp.get(compliment),j};
         }
         mp.put(nums[j], j);
        }
        //else return empty array or put -1 in the array that the numbers which form the target is not present inside the array
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[] nums={3,2,4};
        int target=6;
        System.out.println(getSum(nums, target));
    }
}
