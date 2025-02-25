package DSA.GFG;

import java.util.LinkedList;
import java.util.Queue;
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
    //reverse the stack without recursion
    public static Stack<Integer> reverseStack(Stack<Integer> stack){
        Stack<Integer> helper=new Stack<>();

        while(!stack.isEmpty()){
            helper.push(stack.pop());
        }
        return helper;
    }
    //reverse stack
    public static Stack<Integer> reverseStackRecursion(Stack<Integer> stack){
        if(stack.isEmpty()){
            return stack;
        }
        int element=stack.pop();

        reverseStackRecursion(stack);
        insertAtTheEnd(stack,element);
        return stack;
    }
    //helper to reverse the stack 
    public static void insertAtTheEnd(Stack<Integer> stack,int element){
        if(stack.isEmpty()){
            stack.push(element);
            return ;
        }
        int top=stack.pop();
        insertAtTheEnd(stack, element);
        stack.push(top);
    }
    //reverse queue
    public static Queue<Integer> reverseQueue(Queue<Integer> queue){
       // Temporary stack to help with reversing the queue
       Stack<Integer> temp = new Stack<>();

       while (!queue.isEmpty()) {
           temp.push(queue.poll());
       }
       while (!temp.isEmpty()) {
           queue.offer(temp.pop());
       }

       return queue;
   }

   // Function to reverse the queue using recursion
   public static void reverseQueueRecursion(Queue<Integer> queue) {
       // Base case: If the queue is empty, return.
       if (queue.isEmpty()) {
           return;
       }

       // Remove the front element from the queue
       int element = queue.poll();

       // Recursively sort the remaining queue
       reverseQueueRecursion(queue);
       queue.offer(element);

   }

   public static void main(String[] args) {
       Stack<Integer> st = new Stack<>();
       st.push(5);
       st.push(21);
       st.push(41);
       st.push(4);
       st.push(32);
       st.push(13);
       System.out.println(st);
       Stack<Integer> sortedStack = reverseStack(st);
       System.out.println(sortedStack);
    //    Queue<Integer> queue = new LinkedList<>();
    //    queue.offer(5);
    //    queue.offer(21);
    //    queue.offer(41);
    //    queue.offer(4);
    //    queue.offer(32);
    //    queue.offer(13);
    //    System.out.println(queue);
    //    Queue<Integer> req=reverseQueue(queue);
    //    System.out.println(req);

   }

}