package DSA.Sorting;

import java.util.Arrays;

/**
 * quickSort
 */
public class quickSort {

    public static void main(String[] args) {
        int[] nums={3,4,2,1,5};
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums,int min,int max){
        if(min>=max){
         return;
        }
        //take two element start and end
        int start=min;
        int end=max;
        //suppose in this case out pivot is the mid element
        int mid=start+(end-start)/2;
        int pivot =nums[mid];
        //while start is less than the end menas untill it is in the range of the array then place the pivot in it's correct place
        while(start<=end){
            //left side part is smaller than the pivot so continue 
            while(nums[start]<pivot){
                start++;
            }
            //right side part is greater than the pivot then continue
            while(nums[end]>pivot){
                end--;
            }
            //after completion of the loops if the above conditions are violating means if start is greater than pivot and end is smaller than the pivot 
            //then swap it 
            if(start<=end){
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }

        }
        //after this step the pivot is at correct position 
        //then made recursion call for left part and right part of the pivot
        sort(nums,min,end);
        sort(nums,start,max);
        
    }
}