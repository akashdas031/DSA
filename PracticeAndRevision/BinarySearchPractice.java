package DSA.PracticeAndRevision;
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class BinarySearchPractice {
    public static void bubbleSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length-i;j++){
                if(nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
    }
    public static int binarySearch(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int firstOccurence(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else{
                result=mid;
                end=mid-1;
            }
        }
        return result;
    }
    public static int lastOccurence(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else{
                result=mid;
                start=mid+1;
            }
        }
        return result;
    }
    public static int positionToInsertTarget(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else{
                //if the target element is present in the array then return the index of the element 
                return mid;
            }
        }
        //if the element is not present inside the array then the start will be the position where the target element will be inserted
        return start;
    }
    public static void main(String[] args) {
        int[] nums={1,2,2,2,3,5};
       // bubbleSort(nums);
        System.out.println(positionToInsertTarget(nums,2));
    }
}