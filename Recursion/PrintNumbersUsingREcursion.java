package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintNumbersUsingREcursion {

    
    //reverse word of sentense without changing their order 
    public static String reverseSentense(String sentense){
        String reversedSentense="";
        String[] words=sentense.split(" ");
        for(String word:words){
             reversedSentense+=" "+reverse(word);
        }
        return reversedSentense;
    }
    //using substring
    public static String reverse(String s){
        if(s.isEmpty()){
            return s;
        }
        return reverse(s.substring(1))+s.charAt(0);
    }

     //Reverse a String using recursion basic recursion
    public static String reverse(String s,int length,String res){
        if(length<0){
            return res;
        }
        res+=s.charAt(length);
       
       return  reverse(s, length-1,res);
       
    }

    //Binary Search using Recursion
    public static int binarySearchUsingRecursion(int[] nums,int start,int end,int num){
        //if start cross the end then the element we are searching in available in the array so return -1
        //base case where the recursion call stops
        if(start>end){
            return -1;
        }
        //calculate the mid and check whether the target element is greater than the mid element 
        //of less than the mid element .if greater then reduce the array size to mid+1 to end and if smaller 
        //then reduce the array size to start to end-1 and if the mid equals to the target then return the mid element
        int mid=start+(end-start)/2;
        if(num==nums[mid]){
            return mid;
        }
        if(num>nums[mid]){
           return binarySearchUsingRecursion(nums, mid+1, end, num);
        }else{
            return binarySearchUsingRecursion(nums, start, mid-1, num);
        }
    }

    //find factorial till n numbers
    public static long factorial(int num){
        if(num==1){
            return num;
        }
        long factorial=num*factorial(num-1);
        return factorial;
    }

    //Fibonaci series till n number
    public static int fibonaciList(int num){
       if(num==0 || num==1){
        return num;
       }
       int fib=fibonaciList(num-1)+fibonaciList(num-2);
       return fib;
    }

    //return all the nums in a list till n using recursion
    public static List<Integer> multiplyRes(int num,List<Integer> res){
        if(num==0){
            return res;
        }
        res.add(num);
        return multiplyRes(num-1, res);

    }

    //multiplication of numbers till n using recursion

    public static int multiply(int num){
        if(num==1){
            return num;
        }
        int res=num*multiply(num-1);
        return res;
    }

    //sum of numbers till n using recursion
    public static int sum(int num){
        //base case
        if(num==0){
            return num;
        }
        //add number to the sum and made recursion call for next number and return the sum after recursion call ends
        int sum=num+sum(num-1);
        return sum;

    }

    //print in reverse order
    public static void printNumberRev(int num){
        if(num==0){
            return;
        }
        System.out.print(num+" ");
        printNumberRev(num-1);
    }
    //print in original order till n
    public static void printNumber(int num){
        if(num==0){
            return;
        }
       printNumber(num-1);
       System.out.print(num+" ");
    }
    public static void main(String[] args) {
    // System.out.println(factorial(50));
    // List<Integer> res=multiplyRes(5, new ArrayList<>());
       String s="Hello World , This is Akash ";
       //System.out.println(reverse(s,s.length()-1,""));
       System.out.println(reverseSentense(s));
    // int []nums={1,2,3,4,5,6};
    // System.out.println(binarySearchUsingRecursion(nums, 0, nums.length-1, 6));
    }
}
