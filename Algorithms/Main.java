package DSA.Algorithms;

public class Main {
    public static void main(String[] args) {
        KarpRabin karpRabin=new KarpRabin();
        String sentence="helloworldfromakash";
        String pattern="akash";
        System.out.println(karpRabin.getMatchIndex(sentence, pattern));
    }
}
