package DSA.Algorithms;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;
    int pixelValue;
    HuffmanNode left, right;

    public HuffmanNode(int pixelValue, int frequency) {
        this.pixelValue = pixelValue;
        this.frequency = frequency;
        left = right = null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanImageCompressor {
    private Map<Integer, String> huffmanCodes = new HashMap<>();
    private Map<String, Integer> reverseHuffmanCodes = new HashMap<>();

    public void compress(BufferedImage image) throws IOException {
        // Step 1: Calculate frequency of pixel values (grayscale)
        int[] frequency = new int[256]; // For 8-bit grayscale
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixelValue = (image.getRGB(x, y) >> 16) & 0xFF; // Grayscale pixel value
                frequency[pixelValue]++;
            }
        }

        // Step 2: Build the Huffman Tree
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                priorityQueue.add(new HuffmanNode(i, frequency[i]));
            }
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode parent = new HuffmanNode(-1, left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            priorityQueue.add(parent);
        }

        HuffmanNode root = priorityQueue.poll();
        generateCodes(root, "");

        // Step 3: Compress image data
        try (BitOutputStream bitOutput = new BitOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\compressed.huff")))) {
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixelValue = (image.getRGB(x, y) >> 16) & 0xFF; // Grayscale pixel value
                    bitOutput.writeBits(huffmanCodes.get(pixelValue));
                }
            }
        }
        saveHuffmanCodes("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\huffman_codes.txt");
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.pixelValue, code);
            reverseHuffmanCodes.put(code, node.pixelValue);
            return;
        }
        if (node.left != null) {
            generateCodes(node.left, code + "0");
        }
        if (node.right != null) {
            generateCodes(node.right, code + "1");
        }
    }

    private void saveHuffmanCodes(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<Integer, String> entry : huffmanCodes.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        }
    }

    public void decompress(String compressedFile, String codesFile, int width, int height) throws IOException {
        // Step 1: Read the Huffman codes
        try (BufferedReader reader = new BufferedReader(new FileReader(codesFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                int pixelValue = Integer.parseInt(parts[0]);
                String code = parts[1];
                reverseHuffmanCodes.put(code, pixelValue);
            }
        }

        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        StringBuilder currentCode = new StringBuilder();

        // Step 2: Read the compressed data
        try (BitInputStream bitInput = new BitInputStream(new BufferedInputStream(new FileInputStream(compressedFile)))) {
            int x = 0, y = 0;
            while (true) {
                int bit = bitInput.readBit();
                if (bit == -1) break; // End of stream
                currentCode.append(bit);
                if (reverseHuffmanCodes.containsKey(currentCode.toString())) {
                    int pixelValue = reverseHuffmanCodes.get(currentCode.toString());
                    outputImage.setRGB(x, y, (pixelValue << 16) | (pixelValue << 8) | pixelValue); // Set pixel in grayscale
                    currentCode.setLength(0); // Reset for the next code

                    // Update pixel coordinates
                    x++;
                    if (x >= width) {
                        x = 0;
                        y++;
                    }
                    if (y >= height) break; // Prevent going out of bounds
                }
            }
        }

        // Save the decompressed image as output.png
        javax.imageio.ImageIO.write(outputImage, "png", new File("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\output.jpg"));
    }

    public static void main(String[] args) {
        try {
            BufferedImage image = javax.imageio.ImageIO.read(new File("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\input.jpg")); // Load your image
            // Convert to grayscale
            BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int rgb = image.getRGB(x, y);
                    int grayValue = (int)(0.299 * ((rgb >> 16) & 0xFF) + 0.587 * ((rgb >> 8) & 0xFF) + 0.114 * (rgb & 0xFF));
                    grayImage.setRGB(x, y, (grayValue << 16) | (grayValue << 8) | grayValue); // Set grayscale pixel
                }
            }

            HuffmanImageCompressor compressor = new HuffmanImageCompressor();
            compressor.compress(grayImage);
            System.out.println("Image compressed successfully. Output saved as compressed.huff");

            // Decompressing the image
            compressor.decompress("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\compressed.huff", 
                                  "C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\huffman_codes.txt", 
                                  grayImage.getWidth(), grayImage.getHeight());
            System.out.println("Image decompressed successfully. Output saved as output.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// BitOutputStream class
class BitOutputStream implements AutoCloseable {
    private OutputStream out;
    private int currentByte;
    private int numBitsFilled;

    public BitOutputStream(OutputStream out) {
        this.out = out;
        this.currentByte = 0;
        this.numBitsFilled = 0;
    }

    public void writeBits(String bits) throws IOException {
        for (char bit : bits.toCharArray()) {
            currentByte = (currentByte << 1) | (bit == '1' ? 1 : 0);
            numBitsFilled++;
            if (numBitsFilled == 8) {
                out.write(currentByte);
                currentByte = 0;
                numBitsFilled = 0;
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (numBitsFilled > 0) {
            out.write(currentByte << (8 - numBitsFilled)); // Padding remaining bits
        }
        out.close();
    }
}

// BitInputStream class
class BitInputStream implements AutoCloseable {
    private InputStream in;
    private int currentByte;
    private int numBitsRemaining;

    public BitInputStream(InputStream in) {
        this.in = in;
        this.numBitsRemaining = 0;
    }

    public int readBit() throws IOException {
        if (numBitsRemaining == 0) {
            currentByte = in.read();
            if (currentByte == -1) return -1; // End of stream
            numBitsRemaining = 8;
        }
        numBitsRemaining--;
        return (currentByte >> numBitsRemaining) & 1;
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
