package DSA.Algorithms;

import java.util.BitSet;

public class HuffMan {
    public static void main(String[] args) throws Exception {
        String str="huffman";
        HoffManCoder huffman=new HoffManCoder(str);
        String enc= huffman.encode(str);
        System.out.println(enc);
        String dec=huffman.decode(enc);
        System.out.println(dec);
        int a=0;
        int b=1;
        System.out.println(a);
        System.out.println(b);
        for (int i=2;i<=5;i++){
            int c=a+b;
            System.out.println(c);
            a=b;
            b=c;
        }
    }
}
