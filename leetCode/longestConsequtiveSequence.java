package DSA.leetCode;

import java.util.Arrays;

public class longestConsequtiveSequence {
    public static int getLongestConsequtiveSequence(int[] nums){
        if(nums.length==0 || nums==null) return 0;

        Arrays.sort(nums);
        int prev=nums[0]-2;
        int currentStreak=0;
        int longest=0;
        for(int num:nums){
            if(num==prev) continue;
            if(num-prev ==1) {
                currentStreak+=1;
            }else{
                longest=Math.max(longest,currentStreak);
                currentStreak=1;
            }
            prev=num;
        }
        longest=Math.max(longest,currentStreak);
        return longest;
    }
    public static void main(String[] args) {
        int[] nums={0,3,7,2,5,8,4,6,0,1};
        System.out.println(getLongestConsequtiveSequence(nums));
    }
}
