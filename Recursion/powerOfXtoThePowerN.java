package DSA.Recursion;

public class powerOfXtoThePowerN{
    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            x=1/x;
            n=-1*n;
        }
        return helper(x,n);
    }
    public static double helper(double x,int n){
        if(n==0) return 1;

        double half=helper(x,n/2);

        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
    public static void main(String[] args) {
       System.out.println(myPow(2, -10));
    }
}