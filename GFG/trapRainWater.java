package DSA.GFG;

import java.util.Arrays;

public class trapRainWater {
    public static int maxWater(int arr[]) {
        int n=arr.length;
        int[] left=new int[n];
        int prevMax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            left[i]=Math.max(arr[i],prevMax);
            prevMax=Math.max(prevMax,arr[i]);
        }
        System.out.println(Arrays.toString(left));
        int[] right=new int[n];
        int rightMax=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            right[i]=Math.max(arr[i],rightMax);
            rightMax=Math.max(rightMax,arr[i]);
        }
        System.out.println(Arrays.toString(right));
        int totalWater=0;
        for(int i=0;i<arr.length;i++){
            int currWater=Math.min(left[i],right[i])-arr[i];
            totalWater+=currWater;
        }
        return totalWater;
    }
    public static void main(String[] args) {
        int[] arr={3,0,1,0,4,0,2};
        System.out.println(maxWater(arr));
    }
}
