package DSA.Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import DSA.CustomDataStructures.MinHeap;

/**
 * HoffManCoder
 */
public class HoffManCoder {

    Map<Character,String> encoder;
    Map<String,Character> decoder;
    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;
        public Node(Character data,int cost){
            this.data=data;
            this.cost=cost;
            this.left=null;
            this.right=null;
        }
        @Override
        public int compareTo(Node other) {
            return this.cost-other.cost;
        }
    }
    public HoffManCoder(String feeder) throws Exception{
        HashMap<Character,Integer> freqMap=new HashMap<>();
        for (int i = 0; i < feeder.length(); i++){
            char cc=feeder.charAt(i);
            if(freqMap.containsKey(cc)) {
                int ov = freqMap.get(cc);
                ov += 1;
                freqMap.put(cc, ov);
              } else {
                freqMap.put(cc, 1);
              }
        }
        MinHeap<Node> minHeap=new MinHeap<>();
        Set<Map.Entry<Character,Integer>> entrySet=freqMap.entrySet();
        for(Map.Entry<Character,Integer> entry:entrySet){
            Node node=new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }
        while(minHeap.size() != 1){
           Node first=minHeap.remove();
           Node second=minHeap.remove();
           Node newNode=new Node('\0', first.cost+second.cost);
           newNode.left=first;
           newNode.right=second;
           minHeap.insert(newNode);
        }
        Node ft=minHeap.remove();
        this.encoder=new HashMap<>();
        this.decoder=new HashMap<>();
        this.initEncoderDecoder(ft,"");
        
    }
    private void initEncoderDecoder(Node node, String osf) {
       if(node==null){
        return;
       }
       if(node.left==null && node.right==null){
        this.encoder.put(node.data, osf+"0");
        this.decoder.put(osf+"1",node.data);
       }
      
    }
    //encoding
    public String encode(String source){
      String ans="";
      for(int i=0;i<source.length();i++){
        ans=ans+encoder.get(source.charAt(i));
      }
      return ans;
    }
    //decoding
    public String decode(String encodedString){
       String key="";
       String ans="";
       for (int i = 0; i < encodedString.length(); i++) {
         key=key+encodedString.charAt(i);
         if(decoder.containsKey(key)){
            ans=ans+decoder.get(key);
            key="";
         }
       }
       return ans;
    }
   
}