package DSA.leetCode;

public class reverseWordsInString {
    public static String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int n = s.length();
        int i = n - 1;
        
        // Iterate through the string from end to start
        while (i >= 0) {
            // Skip any trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            
            // If we reached the start of the string, we're done
            if (i < 0) break;
            
            // Find the end of the current word
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            
            // Append the current word to the StringBuilder
            if (reversed.length() > 0) {
                reversed.append(" "); // Add space between words
            }
            reversed.append(s.substring(j + 1, i + 1));
            
            // Move i to the position before the current word
            i = j - 1;
        }
        
        return reversed.toString();
    }
    public static void main(String[] args) {
        String s="the sky is blue";
        System.out.println(reverseWords(s));
    }
}
