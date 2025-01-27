package DSA.leetCode;

public class longestCommonPrefix {

    public static String longestPrefix(String[] strs){
        if(strs==null || strs.length==0) return "";

        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) !=0){
                if(prefix.length()==0) return "";
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(longestPrefix(strs)); 
    }
}