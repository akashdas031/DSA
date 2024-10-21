package DSA.leetCode;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
/**
 * parsingBooleanExpression
 * https://leetcode.com/problems/parsing-a-boolean-expression/submissions/1428039826/?envType=daily-question&envId=2024-10-20
 */
public class parsingBooleanExpression {

    public static boolean parseBoolExprItr(String expression) {
        //create stack for keep track of characters
        Stack<Character> stack=new Stack<>();
         for(char ch:expression.toCharArray()){
            //push all the charcter to the stack except the closing bracket
            if(ch != ')'){
                stack.push(ch);
            }else{
                /* 
                  if encounter the closing bracket then remove from stack and add it in a list untill getting a open bracket. when get an opening bracket then remove it and check for the operand
                */
                List<Character> operand=new ArrayList<>();
                while(stack.peek()!='('){
                    operand.add(stack.pop());
                }
                stack.pop();
                //get the operator after removal of all characters till open bracket and the bracket itself the previous character will be an operator
                char operator=stack.pop();
                //create a variable to perform the operation
                boolean res=false;
                if(operator=='!'){
                    //for not operator only one operand is required so if true make the result  false and if false make the result as true
                    res=operand.get(0)=='f';
                }else if(operator=='&'){
                    //if the operator is ans make the res as true and check if any one false found make the result false
                    res=true;
                    for(char operands: operand){
                        if(operands=='f'){
                            res=false;
                            break;
                        }
                    }
                }else if(operator=='|'){
                    //in case of OR operator check if any one true found then make the result as true
                    res=false;
                    for(char operands:operand){
                        if(operands=='t'){
                            res=true;
                            break;
                        }
                    }
                }
                //push it to the stack after processing
                stack.push(res?'t':'f');
            }
         }
         //after processing only one result will be left in stack and check whether it is true or false and return it
         return stack.pop()=='t';
    }
    //recursive approach
    public static boolean parseBoolExpr(String expression) {
           return evaluate(expression);
    }
    
    private static boolean evaluate(String expr) {
        // If the expression is a single value, return true for 't' and false for 'f'
        if (expr.equals("t")) return true;
        if (expr.equals("f")) return false;
        
        // Extract operator and operands
        char operator = expr.charAt(0);
        String content = expr.substring(2, expr.length() - 1);  // Remove outer brackets
        
        // Split operands by commas
        List<String> operands = splitOperands(content);
        
        if (operator == '!') {
            return !evaluate(operands.get(0));  // NOT operation only applies to one operand
        } else if (operator == '&') {
            // AND operation: all operands must be true
            for (String operand : operands) {
                if (!evaluate(operand)) return false;
            }
            return true;
        } else if (operator == '|') {
            // OR operation: at least one operand must be true
            for (String operand : operands) {
                if (evaluate(operand)) return true;
            }
            return false;
        }
        
        // Default case (should not reach here)
        return false;
    }
    
    // Helper function to split operands at the top level (ignoring inner brackets)
    private static List<String> splitOperands(String content) {
        List<String> operands = new ArrayList<>();
        int level = 0;
        StringBuilder currentOperand = new StringBuilder();
        
        for (char c : content.toCharArray()) {
            if (c == ',' && level == 0) {
                operands.add(currentOperand.toString());
                currentOperand.setLength(0);  // Reset for next operand
            } else {
                if (c == '(') level++;      // Going deeper into nested expression
                if (c == ')') level--;      // Coming back to outer level
                currentOperand.append(c);
            }
        }
        
        // Add the last operand
        operands.add(currentOperand.toString());
        
        return operands;
    }
    public static void main(String[] args) {
        String expression="|(f,&(t,t))";
        System.out.println(parseBoolExprItr(expression));
    }
    
}