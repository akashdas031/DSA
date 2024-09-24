package DSA.Sorting;

import java.util.Arrays;

/**
 * radixSort
 */
public class radixSort {

    public static void sort(int[] nums){
        int max=Arrays.stream(nums).max().getAsInt();
        
        for(int i=1;max/i>0;i*=10){
            countSort(nums,i);
        }
        System.out.println("Final sorted Array : "+Arrays.toString(nums));
    }
    private static void countSort(int[] nums,int expr){
       int n=nums.length;
       int[] output=new int[n];
       int[] freq=new int[10];
       //fill with zeros
       Arrays.fill(freq,0);
       for(int i=0;i<n;i++){
        freq[(nums[i]/expr)%10]++;
       }

       //calculating the index of output array
       for(int i=1;i<10;i++){
        freq[i]=freq[i]+freq[i-1];
       }
      
       //Calculating the index in the output array for the current digit of the number of the nums
       //it will place the original number in the position according to it's current digit's position
       for(int i=n-1;i>=0;i--){
        output[freq[(nums[i]/expr)%10]-1] =nums[i];
        freq[(nums[i]/expr)%10]--;
       }
      
       //replace the original array with the output array which is sorted according to the current digit 
       System.arraycopy(output, 0, nums, 0, n);
        }
    public static void main(String[] args) {
        int []nums={83,72,348,291,3,95,876};
        sort(nums);
    }
}