package Sorting;


import java.util.Arrays;

public class selectionSort {
    public static void sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int min=i;
           for(int j=0;j<nums.length;j++){
            if(nums[min]<nums[j]){
                int temp=nums[min];
                nums[min]=nums[j];
                nums[j]=temp;
            }
           }
        }
    }
    public static void main(String[] args) {
        int[] nums={5,4,3,2,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
