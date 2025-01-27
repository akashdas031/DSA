package DSA.leetCode;

public class longestPalindromicSubstring {
  
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
           return "";
       }
       // Initialize variables to store the start and end indices of the longest palindrome
       int start = 0;
       int end = 0;
       // Loop through the string to check for palindromes centered at each character
       for (int i = 0; i < s.length(); i++) {
           // Expand around center for both odd-length and even-length palindromes
           int len1 = expandAroundCenter(s, i, i); // Odd-length palindrome
           int len2 = expandAroundCenter(s, i, i + 1); // Even-length palindrome
           // Find the maximum length between the two
           int len = Math.max(len1, len2);

           // If the found palindrome is longer than the current longest, update the start and end indices
           if (len > end - start) {
               start = i - (len - 1) / 2;
               end = i + len / 2;
           }
       }

       // Return the longest palindrome substring
       return s.substring(start, end + 1);
   }
   private static int expandAroundCenter(String s,int left,int right){
       while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
           left--;
           right++;
       }
       return right-left-1;
   }
   public static void main(String[] args) {
       String s="babad";
       System.out.println(longestPalindrome(s));
   }
}
