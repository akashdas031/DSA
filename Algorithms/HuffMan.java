package DSA.Algorithms;

import java.util.BitSet;

/**
 * The {@code HuffMan} class demonstrates the usage of the {@code HoffManCoder} 
 * for encoding and decoding a string using Huffman coding. 
 * It also includes a simple implementation of the Fibonacci sequence.
 */
public class HuffMan {
    /**
     * The entry point of the application. 
     * This method creates an instance of {@code HoffManCoder} with a sample string,
     * encodes the string, and then decodes it back to verify the process.
     *
     * @param args the command-line arguments (not used)
     * @throws Exception if an error occurs during encoding or decoding
     */
    public static void main(String[] args) throws Exception {
        String str = "huffman"; // Sample string to be encoded
        HoffManCoder huffman = new HoffManCoder(str); // Create Huffman coder instance
        String enc = huffman.encode(str); // Encode the string
        System.out.println(enc); // Print the encoded string
        String dec = huffman.decode(enc); // Decode the string
        System.out.println(dec); // Print the decoded string

        // Simple Fibonacci sequence demonstration
        int a = 0; // First Fibonacci number
        int b = 1; // Second Fibonacci number
        System.out.println(a); // Print first Fibonacci number
        System.out.println(b); // Print second Fibonacci number
        for (int i = 2; i <= 5; i++) {
            int c = a + b; // Calculate the next Fibonacci number
            System.out.println(c); // Print the Fibonacci number
            a = b; // Update first number
            b = c; // Update second number
        }
    }
}
