package DSA.Algorithms;

/**
 * The {@code KarpRabin} class implements the Karp-Rabin algorithm for substring search.
 * This algorithm efficiently finds the first occurrence of a specified pattern within a given text
 * using hashing to compare substrings.
 */
public class KarpRabin {
    private int prime = 101; // A prime number used for hash calculation

    /**
     * Calculates the hash value of the given pattern using a polynomial rolling hash function.
     *
     * @param pattern the string pattern for which to calculate the hash
     * @return the hash value of the pattern as a {@code long}
     */
    private long calculateHash(String pattern) {
        long hash = 0;
        for (int i = 0; i < pattern.length(); i++) {
            hash += pattern.charAt(i) * Math.pow(prime, i);
        }
        return hash;
    }

    /**
     * Updates the hash value when sliding the window over the text.
     *
     * @param oldHash the hash value of the previous window
     * @param oldChar the character that is being removed from the window
     * @param newChar the character that is being added to the window
     * @param patternLength the length of the pattern
     * @return the updated hash value as a {@code long}
     */
    private long updateHash(long oldHash, char oldChar, char newChar, int patternLength) {
        long newHash = (oldHash - oldChar) / prime;
        newHash += newChar * Math.pow(prime, patternLength - 1);
        return newHash;
    }

    /**
     * Searches for the first occurrence of the pattern in the given sentence and returns its index.
     *
     * @param sentence the text in which to search for the pattern
     * @param pattern the pattern to search for within the sentence
     * @return the index of the first occurrence of the pattern, or -1 if not found
     */
    public int getMatchIndex(String sentence, String pattern) {
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long sentenceHash = calculateHash(sentence.substring(0, patternLength));
        int matchingIndex = -1;

        for (int i = 0; i <= sentence.length() - patternLength; i++) {
            // Check for hash match and then confirm by comparing the actual substring
            if (patternHash == sentenceHash) {
                if (sentence.substring(i, i + patternLength).equals(pattern)) {
                    matchingIndex = i; // Update matching index if found
                }
            }
            // Update the hash for the next window
            if (i < sentence.length() - patternLength) {
                sentenceHash = updateHash(sentenceHash, sentence.charAt(i), sentence.charAt(i + patternLength), patternLength);
            }
        }
        return matchingIndex; // Return the final matching index
    }
}
