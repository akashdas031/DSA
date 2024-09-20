package DSA.leetCode;

public class repeatedSubstringPattern {
    public static boolean substringMatch(String s){
        int n = s.length();
        
        // Check all possible lengths of substrings that could form s
        for (int len = 1; len <= n / 2; len++) {
            // Only consider lengths that are divisors of n
            if (n % len == 0) {
                // Calculate the hash for the substring
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
    public static void main(String[] args) {
        String s="ababab";
        System.out.println(substringMatch(s));
    }
}
