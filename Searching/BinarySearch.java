package DSA.Searching;

/**
 * A class that provides a binary search algorithm for searching a target element in a sorted array.
 */
public class BinarySearch {
    /**
     * Searches for a target element in a sorted array using binary search.
     * 
     * @param nums  the sorted array to search
     * @param target  the element to search for
     * @return  the index of the target element if found, -1 otherwise
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
    
    /**
     * Example usage of the binary search algorithm.
     * 
     * @param args  command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(search(nums, 7));
    }
}