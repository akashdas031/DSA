package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class getOccurencesOfANumber{
    
    //check the array is sorted or not
    public static boolean isSorted(int[] arr,int index){
        if(index==arr.length-1) return true;
        
        return arr[index]<arr[index+1] && isSorted(arr,index+1);
    }
    //check the array is sorted or not (starting compare from the end of the array)
    public static boolean isSortedCheckFromLast(int[] arr,int index){
        if(index == 0) return true;
        
        return arr[index-1]<arr[index] && isSortedCheckFromLast(arr,index-1);
    }
    //check whether the element is present in the array using recursion
    public static int search(int[] nums,int target,int index){
        if(index==nums.length){
            return -1;
        }
        if(nums[index]==target){
            return index;
        }
        return search(nums,target,index+=1);
    }
    //search element in an array and start the search from the end of the array
    public static int searchFromEnd(int[] nums,int target,int index){
        if(index==-1){
            return -1;
        }
        if(nums[index]==target){
            return index;
        }
        return searchFromEnd(nums,target,index-=1);
    }
    //get All Occurences of an element in the array by taking the result list as the method parameter
    public static List<Integer> getAllOccurences(int[] nums,int target,int index,ArrayList<Integer> result){
        if(index==nums.length){
            return result;
        }
        if(nums[index] == target){
            result.add(index);
        }
        return getAllOccurences(nums,target,index+=1,result);
    }
    //get all occurences of an element from the array by taking the result list outside the method
    static ArrayList<Integer> indexValues=new ArrayList<>();
    public static void getAllOccurence(int[] nums,int target,int index){
        if(index==nums.length){
            return;
        }
        if(nums[index] == target){
            indexValues.add(index);
        }
        getAllOccurence(nums,target,index+=1);
    }
    //get All Occurences of an element from the array by taking the result list inside the method body
    public static ArrayList<Integer> getAllOccurences(int[] nums,int target,int index){
        ArrayList<Integer> result=new ArrayList<>();
        if(index==nums.length)return result;
        if(nums[index]==target){
            result.add(index);
        }
        ArrayList<Integer> list=getAllOccurences(nums,target,index+1);
        result.addAll(list);
        return result;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,5,4,5};
        System.out.println(getAllOccurences(nums,5,0));
    }
}