package DSA.Sorting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * countSort
 */
public class countSort {


    //get the max number from the array
    public static int getMax(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                max=num;
            }
        }
        return max;
    }
    public static void sortUsingHashMap(int[] nums){
        Map<Integer,Integer> countMap=new HashMap<>();
        int max=getMax(nums);
        int min=Arrays.stream(nums).min().getAsInt();
        for(int num:nums){
            countMap.put(num,countMap.getOrDefault(num, 0)+1);
        }
        int index=0;
        //get elements from min to max and store it in the nums
        for(int i=min;i<=max;i++){
            
            int count=countMap.getOrDefault(i, 0);
            for(int j=0;j<count;j++){
                nums[index]=i;
                index++;
            }
        }
    }

    //sorting using count sort
    public static void sort(int[] nums){
        //get the max number from the array
        int max=getMax(nums);
        //create a new array of which length is equal to the max number +1
        int[] ans=new int[max+1];
        //maintain a variable index to fetch the indices and frequency of the number 
        int index=0;
       //save the frequency of the array with a new integer array
        for(int num:nums){
            ans[num]++;
        }
        //now fetch the frequency and save in the original array
        for(int i=0;i<ans.length;i++){
            while(ans[i]>0){
               nums[index]=i;
               index++;
               ans[i]--;
            }
        }
        
    }
    
    public static void main(String[] args) {
        int []nums={5,4,3,2,1};
        sortUsingHashMap(nums);
        System.out.println(Arrays.toString(nums));
    }
}