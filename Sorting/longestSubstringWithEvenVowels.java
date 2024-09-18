package DSA.Sorting;
import java.util.Arrays;

/**
 * longestSubstringWithEvenVowels
 */
public class longestSubstringWithEvenVowels {

     public static int findTheLongestSubstring(String s) {
           // Vowels to bits: a = 0, e = 1, i = 2, o = 3, u = 4
        int[] firstOccurrence = new int[1 << 5]; // 32 possible bit states
        Arrays.fill(firstOccurrence, -1); // Initialize all positions to -1
        firstOccurrence[0] = 0; // Base case: the empty prefix has an even count of vowels
        
        int maxLen = 0, mask = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Update bitmask based on the current character
            if (c == 'a') {
                mask ^= (1 << 0);
            } else if (c == 'e') {
                mask ^= (1 << 1);
            } else if (c == 'i') {
                mask ^= (1 << 2);
            } else if (c == 'o') {
                mask ^= (1 << 3);
            } else if (c == 'u') {
                mask ^= (1 << 4);
            }
            
            // If this mask was seen before, calculate the length of the substring
            if (firstOccurrence[mask] >= 0) {
                maxLen = Math.max(maxLen, i + 1 - firstOccurrence[mask]);
            } else {
                // Record the first occurrence of this mask
                firstOccurrence[mask] = i + 1;
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        String word="leetcodeisgreat";
        System.out.println(findTheLongestSubstring(word));
    }
}