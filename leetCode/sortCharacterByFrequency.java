package DSA.leetCode;

public class sortCharacterByFrequency {
    public static String frequencySort(String s) {
        int[] freq = new int[256]; // Array to store frequency of each character
        char[] ans = new char[s.length()];
        int index = 0; // To keep track of the position in the result array

        // Calculate the frequency of each character
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        // Sort characters based on frequency
        while (true) {
            int max = Integer.MIN_VALUE; // Reset max for each iteration
            int ind = -1; // To store the index of the character with max frequency

            for (int i = 0; i < freq.length; i++) { // Find the character with the highest frequency
                if (freq[i] > max) {
                    max = freq[i];
                    ind = i;
                }
            }

            // Break the loop if all frequencies are 0
            if (max == 0) {
                break;
            }

            // Append the character to the result array and decrement its frequency
            while (freq[ind] > 0) {
                ans[index++] = (char) ind;
                freq[ind]--;
            }
        }

        return new String(ans);
    }
    public static void main(String[] args) {
        String s="ThisistheStringtosort";
        System.out.println(frequencySort(s));
    }
}
