package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;
 
public class ArrayOperations {

    //print all subarrays of an array

    public static void printAllPossibleSubarrays(int[] nums,int start,int end){
        if(start==nums.length){
            return;
        }
        if(end==nums.length){
            printAllPossibleSubarrays(nums, start+1, start+1);
            return;
        }
        print(nums,start,end);
        System.out.println();
        printAllPossibleSubarrays(nums, start, end+1); 
    }

    //find sum of all elements in an array
    public static int sumOfArrays(int[] nums,int sum,int index){
        if(index==nums.length){
            return sum;
        }
        sum=nums[index]+sumOfArrays(nums, sum, index+1);
        return sum;
    }

    //check if array is sorted

    public static boolean isSorted(int[] nums,int index){
        if(index==nums.length-1){
            return true;
        }
        return nums[index]<=nums[index+1] && isSorted(nums, index+1);
    }

    //print minimum element from the array using recursion
    
    public static int min(int[] nums,int index, int min){
        if(index==nums.length){
            return min;
        }
        return Math.min(min,min(nums,index+1,nums[index]));
    }

    //print max element of the array using recursion
    public static int max(int[] nums,int index,int max){
        if(index==nums.length){
            return max;
        }
        return Math.max(max,max(nums,index+1,nums[index]));
         
    }

    //print array in Reverse using recursion
    
    public static void printReverse(int[] nums,int index){
        if(index==nums.length){
            return;
        }
        
        printReverse(nums, index+1);
        System.out.print(nums[index]+" ");
    }

    //print 2D array recursion
    public static void printMatrix(int[][] matrix,int row,int col){
        if(row==matrix.length){
            return;
        }
        if(col==matrix[row].length){
            System.out.println();
            printMatrix(matrix, row+1, 0);
        }else{
            System.out.print(matrix[row][col]+" ");
            printMatrix(matrix, row, col+1);
        }
       
    }
    //print the array using recursion
    public static void print(int[] nums,int start,int end){
        if(start==end){
            return;
        }
        System.out.print(nums[start]+" ");
        print(nums, start+1, end);
    }
    //print subarrays
    public static void printSubarrays(int[] nums){
        List<List<Integer>> res=new ArrayList<>(); 
        for(int i=0;i<nums.length;i++){
            List<Integer> helper=new ArrayList<>();
            for(int j=i;j<nums.length;j++){
                helper.add(nums[j]);
                res.add(new ArrayList<>(helper));
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> helper=new ArrayList<>();
       // printSubarrayRecursion(nums,res,helper,0);
        printReverse(nums,0);
    // int[][] matrix={
    //     {1,2,3,4},
    //     {5,6,7,8},
    //     {9,10,11,12}
    // };
    // printMatrix(matrix, 0, 0);
    System.out.println();
    System.out.println(min(nums, 0, Integer.MAX_VALUE));
    System.out.println(isSorted(nums, 0));
    System.out.println(sumOfArrays(nums, 0, 0));
    printAllPossibleSubarrays(nums, 0, 0);
    }
}
