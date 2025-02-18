package DSA.Recursion;
public class PatternUsingRecursion {
    public static void printPattern1(int row,int col){
        if(row==0) return;

        if(col<row){
            System.out.print("* ");
            printPattern1(row,col+1);
        }else{
            System.out.println();
            printPattern1(row-1,0);
        }
    }
    public static void main(String[] args) {
        printPattern1(5, 0);
    }
}
