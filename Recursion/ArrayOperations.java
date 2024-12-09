package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;
 
public class ArrayOperations {

    

    //rotate matrix to 90 degree
    public static void rotateNinetyDegree(int[][] matrix){
        for(int i=0;i<matrix[0].length;i++){
            for(int j=matrix.length-1;j>=0;j--){
                System.out.print(matrix[j][i]+" ");
            }
            System.out.println();
        }
    }

    //spiral printing of matrix
    public static void spiralPrinting(int[][] matrix){
        int top=0;
        int buttom=matrix.length-1;
        System.out.println(buttom);
        int left=0;
        int right=matrix[0].length-1;
        while(top<=buttom && left<=right){
            for(int i=left;i<=right;i++){
                System.out.print(matrix[top][i]+" ");
            }
            top++;
            for(int i=top;i<=buttom;i++){
                System.out.print(matrix[i][right]+" ");
            }
            right--;
            if(top<=buttom){
                for(int i=right;i>=left;i--){
                System.out.print(matrix[buttom][i]+" ");
            }
            buttom--;
            }
            if(left<=right){
                for(int i=buttom;i>=top;i--){
                    System.out.print(matrix[i][left]+" ");
                }
                left++;
            }
        }
    }

    //reverse diagonal order in top to buttom order
    public static void printDiagonalRev(int [][]matrix){
        for(int sum=0;sum<matrix.length+matrix[0].length-1;sum++){
            for(int col=0;col<=sum;col++){
                int row=sum-col;
                if(col<matrix[0].length && row<matrix.length){
                    System.out.print(matrix[row][col]+" ");
                }
            }
        }
    }

    //in down to top order
    public static void printDiagonal(int[][] matrix){
        for(int sum=0;sum<matrix.length+matrix[0].length+1;sum++){
            for(int row=0;row<=sum;row++){
                int col=sum-row;
                if(row<matrix.length && col<matrix[0].length){
                    System.out.print(matrix[row][col]+" ");
                }
            }
        }
    }

    //print 2D matrix Col wise
    public static void printColWise(int[][] matrix,int row,int col){

        //run untill the last col
        if(col==matrix[0].length){
            return;
        }
        //when the row reaches at the buttom then start a new row and move col to next col
        if(row==matrix.length){
            System.out.println();
            printColWise(matrix, 0, col+1); 
        }else{
            //else continue with the same col and move till last row
            System.out.print(matrix[row][col]+" ");
            printColWise(matrix, row+1, col);
        }
       

    }

    //print Tables recursion
    public static void printTables(int n){
        if(n==0){
            return;
        }
        printTables(n-1);
        System.out.println("Table for : "+n);
        for(int i=1;i<=10;i++){
           
            System.out.print(n+" * "+i+" = "+ n * i);
            System.out.println();
        }
        System.out.println();

    }

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
      //  printReverse(nums,0);
    int[][] matrix={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12} 
    };
    // printMatrix(matrix, 0, 0);
    // System.out.println();
    // System.out.println(min(nums, 0, Integer.MAX_VALUE));
    // System.out.println(isSorted(nums, 0));
    // System.out.println(sumOfArrays(nums, 0, 0));
    // printAllPossibleSubarrays(nums, 0, 0);
     //printTables(5);
    //  printColWise(matrix, 0, 0);
    //  printDiagonalRev(matrix);
     //spiralPrinting(matrix);
     rotateNinetyDegree(matrix);
    }
}
