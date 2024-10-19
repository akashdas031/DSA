package DSA.leetCode;

import java.util.PriorityQueue;

/**
 * longestHappyString
 * https://leetcode.com/problems/longest-happy-string/description/?envType=daily-question&envId=2024-10-16
 */
public class longestHappyString{

     private static class Pair{
        char ch;
        int freq;
        Pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((p,q)->q.freq-p.freq);
        if(a>0){
            maxHeap.offer(new Pair('a',a));
        }
        if(b>0){
            maxHeap.offer(new Pair('b',b));
        }
        if(c>0){
            maxHeap.offer(new Pair('c',c));
        }
        StringBuilder result=new StringBuilder();
        while(!maxHeap.isEmpty()){
            Pair first=maxHeap.poll();
            int n=result.length();
            //check whether the last two characters are  the current character
            /*if the last two characters are the current character then poll the character having 2nd most frequency
             * and append it to the result and then decrease the number of time the character added to the res and again 
             * if the frequency is not 0 then push it to the max heap priority queue and after that push the first pair to the queue
             */
            if(n>=2 && result.charAt(n-1)==first.ch && result.charAt(n-2)==first.ch){
                 //check if all characters are processed then break 
                 if(maxHeap.isEmpty()){
                    break;
                 }
                 Pair second=maxHeap.poll();
                 result.append(second.ch);
                 second.freq--;
                 if(second.freq>0){
                    maxHeap.offer(second);
                 }
                 maxHeap.offer(first);
            }else{
                /*if the last two characters are not the same character then add the current character 2 times 
                 * if it's freqency is more than 2 and decrease the freqency by 2
                */
                int addCount=Math.min(2,first.freq);
                for(int i=0;i<addCount;i++){
                    result.append(first.ch);
                }
                first.freq-=addCount;
                if(first.freq>0){
                    maxHeap.offer(first);
                }
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 3, 7));
    }
}