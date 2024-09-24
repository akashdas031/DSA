package DSA.Sorting;

import java.util.Arrays;

/**
 * radixSort
 */
public class radixSort {
    public static void sort(int[] nums){
        int max=Arrays.stream(nums).max().getAsInt();
        /*
         * This loop iterates over each digit position, starting from the least
         * significant digit (i.e., i = 1 corresponds to the units place). The loop
         * continues until the maximum number in the array is fully processed. In each
         * iteration, the countSort method is called to sort the array based on the
         * current digit position.
         */
        for(int i=1;max/i>0;i*=10){
            countSort(nums,i);
        }
        System.out.println("Final sorted Array : "+Arrays.toString(nums));
    }
    /*
     * This method performs a counting sort on the array based on the given digit
     * position. It uses an array of frequencies to count the occurrences of each
     * digit at the given position, and then uses these frequencies to determine the
     * final position of each number in the sorted array.
     */
    private static void countSort(int[] nums,int expr){
       int n=nums.length;
       //output array to store the numbers after sorted according to each digit's base
       int[] output=new int[n];
       //create frequency array to store the frequency of each digit of the numbers of the nums array
       int[] freq=new int[10];
       //fill with zeros 
       Arrays.fill(freq,0);
       //calculate frequency and store it in the freq array
       for(int i=0;i<n;i++){
        freq[(nums[i]/expr)%10]++;
       }
      
       // This loop calculates the cumulative frequencies of each digit at the given
       // position. This is necessary to determine the final position of each number in
       // the sorted array.
       for(int i=1;i<10;i++){
        freq[i]=freq[i]+freq[i-1];
       }
      
       /*
        * This loop places each number in the output array based on its digit at the
        * given position. The index of the output array is determined using the
        * cumulative frequencies calculated earlier.
        */
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
