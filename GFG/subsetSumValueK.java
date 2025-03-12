package DSA.GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class subsetSumValueK {
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> result=new ArrayList<>();
        helper(arr,0,0,result);
        return result;
    }
    public static void helper(int[] arr,int index,int sum,List<Integer> result){
        if(index==arr.length){
            
            result.add(sum);
            //if we have to add without duplicates then we have to add a condition before adding the
            // sum to the result if present then ignore that and if not then add the sum
            return ;
        }
        
        helper(arr,index+1,sum+arr[index],result);
         helper(arr,index+1,sum,result);
        
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        ArrayList<Integer> result=subsetSums(arr);
        Collections.sort(result);
        System.out.println(result);
    }
}
