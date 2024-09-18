package DSA.Sorting;

import java.util.Arrays;

public class mergeSort {
    //merge sort
    public static int[] sort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = sort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sort(Arrays.copyOfRange(left, mid, nums.length));
        return merge(left, right);
    }

    //merge two arrays 
    public static int[] merge(int[] first, int[] sec) {
        int[] merged = new int[first.length + sec.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < sec.length) {
            if (first[i] < sec[j]) {
                merged[k] = first[i];
                i++;

            } else {
                merged[k] = sec[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            merged[k] = first[i];
            i++;
            k++;
        }
        while (j < sec.length) {
            merged[k] = sec[i];
            j++;
            k++;
        }
        return merged;

    }
    //as it is modifying the original array it is not returning anything
    public static void mergeSortInplace(int[] nums,int start,int end){
        if(end-start==1){
            return; 
        }
        int mid=(start+end)/2;
        mergeSortInplace(nums, start, mid);
        mergeSortInplace(nums, mid, end);
        mergeInplace(nums,start,mid,end);

    }
    //in this case it is not mixing two arrays ,Just treating the two indices like start and mid as two arrays and mix it in a new array
    //At te end placing the value with the original array
    public static void mergeInplace(int[] nums,int start,int mid,int end){
        int i=start;
        int j=mid;
        int k=0;
        int[] merge=new int[end-start];
        while(i<mid && j<end){
            if(nums[i]<nums[j]){
              merge[k]=nums[i];
              i++;
            }else{
                merge[k]=nums[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            merge[k]=nums[i];
            i++;
            k++;
        }
        while(j<end){
            merge[k]=nums[j];
            j++;
            k++;
        }
        //It will place the value of merged item after adding with start because suppose mix contains 4 and 5
        //what it will do is place the 3rd inded at 3rd index and next index to 3+1 index
        for(int l=0;l<merge.length;l++){
            nums[start+l]=merge[l];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 5,4,3,2,1 };
        mergeSortInplace(nums,0,nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
