package DSA.GFG;

public class maximumCircularSubarraySum {

    public static int getMaxCircularSubSum(int[] nums){

        int n=nums.length;
        int totalSum=0;
        int currSum=0;
        int maxSum=nums[0];

        int minSum=nums[0];
        int currMinSum=0;

        for(int i=0;i<n;i++){
            currSum=Math.max(currSum+nums[i],nums[i]);
            maxSum=Math.max(maxSum,currSum);

            currMinSum=Math.min(currMinSum+nums[i],nums[i]);
            minSum=Math.min(minSum,currMinSum);

            totalSum+=nums[i];
        }

        int normalSubarraySum=maxSum;
        int circularSubarraySum=totalSum-minSum;

        if(totalSum==minSum){
            return normalSubarraySum;
        }
        return Math.max(normalSubarraySum,circularSubarraySum);
    }
    public static void main(String[] args) {
        int[] nums={10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println(getMaxCircularSubSum(nums));
    }
    
}