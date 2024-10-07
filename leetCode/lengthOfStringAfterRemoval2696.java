package DSA.leetCode;

import DSA.Sorting.insertionSort;
import java.util.Stack;
/**
 * lengthOfStringAfterRemoval2696
 */
public class lengthOfStringAfterRemoval2696 {

    //Using StringBuilder
    public static int removeStringUsingStringBuilder(String s) {
        // Create a new StringBuilder object to build the resulting string
        StringBuilder sb = new StringBuilder();
        
        // Iterate over each character in the input string
        for (char ch : s.toCharArray()) {
            // Append the current character to the StringBuilder
            sb.append(ch);
            
            // Check if the StringBuilder has at least 2 characters
            if (sb.length() >= 2) {
                // Get the length of the current StringBuilder
                int len = sb.length();
                
                // Extract the last 2 characters from the StringBuilder
                String lastTwo = sb.substring(len - 2, len);
                
                // Check if the last 2 characters are either "AB" or "CD"
                if (lastTwo.equals("AB") || lastTwo.equals("CD")) {
                    // If they are, remove the last 2 characters from the StringBuilder
                    sb.delete(len - 2, len);
                }
            }
        }
        
        // Return the length of the resulting StringBuilder
        return sb.length();
    }


    //using stack
    public static int removeStringUsingStack(String s) {

        // Create a stack to store characters from the input string
        Stack<Character> stack = new Stack<>();
    
        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            // Check if the stack is not empty
            if (!stack.isEmpty()) {
                // Check if the top of the stack is 'A' and the current character is 'B'
                if (stack.peek() == 'A' && ch == 'B') {
                    // If true, remove the top element from the stack (i.e., 'A')
                    stack.pop();
                    // Skip to the next iteration, as we've already processed this character
                    continue;
                }
                // Check if the top of the stack is 'C' and the current character is 'D'
                if (stack.peek() == 'C' && ch == 'D') {
                    // If true, remove the top element from the stack (i.e., 'C')
                    stack.pop();
                    // Skip to the next iteration, as we've already processed this character
                    continue;
                }
            }
            // If the stack is empty or the current character doesn't match the top of the stack,
            // push the current character onto the stack
            stack.push(ch);
        }
        // Return the size of the stack, which represents the number of characters remaining
        // after removing the specified pairs
        return stack.size();
    }
    //simple iteration
    public static int removeString(String s){
       while(s.contains("AB") || s.contains("CD")){
        s=s.replace("AB", "");
        s=s.replace("CD", "");
       }
       return s.length();
    }
    public static void main(String[] args) {
        String s="ABCFCDJCDCBADCB";
        System.out.println(removeStringUsingStringBuilder(s));
    }
}