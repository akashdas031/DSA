package DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class recursionForPattern {
    
    public static void printPattern(int row,int col){
       for(int i=0;i<row;i++){
           for(int j=i;j<col;j++){
               System.out.print("* ");
           }
           System.out.println();
       }
    }
    public static void printPatternRecursion(int row,int col){
        if(row==4){
            return;
        }
        if(col>row){
            
            printPatternRecursion(row,col-1);
            System.out.print("* ");
            
        }else{
            
            printPatternRecursion(row+1,4);
            System.out.println();
            
        }
    }
    
    public static ArrayList<ArrayList<Integer>> printSubarrays(int[] arr,int end){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<=end;i++){
            ArrayList<Integer> helper=new ArrayList<>();
            for(int j=i;j<=end;j++){
                
                helper.add(arr[j]);
                result.add(new ArrayList<>(helper));
            }
            
            
        }
        return result;
    }
    //descending order
    public static void bubbleSort(int[] arr,int start,int end){
        if(start==end) return;
        
        if(end>start){
            if(arr[end]>arr[end-1]){
                int temp=arr[end];
                arr[end]=arr[end-1];
                arr[end-1]=temp;
            }
            bubbleSort(arr,start,end-1);
        }else{
            bubbleSort(arr,start+1,end);
        }
        
    }
    public static void bubblesort(int[] arr,int start,int end){
        if(start==end) return;
        
        if(end<start){
            if(arr[end]>arr[end+1]){
                int temp=arr[end];
                arr[end]=arr[end+1];
                arr[end+1]=temp;
            }
            bubblesort(arr,start,end+1);
        }
            bubblesort(arr,start-1,end);
    }
    public static void selectionSort(int[] arr,int start,int end,int max){
        if(start==0) return;
        
        if(end<start){
            if(arr[end]>arr[max]){
                selectionSort(arr,start,end+1,end);
            }else{
                selectionSort(arr,start,end+1,max);
            }
        }else{
            int temp=arr[max];
            arr[max]=arr[start-1];
            arr[start-1]=temp;
            selectionSort(arr,start-1,0,0);
        }
    }
    public static void main(String[] args) {
        //printPatternRecursion(0,4);
        int[] arr={5,4,2,1,3};
        // ArrayList<ArrayList<Integer>> res=printSubarrays(arr,arr.length-1);
        // bubbleSort(arr,0,arr.length-1);
        selectionSort(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
}
