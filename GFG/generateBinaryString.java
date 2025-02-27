package DSA.GFG;

public class generateBinaryString{
    public static void generate(int n,String s){
        if(s.length()==n){
            System.out.println(s);
            return;
        }
        generate(n,s+"0");
        generate(n,s+"1");
    }
    public static void main(String[] args){
        generate(3,"");
    }
}