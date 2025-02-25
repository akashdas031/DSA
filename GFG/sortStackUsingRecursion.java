package DSA.GFG;

import java.util.Stack;

public class sortStackUsingRecursion {

    //sort stack

    public static Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> helper=new Stack<>();
        while(!stack.isEmpty()){
            int element=stack.pop();
            while(!helper.isEmpty() && helper.peek()>element){
                stack.push(helper.pop());
            }
            helper.push(element);
        }
        return helper;

    }

    //sort stack using recursion
    public static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertSorted(stack, element);
            stack.push(top);
        }
    }
    public static Stack<Integer> sortUsingRecursion(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int top = stack.pop();
        sortUsingRecursion(stack);
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