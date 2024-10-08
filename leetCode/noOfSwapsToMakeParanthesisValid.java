package DSA.leetCode;

/**
 * Leet Code
 * 1963. Minimum Number of Swaps to Make the String Balanced
 */
public class noOfSwapsToMakeParanthesisValid {

     
    //using iteration
    public static int getNoOfSwaps(String s){
        int openParanthesis=0;
        int unbalancedParanthesis=0;
        for(char ch:s.toCharArray()){
            if(ch=='['){
                openParanthesis++;
            }else{
                if(openParanthesis>0){
                    openParanthesis--;
                }else{
                    unbalancedParanthesis++;
                }
            }
        }
        return (unbalancedParanthesis+1)/2;
    }
    public static void main(String[] args) {
        String s="]]][[][[[";
        System.out.println(getNoOfSwaps(s));
    }
}