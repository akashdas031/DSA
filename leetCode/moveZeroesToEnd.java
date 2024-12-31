package DSA.leetCode;

import java.util.Arrays;

public class moveZeroesToEnd {
    public static void moveZeros(int[] nums){
        int nonZero=0;
        for(int zero=0;zero<nums.length;zero++){
            if(nums[zero] != 0){
                int temp=nums[zero];
                nums[zero]=nums[nonZero];
                nums[nonZero]=temp;
                nonZero++;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={1,0,0,0,3,4,5,6,0,7,0,8};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}
