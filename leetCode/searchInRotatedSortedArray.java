package DSA.leetCode;

public class searchInRotatedSortedArray {

    public static int getPivot(int[] nums) {
        // Check if the array is empty
        if (nums.length == 0) {
            return -1; // No pivot in an empty array
        }
    
        // Check if the array has only one element
        if (nums.length == 1) {
            return 0; // The only element is the pivot
        }
    
        int start = 0;
        int end = nums.length - 1;
    
        // Handle the case where the array is not rotated
        if (nums[start] < nums[end]) {
            return end; // The last element is the largest (pivot)
        }
    
        while (start <= end) {
            int mid = start + (end - start) / 2;
    
            // Check if mid is the pivot (the largest element)
            if (mid > 0 && mid < nums.length - 1 && 
                nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid; // Mid is the pivot
            }
    
            // If the left side is sorted
            if (nums[mid] >= nums[start]) {
                start = mid + 1; // Move to the right
            } else {
                end = mid - 1; // Move to the left
            }
        }
    
        // If no pivot found (should not happen in a rotated sorted array)
        return -1; 
    }
    public static int binarySearch(int start,int end,int[] nums,int target){
       while(start<=end){
        int mid=start+(end-start)/2;
        if(nums[mid]>target){
         end=mid-1;
        }else if(nums[mid]<target){
            start=mid+1;
        }else{
            return mid;
        }
        
       }
       return -1;
    }
    public static int getIndex(int[] nums,int num){
        
        int pivot=getPivot(nums);
        System.out.println(pivot);
        int start=0;
        int end=nums.length-1;
          if(num>nums[end] && num<=nums[pivot]){
            return binarySearch(start,pivot,nums,num);
          }else if(num<=nums[end]){
            return binarySearch(pivot+1,end,nums,num);
          }else{
            return -1;
          }
       
    }
    public static void main(String[] args) {
        int[] nums={5,6,7,8,9,1,2,3,4};
        System.out.println(getIndex(nums, 4));
    }
}
