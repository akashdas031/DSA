package DSA.Sorting;
import java.util.Arrays;
//It sorts the elements from 1-n or 0 to n-1
public class cyclicSort {
    public static void sort(int[] nums){
       for(int i=0;i<nums.length;i++){
        int ind=nums[i]-1;
        if(nums[i] !=nums[ind]){
            int temp=nums[ind];
            nums[ind]=nums[i];
            nums[i]=temp;
        }
       }
    }
    public static void main(String[] args) {
        int []nums={5,4,3,2,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
