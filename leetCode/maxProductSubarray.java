package DSA.leetCode;
import java.util.List;
import java.util.ArrayList;
public class maxProductSubarray {
    //get max product of the sub array Brute force approach
    /*
     * Time complexity is O(n^2)=O(n)*O(n-i) and ignoring constant it will be O(n^2)
     * and Space complexity is O(n)*O(n-i) not efficient
     */
    public static int getMaxProductSubarray(List<List<Integer>> nums){
        int max=Integer.MIN_VALUE;
        for(List<Integer> num:nums){
            int prod=1;
            for(int n:num){
                 prod*=n;
                 if(prod>max){
                    max=prod;
                 }
            }
        }
        System.out.println("Max : "+max);
        return max;
    }
    //returns all subArray of the array
    public static List<List<Integer>> getSubArray(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> helper=new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                helper.add(nums[j]);
                res.add(new ArrayList<>(helper));
            }
        }
        return res;
    }
   
        public static int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0; // Handle empty input
            }
    
            int maxProduct = nums[0];
            int minProduct = nums[0];
            int result = nums[0];
    
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    // Swap max and min when a negative number is encountered
                    int temp = maxProduct;
                    maxProduct = minProduct;
                    minProduct = temp;
                }
    
                maxProduct = Math.max(nums[i], maxProduct * nums[i]);
                minProduct = Math.min(nums[i], minProduct * nums[i]);
    
                result = Math.max(result, maxProduct);
            }
            return result;
        }
        public static int maxProductB(int[] nums) {
            int maxProduct = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int product = 1;
                for (int j = i; j < nums.length; j++) {
                    product *= nums[j];
                    maxProduct = Math.max(maxProduct, product);
                }
            }
            return maxProduct;
        }
    
    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        System.out.println(maxProductB(nums));
    }
}
