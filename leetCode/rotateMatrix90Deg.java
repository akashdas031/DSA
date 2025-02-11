package DSA.leetCode;

import java.util.Arrays;

public class rotateMatrix90Deg {
    public static void rotate90Deg(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix={
            {0,1,2,0},
            {3,4,5,2},
            {1,3,1,5},
            {1,3,1,5}
        };
        rotate90Deg(matrix);
       for(int i=0;i<matrix.length;i++){
        Arrays.toString(matrix[i]);
       }
    }
}
