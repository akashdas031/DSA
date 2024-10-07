package DSA.Algorithms;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The {@code readFileHuffMan} class demonstrates reading input from a file, 
 * encoding the data using Huffman coding, and then decoding it back to verify 
 * the process. It utilizes the {@code HoffManCoder} class for encoding and 
 * decoding operations.
 */
public class readFileHuffMan {
    /**
     * The main method that orchestrates the reading, encoding, and decoding 
     * of data. It performs the following steps:
     * <ol>
     *   <li>Reads input data from a specified text file.</li>
     *   <li>Creates an instance of {@code HoffManCoder} with the input data.</li>
     *   <li>Encodes the data and writes the encoded output to a binary file.</li>
     *   <li>Reads the encoded data back from the binary file.</li>
     *   <li>Decodes the encoded data.</li>
     *   <li>Writes the decoded output to a specified text file.</li>
     * </ol>
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Read input from the input.txt file
            String inputData = new String(Files.readAllBytes(Paths.get("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\input.txt")));
            
            // Create an instance of HoffManCoder with the input data
            HoffManCoder huffmanCoder = new HoffManCoder(inputData);
            
            // Encode the data
            String encodedData = huffmanCoder.encode(inputData);
            
            // Write the encoded data to a file
            huffmanCoder.writeEncodedToFile(encodedData, "C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\encoded.bin");
            
            // Read the encoded data from the file
            String readEncodedData = huffmanCoder.readEncodedFromFile("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\encoded.bin");
            
            // Decode the data
            String decodedData = huffmanCoder.decode(readEncodedData);
            
            // Write the decoded data to a file
            huffmanCoder.writeDecodedToFile(decodedData, "C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\decoded.txt");
            
            System.out.println("Encoding and decoding completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
