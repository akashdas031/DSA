package DSA.leetCode;
import java.util.*;
/**
 * sumOfDigitsOfString
 */
public class sumOfDigitsOfString {
//Fix this one not getting proper answer implement using get digitsum method
    public static int getLucky(String s, int k) {
       List<Integer> l=new ArrayList<>();
       for(char ch:s.toCharArray()){
        l.add(ch+'0');
       }
       int sum=0;
       for(int i=0;i<l.size();i++){
        int curr=0;
        int n=l.get(i);
        if(n>10){
          while(n>0){
            curr+=(n%10);
            n/=10;
          }
          sum+=curr;
        }else{
            sum+=l.get(i);
        }
       }
       for (int i = 1; i < k; i++) {
          sum=digitSum(sum);
       }
       return sum;
    }
    private static int digitSum(int num){
        if(num==0){
            return 0;
        }
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        String s="hvmhoasabaymnmsd";
        System.out.println(getLucky(s, 1));
    }
}