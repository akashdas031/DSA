package DSA.Strings;

public class reverseString {
    public static String reverse(String s){
        String st="";
        for(int i=s.length()-1;i>=0;i--){
           st+=s.charAt(i);
        }
        return st;
    }
    public static void main(String[] args) {
        String word="Hello World";
        String reversed=reverse(word);
        System.out.println(reversed);
    }
}
