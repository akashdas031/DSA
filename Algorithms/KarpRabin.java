package DSA.Algorithms;

public class KarpRabin {
    private int prime=101;
    private long calculateHash(String pattern){
        long hash=0;
        for(int i=0;i<pattern.length();i++){
            hash+=pattern.charAt(i)*Math.pow(prime,i);
        }
      return hash;
    }
    private long updateHash(long oldHash,char oldChar,char newChar,int patternLength){
        long newHash=(oldHash-oldChar)/prime;
        newHash+=newChar*Math.pow(prime,patternLength-1);
        return newHash;
    }
    public int getMatchIndex(String sentence,String pattern){
        int patternLength=pattern.length();
        long patternHash=calculateHash(pattern);
        long sentenceHash=calculateHash(sentence.substring(0,patternLength));
        int matchingIndex=-1;
        for(int i=0;i<=sentence.length()-patternLength;i++){
            if(patternHash==sentenceHash){
                if(sentence.substring(i, i+patternLength).equals(pattern)){
                  matchingIndex=i;
                }
            }
            if(i<sentence.length()-patternLength){
                sentenceHash=updateHash(sentenceHash, sentence.charAt(i), sentence.charAt(i+patternLength), patternLength);
            }
        }
        return matchingIndex;
    }
}
