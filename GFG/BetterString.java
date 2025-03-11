package DSA.GFG;

import java.util.HashMap;
import java.util.Map;

public class BetterString {
    public static int getSubsequenceCount(String str){
        Map<Character,Integer> map=new HashMap<>();
        
        int count=1;
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int prev=count;
            count=2*count;
            
            if(map.containsKey(ch)){
                count-=map.get(ch);
            }
            map.put(ch,prev);
        }
        return count;
    }
    public static String betterString(String str1, String str2) {
        int count1=getSubsequenceCount(str1);
        int count2=getSubsequenceCount(str2);
        System.out.println(count1);
        
        return count1>=count2?str1:str2;
    }
    public static void main(String[] args) {
        String res=betterString("gfgf", "ggg");
        System.out.println(res);
    }
}
