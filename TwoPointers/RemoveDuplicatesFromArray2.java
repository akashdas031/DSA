package DSA.TwoPointers;

public class RemoveDuplicatesFromArray2 {

    public static int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int start=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i] != nums[start-2]){
                nums[start]=nums[i];
                start++;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] nums={1,1,1,1,2,2,2,3,3,4,5,5,5,6};
        System.out.println(removeDuplicates(nums));
    }
}