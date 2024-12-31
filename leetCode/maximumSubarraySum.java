package DSA.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class maximumSubarraySum {
    public static int maxSubarraySum(int[] nums){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            max=Math.max(sum,max);
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    public static int getLengthMaxSubarraySum(int[] nums){
        int currentSum=0;
        int currentIndex=0;
        int max=Integer.MIN_VALUE;
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            if(currentSum>max){
                max=currentSum;
                maxLength=i-currentIndex+1;
            }
            if(currentSum<0){
                currentSum=0;
                currentIndex=i+1;
            }
        }
        return maxLength;
    }
    public static int[] subarrayWithMaxSum(int[] nums){
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;
        int currentIndex=0;
        int maxLength=0;
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            currentSum+=nums[i];
            if(currentSum>maxSum){
                maxSum=currentSum;
                start=currentIndex;
                end=i;
            }
            if(currentSum<0){
                currentSum=0;
                currentIndex=i+1;
            }
        }
        int[] maxSumSubarray=new int[end-start+1];
        for(int i=start;i<=end;i++){
            maxSumSubarray[i-start]=nums[i];
        }
        return maxSumSubarray;
    }
    public static int countSubarraysWithGivenSum(int[] nums,int targetSum){
        Map<Integer,Integer> prefixSumMap=new HashMap<>();
        int currentSum=0;
        int count=0;
        prefixSumMap.put(0,1);
        for(int num:nums){
           currentSum+=num;
           if(prefixSumMap.containsKey(currentSum-targetSum)){
              count+=prefixSumMap.get(currentSum-targetSum);
           }
           prefixSumMap.put(currentSum,prefixSumMap.getOrDefault(currentSum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubarraySum(nums));
        System.out.println(getLengthMaxSubarraySum(nums));
        int []subarrayWithMaxSum=subarrayWithMaxSum(nums);
        System.out.println(Arrays.toString(subarrayWithMaxSum));
        int []values={1, 2, 3, -2, 5, -1, 2, 3, -1, 4};
        System.out.println(countSubarraysWithGivenSum(values,5));
    }
}
