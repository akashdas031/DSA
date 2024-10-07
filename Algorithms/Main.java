package DSA.Algorithms;

/**
 * The {@code Main} class serves as the entry point for the Karp-Rabin substring search demonstration.
 * It initializes an instance of the {@code KarpRabin} class and uses it to find the index of a
 * specified pattern within a given sentence.
 */
public class Main {
    /**
     * The main method that executes the substring search using the Karp-Rabin algorithm.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        KarpRabin karpRabin = new KarpRabin(); // Create an instance of KarpRabin
        String sentence = "helloworldfromakash"; // The text to search within
        String pattern = "akash"; // The pattern to search for
        // Print the index of the first occurrence of the pattern in the sentence
        System.out.println(karpRabin.getMatchIndex(sentence, pattern));
    }
}
