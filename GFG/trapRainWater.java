package DSA.GFG;

import java.util.Arrays;
import java.util.Stack;

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
    //optimal Solution

    public static int maxWaterOptimal(int arr[]) {
        int left=1;
        int right=arr.length-2;
        
        int lMax=arr[left-1];
        int rMax=arr[right+1];
        
        int result=0;
        
        while(left<=right){
            if(rMax<=lMax){
                result+=Math.max(0,rMax-arr[right]);
                rMax=Math.max(rMax,arr[right]);
                right-=1;
            }else{
                result+=Math.max(0,lMax-arr[left]);
                lMax=Math.max(lMax,arr[left]);
                left+=1;
            }
        }
        return result;
    }
    //using stack
   public static int maxWaterUsingStack(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
           
            // Pop all items smaller than arr[i]
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {          
                
                int pop_height = arr[st.pop()];

                if (st.isEmpty())
                    break;

                // arr[i] is the next greater for the removed item
                // and new stack top is the previous greater 
                int distance = i - st.peek() - 1;

                // Take the minimum of two heights (next and prev greater)
                int water = Math.min(arr[st.peek()], arr[i]);

                // Find the amount of water
                water -= pop_height;
                
                res += distance * water;
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={3,0,1,0,4,0,2};
        System.out.println(maxWaterUsingStack(arr));
    }
}
