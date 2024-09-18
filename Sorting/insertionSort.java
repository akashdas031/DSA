package DSA.Sorting;

import java.util.Arrays;

public class insertionSort {
    public static void sort(int[] nums){
        //start i from 1st index
          for(int i=1;i<nums.length;i++){
            //make j as the previousindex of i
            int j=i-1;  
            //select the value of i and store it in a variable k and then compare the value of k with the left side elements
            //place the value of key in it's appropriate place
            int key=nums[i];
            while(j>=0 && nums[j]>key){
                nums[j+1]=nums[j];
                j=j-1;
            }
            //place the value of key in it's appropriate place
            nums[j+1]=key;
        }
    }
    public static void main(String[] args) {
        int[] nums={5,4,3,2,2};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
