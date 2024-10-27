package DSA.DataTypeIdentifier;
import java.util.*;

public class DataTypeClassifierMain {
    public static void main(String[] args) {
        DataTypeDecisionTree dt = new DataTypeDecisionTree();
        List<DataPoint> dataPoints = new ArrayList<>();

        // Training data points for various Java data types
        dataPoints.add(new DataPoint(null, "Null"));
        dataPoints.add(new DataPoint(true, "Boolean"));
        dataPoints.add(new DataPoint(false, "Boolean"));
        dataPoints.add(new DataPoint('A', "Character"));
        dataPoints.add(new DataPoint(42, "Integer"));
        dataPoints.add(new DataPoint(10000000000L, "Long")); // Example of a long
        dataPoints.add(new DataPoint(3.14f, "Float"));
        dataPoints.add(new DataPoint(2.718281828459045, "Double"));
        dataPoints.add(new DataPoint("Hello, World!", "String"));
        dataPoints.add(new DataPoint(new Integer(100), "Integer")); // Wrapper type
        dataPoints.add(new DataPoint(new Float(3.14), "Float"));     // Wrapper type
        dataPoints.add(new DataPoint(new Long(10000000000L), "Long")); // Wrapper type

        dt.train(dataPoints);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value to determine its type (type 'exit' to quit):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Try to classify the input
            Object value = parseInput(input);
            String res = dt.classify(value);
            System.out.println("Value: " + input + " is classified as: " + res);
        }

        scanner.close();
    }

    private static Object parseInput(String input) {
        // Check for null
        if (input.equalsIgnoreCase("null")) {
            return null;
        }
        
        // Check for boolean
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(input);
        }
    
        // Check for integer
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ignored) {}
    
        // Check for long
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException ignored) {}
    
        // Check for float/double
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException ignored) {}
    
        // Check for character (assuming a single character input)
        if (input.length() == 1) {
            return input.charAt(0);
        }
    
        // If it reaches here, treat it as a String
        return input;
    }
    
}
