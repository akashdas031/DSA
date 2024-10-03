package DSA.Algorithms;

import java.nio.file.Files;
import java.nio.file.Paths;

public class readFileHuffMan {
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
