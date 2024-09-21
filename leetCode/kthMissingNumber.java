package DSA.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kthMissingNumber {
    
    //returns all the numbers that are missing in an array of range -n to n where -n<0<n
   public static List<Integer> missingNumberNegativeInclude(int[] nums){
      List<Integer> res=new ArrayList<>();
      Arrays.sort(nums);
      int posRange=nums[nums.length-1];
      //similar as positive missing number but create a negative boolean [] to keep track of negative indices
      int negRange=nums[0];
      boolean[] positives=new boolean[2*nums.length+1];
      
      for(int num:nums){
        if(num>=negRange && num<=posRange){
            if(num>0){
                positives[num+nums.length]=true;
            }else if(num<0){
                positives[num+nums.length]=true;
            }else{
                positives[num]=true;
            }
        }
      }
      for(int i=negRange;i<=posRange;i++){
        if(!positives[i+posRange]){
            res.add(i);
        }
      }
      return res;
   }

    //return all positive numbers that are missing in the array
    public static List<Integer> missingNumbers(int[] nums){
        List<Integer> list=new ArrayList<>();
        //n will be the max element which is present at the last index of the array because the array contains range from 1 to n
        int n=nums[nums.length-1];
        //create a boolean array and mark the elements as true which are present in the array 
        //then return the numbers which are false in the boolean array in a list
        boolean[] bool=new boolean[n+1];
        
        for(int num:nums){
            if(num<= n){
                bool[num]=true;
            }
        }
        for(int i=1;i<=n;i++){
            if(!bool[i]){
                list.add(i);
            }
        }
        return list;

    }

    //kth missing number
    public static int getKthNumber(int[] nums,int k){
      
       int len=nums.length;
       int low=0;
       int high=len-1;
       while(low<=high){
        int mid=low+(high-low)/2;
        int missing=nums[mid]-(mid+1);
         if(missing<k){
            low=mid+1;
        }else{
            high=mid-1;
        }
       }
       return low+k;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,5,6,8};
        System.out.println(getKthNumber(nums,3));
        System.out.println(missingNumbers(nums));
        int [] arr={-4,-2,1,3,5};
        System.out.println(missingNumberNegativeInclude(arr));
    }
}
