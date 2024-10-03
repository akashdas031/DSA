package DSA.leetCode;
import java.util.HashMap;

public class makeSumDivisibleByP {
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
            //here we get how much close we are to reach remainingTotal and to avoid negative numbers we add p with the remaining total
            long neededPrefix = (prefixSum % p - targetRemainder + p) % p;
            // Check if we can find the neededPrefix in prefixIndex
            if (prefixIndex.containsKey(neededPrefix)) {
                int length = i - prefixIndex.get(neededPrefix);
                minLength = Math.min(minLength, length);
            }
//store the required sum to reach the remaining total and current index to the map for future reference
            prefixIndex.put(prefixSum % p, i);
        }
        // Check for the smallest length found, we also have to ensure it's not equal to the full length of the array
        return minLength == Integer.MAX_VALUE || minLength == nums.length ? -1 : minLength;
    }
}
