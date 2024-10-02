package DSA.leetCode;

import java.util.HashMap;
import java.util.Stack;

public class validParanthesis {
    public static boolean isValid(String paranthesis){
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
    public static void main(String[] args) {
        String paranthesis="{}()[]";
        System.out.println(isValid(paranthesis));
    }
}
