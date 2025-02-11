package DSA.GFG;

public class binarySearchRecursion {
    public static int search(int[] nums,int target,int start,int end){
        if(start>end)return -1;

        int mid=start+(end-start)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]<target){
            return search(nums,target,mid+1,end);
        }
        return search(nums,target,start,mid-1);
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        System.out.println(search(nums,4,0,nums.length-1));
    }
}
