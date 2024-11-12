package DSA.Strings;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * substring
 */
public class substring {

   
    
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
       
        System.out.println(res);
        
    }
}
