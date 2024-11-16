package DSA.leetCode;

import java.util.Arrays;

public class powerOfKSizeArray {
    public static int[] resultsArray(int[] nums, int k) {
        // int start=0;
         int[] res=new int[nums.length-k+1];
         for(int i=0;i<nums.length-k+1;i++){
             int end=i+k;
             if(isConsequtive(nums,i,end)){
                res[i]=getMax(nums,i,end);
             }else{
                 res[i]=-1;
             }
         }
         return res;
     }
     public static boolean isConsequtive(int[] nums,int start,int end){
         for(int i=start+1;i<end;i++){
            if(nums[i]>nums[i-1] && nums[i]-nums[i-1]==1){
             continue;
            }else{
             return false;
            }
         }
         return true;
     }
     public static int getMax(int[] nums,int start,int end){
         int max=Integer.MIN_VALUE;
         for(int i=start;i<end;i++){
             max=Math.max(max,nums[i]);
         }
         return max;
     } 
    public static void main(String[] args) {
        int[] nums={1,3,4};
        int [] res=resultsArray(nums,2);
        System.out.println(Arrays.toString(res));
       
    }
}
