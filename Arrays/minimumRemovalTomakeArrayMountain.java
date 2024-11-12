package DSA.Arrays;

import java.util.Arrays;

public class minimumRemovalTomakeArrayMountain {
    public static int minimumMountainRemovals(int[] nums) {
        int peek=findPeek(nums);
        System.out.println(peek);
        boolean []incr=new boolean[peek];
        boolean []decr=new boolean[(nums.length-peek+1)];
        for(int i=0;i<peek;i++){
            if(nums[i]<nums[i+1]){
                incr[i]=true;   
            }
        }
        int ind=0;
        for(int i=peek+1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                decr[ind++]=true;  
            }
        }
        System.out.println(Arrays.toString(incr));
        System.out.println(Arrays.toString(decr));
        int count=0;
        for(int i=0;i<incr.length;i++){
            if(!incr[i]){
               count++;
            }
        }
        for(int i=0;i<decr.length;i++){
            if(!decr[i]){
               count++;
            }
        }
        return count-1;
    }
    private static int findPeek(int[] nums){
       int max=Integer.MIN_VALUE;
       for(int num:nums){
        max=Math.max(max,num);
       }
       return max;
    }
    public static void main(String[] args) {
        int []nums={2,1,1,5,6,2,3,1};
        System.out.println(minimumMountainRemovals(nums));
    }
}
