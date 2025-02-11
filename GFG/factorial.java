package DSA.GFG;

import java.util.ArrayList;

public class factorial {
    // public static int getFactorial(int n){
    //     return factorial(n,1);
    // }
    // public static int factorial(int n,int factorial){

    //     if(n==1) return factorial;
    //     return n*factorial(n-1,factorial);
    // }
    // public static void printFactorialTilln(int n){
    //     for(int i=1;i<=n;i++){
    //         if(getFactorial(i)<n){
    //             System.out.print(getFactorial(i)+" ");
    //         }
    //     }
    // }
     static void getFactorial(long n,long current,long fact,ArrayList<Long> result){
        if(fact>n) return;
        result.add(fact);
        getFactorial(n,current+1,fact*(current+1),result);
        
    }
    static ArrayList<Long> factorialNumbers(long n) {
       ArrayList<Long> result=new ArrayList<>();
       getFactorial(n,1,1,result);
       return result;
    }
    public static void main(String[] args) {
         System.out.println(factorialNumbers(5));
        
    }
}
