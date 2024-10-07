package DSA.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The {@code kthMissingNumber} class provides methods to find missing numbers
 * in an integer array, including those within a range that includes negative numbers.
 * It also contains a method to find the k-th missing number in a sorted array.
 */
public class kthMissingNumber {

    /**
     * Returns all the missing numbers in an array that can contain a range
     * from -n to n, where -n < 0 < n.
     *
     * @param nums the input array of integers
     * @return a list of missing integers in the range from -n to n
     */
    public static List<Integer> missingNumberNegativeInclude(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int posRange = nums[nums.length - 1];
        int negRange = nums[0];
        boolean[] positives = new boolean[2 * nums.length + 1];

        for (int num : nums) {
            if (num >= negRange && num <= posRange) {
                if (num > 0) {
                    positives[num + nums.length] = true;
                } else if (num < 0) {
                    positives[num + nums.length] = true;
                } else {
                    positives[num] = true;
                }
            }
        }
        for (int i = negRange; i <= posRange; i++) {
            if (!positives[i + posRange]) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * Returns all positive integers that are missing in the array.
     *
     * @param nums the input array of integers
     * @return a list of missing positive integers
     */
    public static List<Integer> missingNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums[nums.length - 1];
        boolean[] bool = new boolean[n + 1];

        for (int num : nums) {
            if (num <= n) {
                bool[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!bool[i]) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Finds the k-th missing positive integer in the sorted array.
     *
     * @param nums the input array of integers, sorted in ascending order
     * @param k    the k-th position of the missing number to find
     * @return the k-th missing positive integer
     */
    public static int getKthNumber(int[] nums, int k) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = nums[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }

    /**
     * The main method to test the functionality of the class methods.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 8};
        System.out.println(getKthNumber(nums, 3));
        System.out.println(missingNumbers(nums));
        int[] arr = {-4, -2, 1, 3, 5};
        System.out.println(missingNumberNegativeInclude(arr));
    }
}
