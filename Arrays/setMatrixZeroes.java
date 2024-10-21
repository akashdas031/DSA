package DSA.Arrays;

import java.util.ArrayList;

import java.util.List;

public class setMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        List<Integer> row=new ArrayList<>();
        List<Integer> col=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==0){
                   row.add(i);
                   col.add(j);
               }
           }
        }
        for(int num:row){
           for(int i=0;i<matrix[0].length;i++){
               matrix[num][i]=0;
           }
        }
        for(int val:col){
           for(int i=0;i<matrix.length;i++){
               matrix[i][val]=0;
           }
        }
   
   
        }
   public static void main(String[] args) {
    int[][] matrix={{0,1}};
    setZeroes(matrix);
    System.out.print("[");
    for(int[] rows:matrix){
        System.out.print("[");
        for(int num:rows){
            System.out.print(" ");
            System.out.print(num+" ");
        }
        System.out.print("]");
       
    }
    System.out.print("]");
    
   }

}
