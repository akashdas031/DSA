package DSA.GFG;

import java.util.Stack;

public class sortStackUsingRecursion {

    public static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertSorted(stack, element);
            stack.push(top);
        }
    }

    public static Stack<Integer> sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int top = stack.pop();
        sort(stack);
        insertSorted(stack, top);
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(21);
        st.push(41);
        st.push(4);
        st.push(32);
        st.push(13);
        Stack<Integer> sortedStack = sort(st);
        System.out.println(sortedStack);

    }

}