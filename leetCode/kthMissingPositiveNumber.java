package DSA.leetCode;

public class kthMissingPositiveNumber {

    public static int getKthMissing(int []arr,int k){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) k++; //shifting k
            else break;
        }
        return k;
    }
    public static void main(String[] args) {
        int[] nums={2,3,4,7,11};
        System.out.println(getKthMissing(nums, 7));
    }
}