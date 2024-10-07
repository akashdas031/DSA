package DSA.leetCode;

/**
 * The {@code kthSmallestLexographicalNumber} class provides a method to find
 * the k-th smallest number in lexicographical order from 1 to n.
 */
public class kthSmallestLexographicalNumber {

    /**
     * Finds the k-th smallest number in lexicographical order from 1 to n.
     *
     * @param n the upper limit of the range (inclusive)
     * @param k the position of the number in the lexicographical order to find
     * @return the k-th smallest number in lexicographical order
     */
    public static int findKthNumber(int n, int k) {
        int current = 1; // Start from 1
        k--; // Decrement k because we are starting from the first number
        
        while (k > 0) {
            int count = getCount(n, current);
            if (count <= k) {
                // If there are not enough numbers with the current prefix, go to the next prefix
                current++;
                k -= count; // Decrease k by the count of numbers we skipped
            } else {
                // Move to the next level
                current *= 10; // Go deeper (like 1 -> 10)
                k--; // We consider the current number as part of our count
            }
        }
        
        return current; // Return the k-th smallest number
    }
    
    /**
     * Counts how many numbers in the range [1, n] start with the given prefix.
     *
     * @param n     the upper limit of the range (inclusive)
     * @param prefix the prefix to count numbers starting with
     * @return the count of numbers starting with the given prefix
     */
    private static int getCount(int n, int prefix) {
        long curr = prefix;
        long next = prefix + 1;
        int count = 0;
        
        while (curr <= n) {
            count += Math.min(n + 1, next) - curr; // Count the numbers in the range [curr, next)
            curr *= 10; // Move to the next level
            next *= 10; // Move the next prefix to the next level
        }
        
        return count;
    }
    
    /**
     * The main method to test the functionality of finding the k-th smallest number.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 4));
    }
}
