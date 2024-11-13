package DSA.Strings;

import java.util.Arrays;

public class reverseWordOfSentence {
    public static String reverse(String s){
        String ans="";
        String[] res=s.split(" ");
        System.out.println(Arrays.toString(res));
        for(String word:res){
           String a=reverseWord(word);
           ans+=" "+a;
        }
        
        return ans;
    }
    public static String reverseWord(String word){
        String res="";
        for(int i=word.length()-1;i>=0;i--){
            res+=word.charAt(i);
        }
        return res;
    }
    public static void main(String[] args) {
        String word="Hey this is Akash";
        System.out.println(reverse(word));
    }
}
