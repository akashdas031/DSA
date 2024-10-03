package DSA.Algorithms;

public class HuffMan {
    public static void main(String[] args) throws Exception {
        String str="abbccda";
        HoffManCoder huffman=new HoffManCoder(str);
        String enc= huffman.encode(str);
        System.out.println(enc);
        String dec=huffman.decode(enc);
        System.out.println(dec);
    }
}
