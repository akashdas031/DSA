package DSA.leetCode;

import java.util.*;
class equalRowColumnPairs {
    public static void main(String[] args) {
       
        int[][] grid={
            {3,1,2,2},
            {1,4,4,4},
            {2,4,2,2},
            {2,5,2,2}
        };
        int m=grid.length;
        int n=grid[0].length;
       List<String> singleArray=new ArrayList<String>();
        for(int i=0;i<m;i++){
            StringBuilder sb=new StringBuilder();
           for(int j=0;j<n;j++){
            sb.append(grid[j][i]).append(",");
           }
           singleArray.add(sb.toString());
        }
        int count=0;
        System.out.println(singleArray);
        for(int[] nums:grid){
            StringBuilder sbs=new StringBuilder();
            for(int nn:nums){
                sbs.append(nn).append(",");
            }
            for(String s:singleArray){
                if(sbs.toString().equals(s)){
                    count++;
                }
            }
            System.out.println(sbs.toString());
        }
        System.out.println(count);
    }
}
