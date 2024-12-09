package DSA.Arrays;

import java.util.*;

public class MatrixTraversal {

    

    //reverse diagonal traversal
    public static void revDiagonal(int[][] matrix){
        for (int sum = 0; sum < matrix.length + matrix[0].length - 1; sum++) {
            // Loop through each element in the diagonal
            for (int row = 0; row <= sum; row++) {
                int col = sum - row;
                // Ensure the row and column are within bounds of the matrix
                if (row < matrix.length && col < matrix[0].length) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }

    //Diagonal traversal
    public static void diagonalUp(int[][] matrix){
        for(int row=0;row<matrix.length+matrix[0].length-1;row++){
           for(int col=0;col<=row;col++){
              int diagonal=row-col;
              if(col<matrix.length && diagonal<matrix[0].length){
                System.out.print(matrix[col][diagonal]+" -> ");
              }
           }
        }
    }
    //ZigZag traversal Column wise
    public static void zigZagCol(int[][] matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            
                if(i%2==0){
                    for (int j = 0; j < matrix.length; j++) {
                        System.out.print(matrix[j][i]+" -> ");
                    }
                }else{
                    for (int j = matrix.length-1; j >=0; j--) {
                        System.out.print(matrix[j][i]+" -> ");
                    }
                }
               
        }
    }
    //ZigZag traversal row wise
    public static void zigZag(int[][] matrix){
        System.out.print("START -> ");
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length && row%2==0;col++){
                    System.out.print(matrix[row][col]+" -> "); 
            }
            for(int col=matrix[0].length-1;col>=0 && row%2!=0;col--){
                    System.out.print(matrix[row][col]+" -> "); 
            }
        }
        System.out.print(" END");
    }
    //column wise traversal
    public static void columnWiseTraversal(int[][] matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i]+" -> ");
            }
        }
    }
    //Row wise
    public static void simpleTraversal(int[][] matrix){
        System.out.print("[   ");
        System.out.println();
        for(int i=0;i<matrix.length;i++){
            System.out.print("    [ ");
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" -> ");
            }
            System.out.print(" ]");
            System.out.println();
        }
        System.out.println();
        System.out.println("]");
    }
    public static void main(String[] args) {
       int[][] matrix={
         {1,2,3,4},
         {5,6,7,8},
         {9,10,11,12},
         {13,14,15,16},
         {17,18,19,20}
       } ;
       revDiagonal(matrix);
    }
}
