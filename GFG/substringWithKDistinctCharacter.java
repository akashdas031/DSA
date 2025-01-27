package DSA.GFG;

import java.util.HashMap;

public class substringWithKDistinctCharacter {
    public static int atMostKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the map
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            // Shrink the window if we have more than `k` distinct characters
            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            // Add the number of substrings that end at `right` and have at most `k` distinct characters
            result += right - left + 1;
        }

        return result;
    }

    public static int countSubstr(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }
    public static void main(String[] args) {
        String s="abaaca";
        System.out.println(countSubstr(s, 1));
    }
}
