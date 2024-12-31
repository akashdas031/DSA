package DSA.leetCode;

public class removeDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums){
        int i=1;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] !=nums[j-1]){
                nums[i++]=nums[j];
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] nums={1,2,2,3,3,4,4,4,5,6,7,7,8};
        System.out.println(removeDuplicates(nums));
    }
}
