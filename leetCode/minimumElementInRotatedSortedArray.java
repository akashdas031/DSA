package DSA.leetCode;

public class minimumElementInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;  // Initialize the answer to a very large value.
        
        while (low <= high) {
            int mid = low + (high - low) / 2;  // To avoid overflow.
            
            // If the subarray is already sorted (no rotation).
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);  // The minimum element is nums[low].
                break;  // We can break early since we found the minimum.
            }
            
            // If the left part is sorted.
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);  // The minimum element could be in the left part.
                low = mid + 1;  // Move to the right side of the array.
            } else {
                // If the right part is sorted.
                ans = Math.min(ans, nums[mid]);  // The minimum element could be in the right part.
                high = mid - 1;  // Move to the left side of the array.
            }
        }
        
        return ans;  // Return the minimum element found.
    }
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }    
}
