package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintNumbersUsingREcursion {

    public static List<Integer> multiplyRes(int num,List<Integer> res){
        if(num==1){
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
       //System.out.println(multiply(5));
       List<Integer> res=multiplyRes(5, new ArrayList<>());
       System.out.println(res); 
    }
}
