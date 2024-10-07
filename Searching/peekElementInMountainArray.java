package DSA.Searching;

/**
 * The {@code peekElementInMountainArray} class provides a method to find
 * the index of the peak element in a mountain array. A mountain array is
 * defined as an array where elements first increase to a peak and then 
 * decrease.
 */
public class peekElementInMountainArray {

   /**
 * Finds the index of a peak element in a mountain array using recursion.
 *
 * A peak element is defined as an element that is greater than its neighbors.
 * This method uses a divide-and-conquer approach to efficiently locate a peak
 * by recursively narrowing the search space based on the relationship between
 * the middle element and its right neighbor.
 *
 * @param nums an array of integers representing a mountain array, where there is
 *             guaranteed to be at least one peak.
 * @param start the starting index of the current search range.
 * @param end the ending index of the current search range.
 * @return the index of a peak element in the array.
 * 
 * The method operates as follows:
 * 1. If the `start` index equals the `end` index, it means a peak has been found
 *    at that index, and the method returns `start`.
 * 2. Calculate the midpoint index of the current search range.
 * 3. Compare the midpoint element with its right neighbor:
 *    - If the midpoint element is greater than its right neighbor, the peak must
 *      be in the left half of the array (including the midpoint). The method
 *      recursively calls itself with the left half.
 *    - If the midpoint element is less than or equal to its right neighbor, the
 *      peak must be in the right half of the array. The method recursively calls
 *      itself with the right half, starting just after the midpoint.
 */
public static int getPeekRecursion(int[] nums, int start, int end) {
    if (start == end) {
        return start;
    }
    int mid = start + (end - start) / 2;
    if (nums[mid] > nums[mid + 1]) {
        return getPeekRecursion(nums, start, mid);
    } else {
        return getPeekRecursion(nums, mid + 1, end);
    }
}
    /**
     * Finds the index of the peak element in a mountain array.
     * The peak element is the highest element that is greater than
     * its neighbors.
     *
     * @param nums an array of integers representing a mountain array
     * @return the index of the peak element
     */
    public static int getPeekelement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Check if mid is greater than its next element
            if (nums[mid] > nums[mid + 1]) {
                //peek is in the left side because current mid is in the descending part of the array
                //but we can not assure the element before the current mid is not peek so we will move the end to mid
                end = mid; // Move left
            } else {
                //peek is in the right side becuase before the mid all elements are in left side are smaller
                //and all are in same order
                start = mid + 1; // Move right
            }
        }
        return start; // Peak element index
    }

    /**
     * Main method to test the {@code getPeekelement} method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 8, 10, 12, 6, 4, 2};
        System.out.println(getPeekRecursion(nums,0,nums.length)); // Output: index of the peak element
    }
}
