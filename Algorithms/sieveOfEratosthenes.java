package DSA.Algorithms;

import java.util.Arrays;

public class sieveOfEratosthenes {
    //This algorithm states first we will create an array of size n and mark all the elements of the array as 1
    //we will start from 1st index and check if number is prime and the value is 1 in the prime array then we will mark all 
    //it's multiple till n to 0 as they are not prime numbers
    //we will go till last element and mark all the m ultiples of prime number as 0 
    //at the end of the loop in the prime array the number which are prime will be left with value 1. We can print it or we can use it for other computations
    public static void printPrimes(int n){
        int[] primes=new int[n+1];
        Arrays.fill(primes, 1);
        for(int i=2;i*i<=n;i++){
            if(primes[i]==1){
            for(int j=i*i;j<=n;j+=i){
               primes[j]=0;
            }
        }
        }
        for(int i=2;i<n;i++){
            if(primes[i]==1){
                System.out.print(i+" ");
            }
        }
    }
    public static void printPrimesIgnoreEven(int n){
        //Rather creating an array of size n to store primes we can ignore the even numbers as they are multiple of 2
        //and we can iterate and mark as 2*i+1 as 0 if not prime and is multiple of prime
        //then we can iterate the prime array and print all the numbers which are marked as 1 by multiplying 2*index+1
        int[] primes=new int[n/2];
        Arrays.fill(primes, 1);
        for(int i=1;i*i<n/2;i++){
            int pr=2*i+1;
            if(primes[i]==1){

            for(int j=(pr*pr)/2;j<n/2;j+=pr){
               primes[j]=0;
            }
        }
        }
        for(int i=1;i<n/2;i++){
            if(primes[i]==1){
                System.out.print(2*i+1+" ");
            }
        }
    }
    public static void main(String[] args) {
        printPrimesIgnoreEven(100);
    }
}
