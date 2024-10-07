package DSA.leetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * The {@code validParanthesis} class provides a method to validate
 * a string of parentheses, ensuring that each opening bracket has
 * a corresponding and correctly ordered closing bracket.
 */
public class validParanthesis {

    /**
     * Validates the string of parentheses.
     * Checks if the parentheses are valid by ensuring that each
     * opening bracket is matched by its corresponding closing bracket.
     *
     * @param paranthesis the string containing parentheses to be validated
     * @return {@code true} if the parentheses are valid; {@code false} otherwise
     */
    public static boolean isValid(String paranthesis) {
        Stack<Character> stack = new Stack<>();
        
        // Mapping of closing brackets to their corresponding opening brackets
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for (char c : paranthesis.toCharArray()) {
            // If it's a closing bracket
            if (bracketMap.containsKey(c)) {
                // Get the top element of the stack if it exists
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // Check if the top element matches the corresponding opening bracket
                if (topElement != bracketMap.get(c)) {
                    return false; // Mismatch found
                }
            } else {
                // It's an opening bracket, push it to the stack
                stack.push(c);
            }
        }

        // If the stack is empty, all brackets are valid
        return stack.isEmpty();
    }

    /**
     * Main method to test the {@code isValid} method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String paranthesis = "{}()[]";
        System.out.println(isValid(paranthesis));
    }
}
