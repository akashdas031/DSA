package DSA.leetCode;

import java.util.HashMap;

/**
 * The {@code makeSumDivisibleByP} class provides a method to find the minimum length of a 
 * contiguous subarray whose removal makes the sum of the remaining elements divisible by a given integer.
 */
public class makeSumDivisibleByP {

    /**
     * Finds the minimum length of a subarray that needs to be removed so that the sum of the remaining
     * elements in the array is divisible by a given integer {@code p}.
     *
     * @param nums an array of integers
     * @param p    an integer to check divisibility against
     * @return the minimum length of the subarray to remove, or -1 if no such subarray exists
     */
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // If total sum is already divisible by p, return 0
        if (totalSum % p == 0) {
            return 0;
        }
        long targetRemainder = totalSum % p;
        HashMap<Long, Integer> prefixIndex = new HashMap<>();
        prefixIndex.put(0L, -1); // Initialize for prefix sums
        long prefixSum = 0;
        int minLength = Integer.MAX_VALUE;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            // Calculate the needed prefix to reach the target remainder
            long neededPrefix = (prefixSum % p - targetRemainder + p) % p;

            // Check if we can find the neededPrefix in prefixIndex
            if (prefixIndex.containsKey(neededPrefix)) {
                int length = i - prefixIndex.get(neededPrefix);
                minLength = Math.min(minLength, length);
            }

            // Store the current prefix sum modulo p and its index
            prefixIndex.put(prefixSum % p, i);
        }

        // Return the smallest length found, ensuring it's not equal to the full length of the array
        return minLength == Integer.MAX_VALUE || minLength == nums.length ? -1 : minLength;
    }
}
