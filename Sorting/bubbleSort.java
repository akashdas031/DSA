package Sorting;

import java.util.Arrays;
public class bubbleSort {
    public static void sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
