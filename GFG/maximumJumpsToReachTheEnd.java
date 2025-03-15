package DSA.GFG;
public class maximumJumpsToReachTheEnd {
    public static int getMaxJumpsRequired(int[] arr){
        if(arr.length==0) return 0;
        if(arr[0]==0) return -1;
        int jumps=0;
        int currIndex=0;
        int farthestJump=0;
        for(int i=0;i<arr.length;i++){
            farthestJump=Math.max(farthestJump,i+arr[i]);
            if(i==currIndex){
                jumps++;
                currIndex=farthestJump;
                if(currIndex>=arr.length) return jumps;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(getMaxJumpsRequired(arr));
    }
}
