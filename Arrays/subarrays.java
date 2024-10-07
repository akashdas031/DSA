package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code subarrays} class provides methods to generate subarrays from a given array of integers.
 */
public class subarrays {
    /**
     * Generates all possible subarrays of the given array of integers.
     * A subarray is defined as a contiguous portion of the array.
     *
     * @param nums an array of integers for which subarrays are to be generated
     * @return a list of lists containing all subarrays of the input array
     */
    public static List<List<Integer>> getSubarray(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        // Generate subarrays
        for (int i = 0; i < nums.length; i++) {
            List<Integer> helper = new ArrayList<>();
            for (int j = 0; j <= i; j++) { // Changed j < i to j <= i to include the current element
                helper.add(nums[j]);
            }
            res.add(helper);
        }
        
        return res;
    }

    /**
     * The main method to demonstrate the functionality of the {@code getSubarray} method.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4}; // Sample input array
        System.out.println(getSubarray(nums)); // Print the generated subarrays
    }
}
