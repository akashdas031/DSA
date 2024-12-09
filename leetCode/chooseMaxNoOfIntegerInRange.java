 package DSA.leetCode;
 
 public class chooseMaxNoOfIntegerInRange {
 
    public static int maxCount(int[] banned, int n, int maxSum) {
        int count=0;
        int SumOfChoosen=0;
        for(int i=1;i<=n;i++){
            if(notPresent(banned,i) && SumOfChoosen<=maxSum){
                count++;
                SumOfChoosen+=i;
            }
        }
        return count;
    }
    public static boolean notPresent(int[] banned,int num){
        for(int i=0;i<banned.length;i++){
            if(banned[i]==num){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums={1,6,5};
        System.out.println(maxCount(nums, 5, 6));
    }
    
 }