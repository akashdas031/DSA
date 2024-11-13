package DSA.Strings;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * substring
 */
public class substring {

    //using recursion
    public static void getSubstringRecursion(String s,String current,int index){
        //take index from 0 and the base case will be when the length will be equals to the length of the String
          if(index==s.length()){
            if(!current.isEmpty()){
                System.out.println(current);
            }
            return;
        }
        //at the beginning take an empty string as argument and take characters from string from start to end
        //made recursion by  including the character at index
        getSubstringRecursion(s, current+s.charAt(index), index+1);
        //made recursion call by not including character from the string
        getSubstringRecursion(s, current, index+1);
    }
    
    //get all possible substring of a string with duplicate
    public static List<String> getSubstring(String s){
       List<String> res =new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String helper="";
            for (int j = i; j < s.length(); j++) {
                helper+=s.charAt(j);
                res.add(helper);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s="abcde";
        List<String> res=getSubstring(s);
       
        getSubstringRecursion(s, "", 0);
        
    }
}
