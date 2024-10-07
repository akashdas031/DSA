package DSA.leetCode;

import java.util.*;

/**
 * The {@code sumOfDigitsOfString} class provides methods to calculate the "lucky" sum
 * of a given string by transforming its characters to digits and performing digit sums.
 */
public class sumOfDigitsOfString {

    /**
     * Calculates the lucky sum of the characters in the input string.
     * Each character is transformed to its corresponding digit, and the digit sum
     * is computed a specified number of times.
     *
     * @param s the input string to be processed
     * @param k the number of times to perform the digit sum
     * @return the resulting lucky sum after processing the string and applying digit sums
     */
    public static int getLucky(String s, int k) {
        List<Integer> l = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            l.add(ch - '0'); // Adjust to convert char to its digit value
        }
        
        int sum = 0;
        for (int i = 0; i < l.size(); i++) {
            int curr = 0;
            int n = l.get(i);
            if (n >= 10) {
                while (n > 0) {
                    curr += (n % 10);
                    n /= 10;
                }
                sum += curr;
            } else {
                sum += l.get(i);
            }
        }
        
        for (int i = 1; i < k; i++) {
            sum = digitSum(sum);
        }
        
        return sum;
    }

    /**
     * Computes the digit sum of a given number.
     *
     * @param num the number to calculate the digit sum for
     * @return the sum of the digits of the number
     */
    private static int digitSum(int num) {
        if (num == 0) {
            return 0;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /**
     * Main method to test the getLucky method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String s = "hvmhoasabaymnmsd";
        System.out.println(getLucky(s, 1));
    }
}
