package DSA.GFG;

import java.util.Stack;

public class sortStackUsingRecursion{

    public static void insertSorted(Stack<Integer> stack,int element){
        if(stack.isEmpty() || stack.peek()<=element){
            stack.push(element);
        }
        stack.pop();
        insertSorted(stack,element);
        stack.push(top);
    }
    public static Stack<Integer> sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return s;
        }

        int top=stack.pop();
        sort(stack);

        insertSorted(stack,top);
        return stack;
    }
}