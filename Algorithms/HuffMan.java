package DSA.Algorithms;

import java.util.BitSet;

public class HuffMan {
    public static void main(String[] args) throws Exception {
        String str="abbccda";
        HoffManCoder huffman=new HoffManCoder(str);
        BitSet enc= huffman.encodeBitset(str);
        System.out.println(enc);
        String dec=huffman.decodeBitset(enc,str.length());
        System.out.println(dec);
    }
}
