package DSA.leetCode;

/**
 * The {@code repeatedSubstringPattern} class provides a method to determine if a given 
 * string can be constructed by repeating a substring.
 */
public class repeatedSubstringPattern {

    /**
     * Checks if the input string can be formed by repeating a substring.
     *
     * @param s the input string to be checked
     * @return {@code true} if the string can be constructed by repeating a substring, 
     *         {@code false} otherwise
     */
    public static boolean substringMatch(String s) {
        int n = s.length();
        
        // Check all possible lengths of substrings that could form s
        for (int len = 1; len <= n / 2; len++) {
            // Only consider lengths that are divisors of n
            if (n % len == 0) {
                // Calculate the substring
                String substring = s.substring(0, len);
               
                // Reconstruct the string from repeated substrings
                StringBuilder constructed = new StringBuilder();
                for (int i = 0; i < n / len; i++) {
                    constructed.append(substring);
                }
                
                // Check if the constructed string matches the original string
                if (constructed.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    /**
     * Main method to test the substringMatch method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(substringMatch(s));
    }
}
