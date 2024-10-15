package DSA.leetCode;

import java.util.Arrays;

/**
 * separateBlackAndWhiteBalls
 * https://leetcode.com/problems/separate-black-and-white-balls/submissions/1422690116/?envType=daily-question&envId=2024-10-15
 */
public class separateBlackAndWhiteBalls {

    
    public static long minimumSteps(String s) {
        int n = s.length();
        long swaps = 0;
        int leftPtr = 0;
        long blackCount = 0;

        // Traverse the string using two pointers
        while (leftPtr < n) {
            if (s.charAt(leftPtr) == '1') {
                // Count how many black balls ('1') there are before a white one ('0')
                blackCount++;
            } else {
                // For each white ball, add the blackCount to swaps as those need to be moved
                swaps += blackCount;
            }
            //move the pointer to next
            leftPtr++;
        }
        return swaps;
    }
    public static void main(String[] args) {
       String s="1010010";
    //    System.out.println(minimumSteps(s)); 
    int[] nums=new int[101];
    for(int i=0;i<nums.length;i++){
        nums[i]=1;
    }
    System.out.println(Arrays.toString(nums));
    }
}