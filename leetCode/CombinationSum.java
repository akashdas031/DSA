package DSA.leetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSumIII(int k,int n){
        List<List<Integer>> result=new ArrayList<>();
        helperCombinationSumIII(n,k,1,result,new ArrayList<>());
        return result;
    }
    public static void helperCombinationSumIII(int n,int k,int currNum,List<List<Integer>> result,List<Integer> curr){
        if(curr.size()==k && n==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()>k || n<0){
            return;
        }
        for(int i=currNum;i<=n;i++){
            curr.add(i);
            helperCombinationSumIII(n-i, k, i+1, result, curr);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> result=combinationSumIII(3, 7);
        System.out.println(result);
    }
}
