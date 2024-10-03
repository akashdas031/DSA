package DSA.Algorithms;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageCompressor {

    public static void main(String[] args) throws Exception {
        try {
            // Load image
            File inputFile = new File("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\input.png");
            System.out.println("Input file exists: " + inputFile.exists());

            BufferedImage image = ImageIO.read(inputFile);
            byte[] imageBytes = getImageBytes(image);

            // Compress image
            HuffmanImageCompressor huffmanCoder = new HuffmanImageCompressor(imageBytes);
            String encodedData = huffmanCoder.encode(imageBytes);
            writeEncodedToFile(encodedData, "C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\compressed.huff");

            // Decompress image
            String compressedData = readEncodedFromFile("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\compressed.huff");
            byte[] decompressedBytes = huffmanCoder.decode(compressedData);
            BufferedImage decompressedImage = getImageFromBytes(decompressedBytes, image.getWidth(), image.getHeight());

            // Save decompressed image
            ImageIO.write(decompressedImage, "png", new File("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\decompressed_image.png"));
            System.out.println("Original image size: " + inputFile.length() + " bytes");
System.out.println("Compressed file size: " + new File("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\compressed.huff").length() + " bytes");
System.out.println("Decompressed image size: " + new File("C:\\Users\\lenovo\\Desktop\\VSCodeDSA\\DSA\\decompressed_image.png").length() + " bytes");

            System.out.println("Image compression and decompression completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] getImageBytes(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        byte[] imageBytes = new byte[width * height * 3]; // Assuming RGB

        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                imageBytes[index++] = (byte) ((rgb >> 16) & 0xFF); // Red
                imageBytes[index++] = (byte) ((rgb >> 8) & 0xFF);  // Green
                imageBytes[index++] = (byte) (rgb & 0xFF);         // Blue
            }
        }
        return imageBytes;
    }

    private static BufferedImage getImageFromBytes(byte[] bytes, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = bytes[index++] & 0xFF;
                int g = bytes[index++] & 0xFF;
                int b = bytes[index++] & 0xFF;
                int rgb = (r << 16) | (g << 8) | b;
                image.setRGB(x, y, rgb);
            }
        }
        return image;
    }

    private static void writeEncodedToFile(String encodedData, String outputPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(encodedData);
        }
    }

    private static String readEncodedFromFile(String inputPath) throws IOException {
        StringBuilder encodedData = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                encodedData.append(line);
            }
        }
        return encodedData.toString();
    }
}
