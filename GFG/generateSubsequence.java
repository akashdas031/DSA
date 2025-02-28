package DSA.GFG;

import java.util.ArrayList;
import java.util.List;

public class generateSubsequence {
    
    //using bitmasking
    public static List<String> getSubsequence(String s){
        List<String> subsequence=new ArrayList<>();
        
        int n=s.length();
        
        for(int mask=0;mask<(1<<n);mask++){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                if((mask &(1<<i)) != 0){
                    sb.append(s.charAt(i));
                }
            }
            subsequence.add(sb.toString());
        }
        return subsequence;
    }
    //using recursion backtracking
    public static List<String> getSubsequenceRecursion(String s){
        List<String> result=new ArrayList<>();
        helper(s,0,"",result);
        return result;
    }
    public static void helper(String s,int index,String curr,List<String> result){
        if(index==s.length()){
            result.add(curr);
            return;
        }
        helper(s,index+1,curr+s.charAt(index),result);
        helper(s,index+1,curr,result);
    }
    //for arrays
    public static List<List<Integer>> getSubsequenceArray(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helperArray(nums,0,curr,result);
        return result;
    }
    public static void helperArray(int[] nums,int index,List<Integer> curr,List<List<Integer>> result){
        if(index>=nums.length){
            result.add(new ArrayList<>(curr));
            return ;
        }
        curr.add(nums[index]);
        helperArray(nums,index+1,curr,result);
        curr.remove(curr.size()-1);
        helperArray(nums,index+1,curr,result);

    }
    //using bitmasking subsequence for array
    public static List<List<Integer>> getSubsequenceArrays(int[] nums){
        List<List<Integer>> result=new ArrayList<>();

        int n=nums.length;
        for(int mask=0;mask<(1<<n);mask++){
            List<Integer> curr=new ArrayList<>();

            for(int i=0;i<n;i++){
                if((mask &(1<<i)) != 0){
                    curr.add(nums[i]);
                }
            }
            result.add(new ArrayList<>(curr));
        }
        return result;
    }
    public static void main(String[] args) {
        // String s="abc";
        // List<String> resRec=getSubsequenceRecursion(s);
        // List<String> res=getSubsequence(s);
        // System.out.println("using recursion : "+resRec);
        // System.out.println("without using recursion : "+res);
        int[] nums={1,2,3};
        List<List<Integer>> result=getSubsequenceArrays(nums);
        System.out.println(result);
    }
}
