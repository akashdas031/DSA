package DSA.leetCode;

import java.util.Stack;

/**
 * NumberOfInsertParanthesisToMakeValid
 */
public class NumberOfInsertParanthesisToMakeValid {
    public static int minimumInsertion(String s){
        int open=0;
        int unbalanced=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                //directly increase the value of open
                open++;
            }else{
                //here we encountered a closing bracket
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    if(open>=1){
                        //if next bracket is closing and before also a opening bracket is present then 
                        //we will decrease the value of opening as it will be balanced 
                        open--;
                        
                    }else{
                        //if closing bracket is present after current bracket and opening is not present then 
                        //we need one opening to make it balance so we will increase the value of unbalanced by 1
                        unbalanced++;
                    }
                    //here as after current character a closing bracket is present then we will skip the next character also
                    //as we have processed that already
                    i++;
                }else{
                    //If closing bracket is present but after the closig bracket is not available or current character is the last closing bracket
                    if(open>=1){
                        //if before the current character if opening bracket is present then we need one closing bracket to make the pair balanced 
                        // so we will increase the unbalanced value by 1 and decrease the open value to 1 that together the opening and current bracket just need 
                        //one closing to be balanced
                        open--;
                        unbalanced++;
                    }else{
                        //if no opening present then we need two brackets to make the current character balanced 
                        //one opening and one closing so we will increase the unbalanced value by 2
                        unbalanced+=2;
                    }
                }
            }
            
        }
        //we will return the total number of unbalanced for one '(' we need 2 ')' so we will multiply it by 2
        //and return all the nomber of brackets required to make the string valid
        return unbalanced+=2*open;
    }
    
    //using stack    
    public static int minInsertions(String s) {
            Stack<Character> stack=new Stack<>();
            int count=0;
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c == '('){
                    stack.push(c);
                }
                else{
                    if(i+1<s.length()&& s.charAt(i+1)==')'){
                       
                        i++;
                    }
                    else {
                        count++;
                    }
                    
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        count++;
                    }
                }
            }
            count += 2*stack.size();
            return count;
        }
        public static void main(String[] args) {
            String s=")))()()";
            System.out.println(minimumInsertion(s));
         }
    
}