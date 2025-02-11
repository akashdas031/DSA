package DSA.GFG;

public class sumOfSeries {

    public static int getSumOfSeries(int n){
        return sum(n,0);
    }
    public static int sum(int n,int sum){
        if(n==0) return sum;

        return sum(n-1,sum+(n*n*n));
    }
    public static void main(String[] args) {
        System.out.println(
            getSumOfSeries(5)
        );
    }
}