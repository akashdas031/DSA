package DSA.Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import DSA.CustomDataStructures.MinHeap;

/**
 * The {@code HoffManCoder} class implements Huffman coding, a lossless data compression algorithm.
 * It provides methods to encode and decode strings using Huffman codes, as well as to read from and
 * write to files.
 */
public class HoffManCoder {

    // Maps characters to their corresponding Huffman codes
    HashMap<Character, String> encoder;
    // Maps Huffman codes to their corresponding characters
    HashMap<String, Character> decoder;

    /**
     * A private inner class representing a node in the Huffman tree.
     */
    private class Node implements Comparable<Node> {
        Character data;
        int frequency;
        Node left;
        Node right;

        /**
         * Constructs a new {@code Node} with the specified character and frequency.
         *
         * @param data the character stored in this node
         * @param frequency the frequency of the character
         */
        public Node(Character data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.frequency - other.frequency;
        }
    }

    /**
     * Constructs a {@code HoffManCoder} instance and builds the Huffman tree based on the
     * frequency of characters in the given input string.
     *
     * @param inputString the string to encode
     * @throws Exception if an error occurs while building the Huffman tree
     */
    public HoffManCoder(String inputString) throws Exception {
        // Create a frequency map for each character in the input string
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            freqMap.put(character, freqMap.getOrDefault(character, 0) + 1);
        }
        System.out.println("Frequency Map: " + freqMap);

        // Create a min heap to store nodes
        MinHeap<Node> minHeap = new MinHeap<>();
        Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();

        // Insert nodes into the min heap
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        // Merge nodes in the min heap until only one node is left
        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            // Create a new node with the combined frequency
            Node newNode = new Node('\0', first.frequency + second.frequency);
            newNode.left = first;
            newNode.right = second;

            minHeap.insert(newNode);
        }

        // Initialize the encoder and decoder maps
        Node ft = minHeap.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        // Initialize the encoder and decoder maps recursively
        this.initEncoderDecoder(ft, "");
    }

    /**
     * Initializes the encoder and decoder maps recursively based on the Huffman tree.
     *
     * @param node the current node in the Huffman tree
     * @param osf the string representation of the current path in the tree
     */
    private void initEncoderDecoder(Node node, String osf) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            // Map the character to its Huffman code
            this.encoder.put(node.data, osf);
            this.decoder.put(osf, node.data);
        }
        initEncoderDecoder(node.left, osf + "0");
        initEncoderDecoder(node.right, osf + "1");
    }

    /**
     * Encodes a string into a {@code BitSet} using the Huffman codes.
     *
     * @param source the string to encode
     * @return a {@code BitSet} representing the encoded data
     */
    public BitSet encodeBitset(String source) {
        BitSet bitSet = new BitSet();
        int bitIndex = 0;

        for (int i = 0; i < source.length(); i++) {
            String code = encoder.get(source.charAt(i));
            for (char c : code.toCharArray()) {
                if (c == '1') {
                    bitSet.set(bitIndex);
                }
                bitIndex++;
            }
        }

        return bitSet;
    }

    /**
     * Decodes a {@code BitSet} back into a string using the Huffman codes.
     *
     * @param bitSet the {@code BitSet} to decode
     * @param length the length of the original string
     * @return the decoded string
     */
    public String decodeBitset(BitSet bitSet, int length) {
        StringBuilder key = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int currentIndex = 0; // Track the current bit index

        while (currentIndex < bitSet.length()) {
            // Append the current bit to the key
            if (bitSet.get(currentIndex)) {
                key.append('1');
            } else {
                key.append('0');
            }

            // Check if the key is in the decoder
            if (decoder.containsKey(key.toString())) {
                ans.append(decoder.get(key.toString()));
                key.setLength(0); // Clear the key for the next use
            }
            currentIndex++;
        }

        return ans.toString();
    }

    /**
     * Encodes a string into a Huffman code.
     *
     * @param source the string to encode
     * @return the encoded Huffman code as a string
     */
    public String encode(String source) {
        String ans = "";
        for (int i = 0; i < source.length(); i++) {
            ans = ans + encoder.get(source.charAt(i));
        }

        return ans;
    }

    /**
     * Decodes a Huffman code back into a string.
     *
     * @param codedString the Huffman code to decode
     * @return the decoded string
     */
    public String decode(String codedString) {
        String key = "";
        String ans = "";
        for (int i = 0; i < codedString.length(); i++) {
            key = key + codedString.charAt(i);
            if (decoder.containsKey(key)) {
                ans = ans + decoder.get(key);
                key = "";
            }
        }
        return ans;
    }

    /**
     * Reads the contents of a file into a string.
     *
     * @param filePath the path to the file
     * @return the contents of the file as a string
     * @throws IOException if an error occurs while reading the file
     */
    public String readFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString().trim(); // Remove trailing newline
    }

    /**
     * Writes encoded data to a binary file.
     *
     * @param encodedData the encoded data to write
     * @param outputPath the path to the output file
     * @throws IOException if an error occurs while writing to the file
     */
    public void writeEncodedToFile(String encodedData, String outputPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(encodedData);
        }
    }

    /**
     * Reads encoded data from a file.
     *
     * @param inputPath the path to the input file
     * @return the encoded data as a string
     * @throws IOException if an error occurs while reading the file
     */
    public String readEncodedFromFile(String inputPath) throws IOException {
        StringBuilder encodedData = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                encodedData.append(line);
            }
        }
        return encodedData.toString();
    }

    /**
     * Writes the decoded data to a file.
     *
     * @param decodedData the decoded data to write
     * @param outputPath the path to the output file
     * @throws IOException if an error occurs while writing to the file
     */
    public void writeDecodedToFile(String decodedData, String outputPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(decodedData);
        }
    }
}
